package programmingknowledge;
import org.junit.Test;
import org.junit.Assert;

public class AddTest {
//	@Test
//	public final void test() {
//		fail("Not yet implemented");
//	}
	
	
	
	@Test
    public void test() {
        MyJUnitClass junit = new MyJUnitClass();
        int result = junit.add(100, 200);
        Assert.assertEquals(300, result);
    }
	
	
	
}
