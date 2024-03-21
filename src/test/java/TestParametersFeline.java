import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class TestParametersFeline {
    private final int kittensCounts;
    private final int kittensExpectedCounts;

    Feline feline = new Feline();

    public TestParametersFeline(int kittensCounts, int kittensExpectedCounts){
        this.kittensCounts = kittensCounts;
        this.kittensExpectedCounts = kittensExpectedCounts;
    }

    @Parameterized.Parameters
    public static Object [][] getKittensInfo(){
        return new Object[][]{
                {0,0},
                {5,5},
                {10,10},
        };
    }

    @Test
    public void testParametersFeline(){
        Assert.assertEquals("Количество котят не соответствует ожидаемому количеству", kittensExpectedCounts, feline.getKittens(kittensCounts));
    }

}
