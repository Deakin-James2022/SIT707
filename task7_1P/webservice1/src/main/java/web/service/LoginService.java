package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 * Business logic to handle login functions.
 * @author JUNJIE LU
 */
public class LoginService {
	/**
	 * Static method returns true for successful login, false otherwise.
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
//		if ("ahsan".equals(username) && "ahsan_pass".equals(password)) {
//			return true;
//		}
//		return false;
		// Basic Parameter Validation (Prevent Null Values)
        if (username == null || password == null || dob == null) {
            return false;// Null check
        }
        // Trim + empty check
        username = username.trim();
        password = password.trim();
        dob = dob.trim();
        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;// !important
        }

        // Validate DOB Format (yyyy-MM-dd)
        LocalDate inputDob;
        try {
            inputDob = LocalDate.parse(dob);// DOB format validation
        } catch (DateTimeParseException e) {
            System.out.println("Invalid DoB format: " + dob);
            return false;
        }

        // Mock User Information in Database
        String expectedUsername = "ahsan";
        String expectedPassword = "ahsan_pass";
        LocalDate expectedDob = LocalDate.of(1990, 1, 1);

        // Triple Validation: Username + Password + DOB
        if (expectedUsername.equals(username)
                && expectedPassword.equals(password)
                && expectedDob.equals(inputDob)) {
            return true;
        }
        return false;
//      Decision logic
//      return expectedUsername.equals(username) && expectedPassword.equals(password) && expectedDob.equals(inputDob);
	}
}
