package web.service;
import org.junit.Assert;
import org.junit.Test;

public class UnitTestCases {
    // Valid input (Equivalence Class)
    @Test
    public void testValidLogin() {
        Assert.assertTrue(
                LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    // Invalid username
    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(
                LoginService.login("wrong", "ahsan_pass", "1990-01-01"));
    }

    // Invalid password
    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(
                LoginService.login("ahsan", "wrong", "1990-01-01"));
    }

    // Invalid dob
    @Test
    public void testInvalidDob() {
        Assert.assertFalse(
                LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    // Boundary: empty string
    @Test
    public void testEmptyInput() {
        Assert.assertFalse(
                LoginService.login("", "", ""));
    }

    // Boundary: null
    @Test
    public void testNullInput() {
        Assert.assertFalse(
                LoginService.login(null, null, null));
    }

    // Invalid format
    @Test
    public void testInvalidDobFormat() {
        Assert.assertFalse(
                LoginService.login("ahsan", "ahsan_pass", "01-01-1990"));
    }

    // Boundary: invalid date
    @Test
    public void testInvalidDateValue() {
        Assert.assertFalse(
                LoginService.login("ahsan", "ahsan_pass", "1990-13-01"));
    }

    // Decision table: multiple wrong inputs
    @Test
    public void testMultipleFailures() {
        Assert.assertFalse(
                LoginService.login("wrong", "wrong", "2000-01-01"));
    }

    // Boundary: trim input
    @Test
    public void testTrimInput() {
        Assert.assertTrue(
                LoginService.login(" ahsan ", " ahsan_pass ", "1990-01-01"));
    }
}
