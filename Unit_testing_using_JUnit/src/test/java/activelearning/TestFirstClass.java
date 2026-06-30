package activelearning;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestFirstClass {
    private FirstTest firstTest = new FirstTest();
    // add() Tests
    @Test
    public void testAddBothZeroReturnsZero() {
        assertEquals(0, firstTest.add(0, 0));// a = 0, b = 0
    }
    @Test
    public void testAddZeroNonZeroReturnsPositive() {
        assertEquals(2, firstTest.add(0, 2));// a = 0, b = 2
    }
    @Test
    public void testAddNonZeroZeroReturnsPositive() {
        assertEquals(2, firstTest.add(2, 0));// a = 2, b = 0
    }
    @Test
    public void testAddNegativeZeroReturnsNegative() {
        assertEquals(-2, firstTest.add(-2, 0));// a = -2, b = 0
    }
    @Test
    public void testAddZeroNegativeReturnsNegative() {
        assertEquals(-2, firstTest.add(0, -2));// a = 0, b = -2
    }

    // Overflow test
    @Test
    public void testAddVeryLargeNumberAndNormalIntegerOverflow() {
        int result = firstTest.add(Integer.MAX_VALUE, 2);
        assertEquals(Integer.MIN_VALUE + 1, result);// a = Integer.MAX_VALUE, b = 2
    }
    @Test
    public void testAddNormalIntegerAndVeryLargeNumberOverflow() {
        int result = firstTest.add(2, Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE + 1, result);// a = 2, b = Integer.MAX_VALUE
    }

    /**
     * No Decimal, add() only accept int.
     * Placeholder test to document invalid input.
     */
    @Test
    public void testAddDecimalAndIntegerCompileTimeBreak() {
        assertTrue(true);
    }
    @Test
    public void testAddIntegerAndDecimalCompileTimeBreak() {
        assertTrue(true);
    }
    @Test
    public void testAddDecimalAndDecimalCompileTimeBreak() {
        assertTrue(true);
    }
    // concat() Tests
    @Test
    public void testConcatSingleCharactersReturnsCombinedString() {
        assertEquals("ab", firstTest.concat("a", "b"));// a = "a", b = "b"
    }
    @Test
    public void testConcatSingleCharacterAndEmptyStringReturnsSameCharacter() {
        assertEquals("a", firstTest.concat("a", ""));// a = "a", b = ""
    }
    @Test
    public void testConcatNullAndCharacterReturnsNullCharacterString() {
        assertEquals("nulla", firstTest.concat(null, "a"));// a = null, b = "a"
    }
    @Test
    public void testConcatCharacterAndNullReturnsCharacterNullString() {
        assertEquals("anull", firstTest.concat("a", null));// a = "a", b = null
    }
    @Test
    public void testConcatBothNullReturnsNullNullString() {
        assertEquals("nullnull", firstTest.concat(null, null));// a = null, b = null
    }
}
