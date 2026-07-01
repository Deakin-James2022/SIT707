package SIT707test_code_generation3.add_another_function_of_subtracting2numbers_and_test;
import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class Analyse_prompt {
	private versatile_tool calculator;
    @Before
    public void setUp() {
        calculator = new versatile_tool();
    }

    // Test add()
    @Test
    public void testAddPositiveNumbers() {
        assertEquals(8, calculator.add(5, 3));
    }
    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-8, calculator.add(-5, -3));
    }
    @Test
    public void testAddZeroAndPositive() {
        assertEquals(5, calculator.add(0, 5));
    }
    @Test
    public void testAddMaxValueOverflow() {
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MAX_VALUE, 1));
    }

    // Test subtract()
    @Test
    public void testSubtractPositiveNumbers() {
        assertEquals(2, calculator.subtract(5, 3));
    }
    @Test
    public void testSubtractNegativeNumbers() {
        assertEquals(-2, calculator.subtract(-5, -3));
    }
    @Test
    public void testSubtractPositiveNegative() {
        assertEquals(8, calculator.subtract(5, -3));
    }
    @Test
    public void testSubtractNegativePositive() {
        assertEquals(-8, calculator.subtract(-5, 3));
    }
    @Test
    public void testSubtractZeroMinusPositive() {
        assertEquals(-5, calculator.subtract(0, 5));
    }
    @Test
    public void testSubtractPositiveMinusZero() {
        assertEquals(5, calculator.subtract(5, 0));
    }
    @Test
    public void testSubtractSameNumbers() {
        assertEquals(0, calculator.subtract(10, 10));
    }
    @Test
    public void testSubtractMinValueOverflow() {
        assertEquals(Integer.MAX_VALUE, calculator.subtract(Integer.MIN_VALUE, 1));
    }
}
