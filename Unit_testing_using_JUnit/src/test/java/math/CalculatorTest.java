package math;
import org.junit.Test;
import org.junit.Assert;

//import math.Calculator;

public class CalculatorTest {
	private Calculator calculator = new Calculator();
	@Test
	public void testMultiplyCorrect() {
		Assert.assertEquals(calculator.multiply(2, 3), 6);
	}
}
