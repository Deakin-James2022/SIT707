package sit707_tasks;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Random;
import org.junit.Assert;
//import org.junit.Test;
/**
 * @author JUNJIE LU
 */
public class DateUtilTest {
	@Test
	public void testStudentIdentity() {
		String studentId = "s226032637";
		Assert.assertNotNull("Student ID is null", studentId.isEmpty());
	}
	@Test
	public void testStudentName() {
		String studentName = "JUNJIE LU";
		Assert.assertNotNull("Student name is null", studentName.isEmpty());
	}
	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	/*
	 * Two test cases to test the minimum range of January are created with empty functions 
	 * where you need to fill in the code with proper logic.
	 */
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("january1ShouldIncrementToJanuary2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());//normal min+1
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("january1ShouldDecrementToDecember31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());//across year + across month : min-1
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());//decrement() across year
//	    Assert.assertEquals("31 December 2023", date.toString());
	}
//	@ParameterizedTest
//	@CsvSource({
//	    "1,6,1994,2,6,1994",
//	    "30,6,1994,1,7,1994",
//	    "15,6,2024,16,6,2024"
//	})
	@Test
	public void testLeapYearFebruary28ShouldIncrementToFebruary29() {
	    // Leap year: Feb 28 -> Feb 29
	    DateUtil date = new DateUtil(28, 2, 2024);
	    System.out.println("Feb28ShouldIncrementToFeb29 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}
	@Test
	public void testLeapYearFebruary29ShouldIncrementToMarch1() {
	    // Leap year: Feb 29 -> Mar 1
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("Feb29ShouldIncrementToMar1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}
	@Test
	public void testLeapYearMarch1ShouldDecrementToFebruary29() {
	    // Leap year: Mar 1 -> Feb 29
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("Mar1ShouldDecrementToFeb29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}
	@Test
	public void testLeapYearFebruary29ShouldDecrementToFebruary28() {
	    // Leap year: Feb 29 -> Feb 28
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("Feb29ShouldDecrementToFeb28 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(28, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}
	@Test
	public void testNonLeapYearFebruary29ShouldBeInvalid() {
	    // 2023 is NOT a leap year → Feb 29 invalid
	    Assert.assertThrows(RuntimeException.class, () -> {
	        new DateUtil(29, 2, 2023);
	    });
	}
}
