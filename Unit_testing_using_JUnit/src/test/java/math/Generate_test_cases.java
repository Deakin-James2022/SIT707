package math;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Generate_test_cases {
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void testMultiplyPositivePositiveReturnsPositive() {
        assertEquals(6, calculator.multiply(2, 3));// Positive × Positive
    }
    @Test
    public void testMultiplyPositiveNegativeReturnsNegative() {
        assertEquals(-6, calculator.multiply(2, -3));// Positive × Negative
    }
    @Test
    public void testMultiplyNegativePositiveReturnsNegative() {
        assertEquals(-6, calculator.multiply(-2, 3));// Negative × Positive
    }
    @Test
    public void testMultiplyNegativeNegativeReturnsPositive() {
        assertEquals(6, calculator.multiply(-2, -3));// Negative × Negative
    }
    @Test
    public void testMultiplyZeroPositiveReturnsZero() {
        assertEquals(0, calculator.multiply(0, 5));// Zero × Positive
    }
    @Test
    public void testMultiplyPositiveZeroReturnsZero() {
        assertEquals(0, calculator.multiply(5, 0));// Positive × Zero
    }
    @Test
    public void testMultiplyZeroZeroReturnsZero() {
        assertEquals(0, calculator.multiply(0, 0));// Zero × Zero
    }
    @Test
    public void testMultiplyOneByNumberReturnsSameNumber() {
        assertEquals(8, calculator.multiply(1, 8));// One × Number
    }
    @Test
    public void testMultiplyNumberByOneReturnsSameNumber() {
        assertEquals(8, calculator.multiply(8, 1));// Number × One
    }
    @Test
    public void testMultiplyMaxValueByTwoOverflow() {
        int result = calculator.multiply(Integer.MAX_VALUE, 2);// int overflow
        assertEquals(-2, result);
    }
    @Test
    public void testMultiplyMinValueByNegativeOneOverflow() {
        int result = calculator.multiply(Integer.MIN_VALUE, -1);// int minimum value multiplied by -1
        assertEquals(Integer.MIN_VALUE, result);// overflow result remains Integer.MIN_VALUE
    }
}
