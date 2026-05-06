package web.service;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.After;
//import org.junit.Before;

public class LoginServiceTest {
	
//	private WebDriver driver;
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();// TODO Auto-generated catch block
		}
	}
	

/*	@Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/chromedriver144_0_7559_133/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
	private WebDriver initDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/chromedriver144_0_7559_133/chromedriver.exe");
        return new ChromeDriver();
    }
	private void loadPage(WebDriver driver) {
        driver.navigate().to("file:///D:/SIT707/SIT707OnTrack/java_projects/task7_1P/pages/login.html");
        sleep(3);
    }
    
/*	@Test
	public void testLoginSuccess() {
//		System.setProperty(
//				"webdriver.chrome.driver", 
//				"src/main/resources/chromedriver144_0_7559_133/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();		
//		System.out.println("Driver info: " + driver);
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		driver.navigate().to(
				"file:///D:/SIT707/SIT707OnTrack/java_projects/task7_1P/pages/login.html");
		sleep(3);
		
		// Find username element
//		WebElement ele = driver.findElement(By.id("username"));
//		ele.clear();
//		ele.sendKeys("ahsan");
		driver.findElement(By.id("username")).sendKeys("ahsan");
		
		// Find password element
//		ele = driver.findElement(By.id("passwd"));
//		ele.clear();
//		ele.sendKeys("ahsan_pass");
		driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
		
		// Find Submit button, and click on button.
//		ele = driver.findElement(By.cssSelector("[type=submit]"));
//		ele.submit();
		driver.findElement(By.id("dob")).sendKeys("1990-01-01");
		driver.findElement(By.cssSelector("[type=submit]")).submit();
		
		sleep(3);
		// On successful login, the title of page changes to 'success', otherwise 'fail'.
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "success");
		driver.close();
	}*/
	private void performLogin(WebDriver driver, String username, String password, String dob) {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys(dob);
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(3);
    }
	@Test
    public void testLoginSuccess() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ahsan", "ahsan_pass", "1990-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("success", title);
        driver.close();
    }
	
/*	@Test
    public void testLoginFail_WrongPassword() {
        driver.navigate().to("file:///D:/SIT707/SIT707OnTrack/java_projects/task7_1P/pages/login.html");
        sleep(3);
        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("wrong");
        driver.findElement(By.id("dob")).sendKeys("1990-01-01");
        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
    }*/
	@Test
    public void testLoginFail_WrongPassword() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ahsan", "wrong_pass", "1990-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_WrongUsername() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "wrong", "ahsan_pass", "1990-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_WrongDob() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ahsan", "ahsan_pass", "2000-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_EmptyInput() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "", "", "");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_InvalidDobFormat() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ahsan", "ahsan_pass", "01-01-1990");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_ShortUsername() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ab", "ahsan_pass", "1990-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginFail_ShortPassword() {
        WebDriver driver = initDriver();
        loadPage(driver);
        performLogin(driver, "ahsan", "123", "1990-01-01");
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);
        driver.close();
    }
	@Test
    public void testLoginSuccess_WithSpaces() {
        WebDriver driver = initDriver();
        loadPage(driver);

        performLogin(driver, " ahsan ", " ahsan_pass ", "1990-01-01");

        String title = driver.getTitle();
        Assert.assertEquals("success", title);

        driver.close();
    }
}
