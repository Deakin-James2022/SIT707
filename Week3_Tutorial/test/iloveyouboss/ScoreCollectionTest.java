package iloveyouboss;
//import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import Module2.ScoreCollection;
import static org.hamcrest.MatcherAssert.assertThat;
//import org.hamcrest.MatcherAssert;

public class ScoreCollectionTest {
    @Test
    public void checkArithmeticMeanOfTwoNumbers() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);
        int actualResult = collection.arithmeticMean();
        
//        Assert.assertThat(actualResult, equalTo(6));// out of date
        assertThat(actualResult, equalTo(6));
//        MatcherAssert.assertThat(actualResult, equalTo(6));
        
    }
}
