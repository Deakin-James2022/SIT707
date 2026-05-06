package web.service;
import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {
    // Equivalence Class: Valid Input
    @Test
    public void testValidLogin() {
        Assert.assertTrue(
                LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    // Equivalence Class: Invalid Username
    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(
                LoginService.login("wrong", "ahsan_pass", "1990-01-01"));
    }

    // Equivalence Class: Invalid Password
    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(
                LoginService.login("ahsan", "wrong", "1990-01-01"));
    }

    // Equivalence Class: Invalid DOB
    @Test
    public void testInvalidDob() {
        Assert.assertFalse(
                LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    // Boundary Value: Empty String
    @Test
    public void testEmptyInput() {
        Assert.assertFalse(
                LoginService.login("", "", ""));
    }

    // Boundary Value: Null
    @Test
    public void testNullInput() {
        Assert.assertFalse(
                LoginService.login(null, null, null));
    }

    // Exception: Invalid DOB Format
    @Test
    public void testInvalidDobFormat() {
        Assert.assertFalse(
                LoginService.login("ahsan", "ahsan_pass", "01-01-1990"));
    }

    // Decision Table: Multiple Errors
    @Test
    public void testMultipleFailures() {
        Assert.assertFalse(
                LoginService.login("wrong", "wrong", "2000-01-01"));
    }

    // Boundary: Trim
    @Test
    public void testTrimInput() {
        Assert.assertTrue(
                LoginService.login(" ahsan ", " ahsan_pass ", "1990-01-01"));
    }
}
