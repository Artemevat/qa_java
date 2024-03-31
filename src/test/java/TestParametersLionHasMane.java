import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class TestParametersLionHasMane {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean hasMane;

    @Before
    public void createFeline(){
        feline = Mockito.mock(Feline.class);
    }

    public TestParametersLionHasMane(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionInfo(){
        return new Object[][]{
                {MALE, true},
                {FEMALE, false},
        };
    }

    @Test
    public void testParametersLionHasMane() throws Exception{
        lion = new Lion(sex, feline);
        boolean actualMane = lion.doesHaveMane();
        boolean expectedMane = hasMane;
        Assert.assertEquals("Не соответствует ожидаемому отличительному признаку пола", expectedMane, actualMane);

    }

}

