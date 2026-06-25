package SIT707.handle3_3.Testing_in_Selenium;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxTest {
    WebDriver driver;
    @Before
    public void setup() {
//        System.setProperty("webdriver.chrome.whitelistedIps", "192.168.x.x");// default permit 127.0.0.1
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver147_0_7727_117/chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new ClosePopupAds();
        driver.navigate().to("https://www.bunnings.com.au/register");
        
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// wait until page fully load
    }
    @After
    public void shutdown() {
    	
//    	if (driver != null) {// prevent driver from not initialized
//            driver.close();
//        }
    
    }
    @Test
    public void shouldBeAbleToSubmitForm() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver, 30);// fix NoSuchElementException
    	
    	// table
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uid"))).sendKeys("testemail@email.com");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("P@ssw0rd");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Zhang");// Explicit Wait
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("He");
//    	driver.findElement(By.id("postCode")).sendKeys("3111");
//    	driver.findElement(By.id("cuid")).sendKeys("testemail@email.com");
        
        // checkbox
    	WebElement promotionCheckBox = driver.findElement(By.id("communicationPrefFlag"));
//        WebElement promotionCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("communicationPrefFlag")));
    	System.out.println("Promotion Check Box is enabled: " + promotionCheckBox.isEnabled());
//    	System.out.println("element id caught by Selenium: " + promotionCheckBox.getTagName());
//    	System.out.println("element outerHTML: " + promotionCheckBox.getAttribute("outerHTML"));
    	
        Boolean isSelectedPMBox = promotionCheckBox.isSelected();
        if (!isSelectedPMBox) {
            promotionCheckBox.click();// click-check logic order
        }
        System.out.println("Terms and Conditions Check is selected: " + promotionCheckBox.isSelected());
        
//        System.out.println(WebDriverWait.class.getProtectionDomain().getCodeSource().getLocation());
//        List<WebElement> buttons = driver.findElements(By.tagName("button"));
//        for(WebElement btn : buttons) {
//            System.out.println(btn.getText());
//        }
        
//        driver.findElement(By.name("nds-pmd")).submit();// nds-pmd expired
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(
//                        By.cssSelector("button[type='submit']")
                		By.cssSelector("button[data-locator='input_CreateAccount']")
                ));
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", createAccountButton);
        FluentWait<WebDriver> load = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(500))
                .pollingEvery(Duration.ofMillis(1000));
        createAccountButton.click();
        
//        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        System.out.println("submitted website: " + driver.getCurrentUrl());
    }
}
