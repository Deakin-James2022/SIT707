package programmingknowledge;
import org.junit.Assert;
import org.junit.Test;

public class ConcatTest {
    @Test
    public void test() {
        MyJUnitClass junit = new MyJUnitClass();
        String result = junit.concat("Hello", "World");
        Assert.assertEquals("HelloWorld", result);
    }
}
