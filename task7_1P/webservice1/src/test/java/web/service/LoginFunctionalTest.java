package web.service;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionalTest {
    private WebDriver driver;
    private static final String URL = "file:///D:/SIT707/SIT707OnTrack/java_projects/task7_1P/pages/login.html";
    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/chromedriver144_0_7559_133/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    private void performLogin(String username, String password, String dob) {
        driver.navigate().to(URL);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dob);
        driver.findElement(By.cssSelector("[type=submit]")).submit();
    }
    private String getStatus() {
        return driver.findElement(By.id("status")).getText();
    }
    // Valid Input
    @Test
    public void testValidLogin() {
        performLogin("ahsan", "ahsan_pass", "1990-01-01");
        Assert.assertTrue(getStatus().contains("success"));
    }
    // Invalid Password
    @Test
    public void testInvalidPassword() {
        performLogin("ahsan", "wrong", "1990-01-01");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Invalid Username
    @Test
    public void testInvalidUsername() {
        performLogin("wrong", "ahsan_pass", "1990-01-01");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Invalid DOB
    @Test
    public void testInvalidDob() {
        performLogin("ahsan", "ahsan_pass", "2000-01-01");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Empty Input (Boundary Value)
    @Test
    public void testEmptyInput() {
        performLogin("", "", "");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Illegal DOB Format
    @Test
    public void testInvalidDobFormat() {
        performLogin("ahsan", "ahsan_pass", "01-01-1990");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Boundary: Short Username
    @Test
    public void testShortUsername() {
        performLogin("ab", "ahsan_pass", "1990-01-01");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Boundary: Short Password
    @Test
    public void testShortPassword() {
        performLogin("ahsan", "123", "1990-01-01");
        Assert.assertTrue(getStatus().contains("fail"));
    }
    // Boundary: Input with Leading/Trailing Spaces (Should Succeed After Trim)
    @Test
    public void testTrimInput() {
        performLogin(" ahsan ", " ahsan_pass ", "1990-01-01");
        Assert.assertTrue(getStatus().contains("success"));
    }
}
