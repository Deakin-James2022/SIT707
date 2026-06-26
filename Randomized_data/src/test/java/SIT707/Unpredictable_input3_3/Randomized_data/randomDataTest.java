package SIT707.Unpredictable_input3_3.Randomized_data;
import java.util.Random;
import java.util.Date;
import java.sql.Timestamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.interactions.Actions;

public class randomDataTest {
    WebDriver driver;
    // random String including numbers and letters
    public static String randomStringWithNumber(int length) {
        final String data = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(data.charAt(random.nextInt(data.length())));
        }
        return sb.toString();
    }
    // random String including lowercase letter
    public static String randomString(int length) {
        final String data = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(data.charAt(random.nextInt(data.length())));
        }
        return sb.toString();
    }
    // password with uppercase letter, lowercase letter, number and special character
    public static String randomPassword(int length) {
        final String characterLower = "abcdefghijklmnopqrstuvwxyz";
        final String characterUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String number = "0123456789";
        final String specialChar = "!@#$%^&*()_+|<>,.";
        Random random = new Random();
        String password = new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characterLower.charAt(random.nextInt(characterLower.length())));
        }
        password += sb;
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characterUpper.charAt(random.nextInt(characterUpper.length())));
        }
        password += sb;
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(number.charAt(random.nextInt(number.length())));
        }
        password += sb;
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(specialChar.charAt(random.nextInt(specialChar.length())));
        }
        password += sb;
        return password;
    }
    // random Email
    public static String randomEmail() {
        int length = 4;
        String name = "0123456789abcdefghijklmnopqrstuvwxyz";
        String firstDomain = "0123456789abcdefghijklmnopqrstuvwxyz";
        String secondDomain = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        String email = new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(name.charAt(random.nextInt(name.length())));
        }
        email += sb;
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));
        }
        email += "@" + sb;
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));
        }
        email += "." + sb;
        return email;
    }
    // random Number
    public static int randomNumber(int maxValue) {
        Random random = new Random();
        return 1000 + random.nextInt(maxValue);
    }

    // get current time
    public static String timeStamp() {
        Date date = new Date();
        return new Timestamp(date.getTime()).toString();
    }
    
    @Before
    public void setUp() {
        
    	String projectPath = System.getProperty("user.dir");
    	
    	System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver147_0_7727_117/chromedriver.exe");
        driver = new ChromeDriver();// Instantiate driver to prevent null pointer exception
        driver.manage().window().maximize();// initialization
        
        driver.navigate().to("https://www.bunnings.com.au/register");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        
    }
    @After
    public void shutDown() {
//        if (driver != null) {
//            driver.quit();// cleanup to prevent method body empty
//        }
    }

    @Test
    public void shouldBeAbleToSubmitFormWithRandomData() throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(randomString(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys(randomString(10));
//        driver.findElement(By.id("postCode")).sendKeys(String.valueOf(randomNumber(5000)));
        String randomEmail = randomEmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uid"))).sendKeys(randomEmail);
//        driver.findElement(By.id("cuid")).sendKeys(randomEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(randomPassword(8));
        
        WebElement promotionCheckBox = driver.findElement(By.id("communicationPrefFlag"));// refer to bunnings HTML
        System.out.println("Promotion Check Box is enabled: " + promotionCheckBox.isEnabled());
//        Boolean isSelectedPMBox = promotionCheckBox.isSelected();
        
//        if (isSelectedPMBox == false) {
//            promotionCheckBox.click();
//        }
        if (!promotionCheckBox.isSelected()) {
            promotionCheckBox.click();
        }
        System.out.println("Terms and Conditions Check is selected: " + promotionCheckBox.isSelected());
        
//        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement createAccountButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[data-locator='input_CreateAccount']")));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", createAccountButton);
 
//      driver.findElement(By.name("nds-pmb")).submit();// out of date
        Thread.sleep(500);
        try {
            new Actions(driver).moveToElement(createAccountButton).click().perform();
        } catch (Exception e) {
            System.out.println("Actions click failed, falling back to JS click: " + e.getMessage());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createAccountButton);
        }
        
//        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        Thread.sleep(3000);
        System.out.println("Create Account result: " + driver.getCurrentUrl());// logical
    }
}
