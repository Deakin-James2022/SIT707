package SIT707.handle3_3.Testing_in_Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.internal.WrapsElement;

public class ClosePopupAds extends ChromeDriver {
    // Selector to click X
    private final By closeAdLocator = By.xpath("//button[contains(text(),'×') or contains(@class,'close') or contains(@aria-label,'Close')]");

    public static WebElement unwrap(WebElement element) {// Selenium only support raw variable (RemoteWebElement). No self-defined variable in Selenium.
        WebElement current = element;
        while (current instanceof WrapsElement) {
            current = ((WrapsElement) current).getWrappedElement();
        }
        return current;
    }
    @Override
    public Object executeScript(String script, Object... args) {// teach Selenium how to executeScript self-defined variable
        Object[] unwrapped = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof WrapsElement) {
                unwrapped[i] = unwrap((WebElement) args[i]);
            } else {
                unwrapped[i] = args[i];
            }
        }
        return super.executeScript(script, unwrapped);
    }
    
    private void closeAdIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(this, 2);
            WebElement closeBtn = shortWait.until(ExpectedConditions.elementToBeClickable(closeAdLocator));
            closeBtn.click();
            Thread.sleep(300); // Ads disappear cartoon
        } catch (Exception e) {// if no pop-up Ads, do nothing
        }
    }
    // rewrite findElement()
    @Override
    public WebElement findElement(By by) {
        return new SafeWebElement(super.findElement(by), this);// instead of raw element
    }
    // rewrite findElements()
    @Override
    public List<WebElement> findElements(By by) {
//        List<WebElement> elements = super.findElements(by);// package element
        return super.findElements(by)
        		.stream()
                .map(el -> new SafeWebElement(el, this))
                .collect(java.util.stream.Collectors.toList());
    }

    private class SafeWebElement implements WebElement, WrapsElement {// Selenium auto-executeScript
        private final WebElement original;// package raw WebElement
        private final WebDriver driver;
        public SafeWebElement(WebElement original, WebDriver driver) {
            this.original = original;
            this.driver = driver;// Enhance click and input method
        }

        @Override
        public WebElement getWrappedElement() {// API to expose raw element
            return original;
        }
        
        // rewrite click()
        @Override
        public void click() {
            try {
                original.click();
            } catch (ElementClickInterceptedException e) {// if blocked by pop-up Ads
                closeAdIfPresent();// close Ads
                original.click();// try again
            }
        }

        // rewrite sendKeys()
        @Override
        public void sendKeys(CharSequence... keys) {
            try {
                original.sendKeys(keys);
            } catch (ElementNotInteractableException e) {// if element covered and non-interactive
                closeAdIfPresent();// close Ads
                original.sendKeys(keys);// try again
            }
        }

        // directly forward to raw element
        @Override public void clear() { original.clear(); }
        @Override public String getAttribute(String name) { return original.getAttribute(name); }
        @Override public String getCssValue(String propertyName) { return original.getCssValue(propertyName); }
        @Override public Point getLocation() { return original.getLocation(); }
        @Override public Dimension getSize() { return original.getSize(); }
        @Override public Rectangle getRect() { return original.getRect(); }
        @Override public String getTagName() { return original.getTagName(); }
        @Override public String getText() { return original.getText(); }
        @Override public boolean isDisplayed() { return original.isDisplayed(); }
        @Override public boolean isEnabled() { return original.isEnabled(); }
        @Override public boolean isSelected() { return original.isSelected(); }
        @Override public void submit() { original.submit(); }
        @Override public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException { return original.getScreenshotAs(target); }
        
        // findElement and findElements in SearchContext
        @Override
        public WebElement findElement(By by) {
            return new SafeWebElement(original.findElement(by), driver);// consistent double package
        }
        @Override
        public List<WebElement> findElements(By by) {
            return original.findElements(by)
                    .stream()
                    .map(el -> new SafeWebElement(el, driver))
                    .collect(Collectors.toList());
        }
    }
}
