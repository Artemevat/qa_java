import com.example.Feline;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline extends TestCase {
    private final String expectedFamily = "Кошачьи"; //объявляем переменную семейства
    private static final int EXPECTED_KITTENS_COUNT = 1; //количество котят getKittens
    private int kittensExpectedCount = 3;

    private Feline feline;

    @Before
    public void createFeline(){
        feline = new Feline();
    }

    @Test //проверка, что выводится нужный список еды
    public void testEatMeat () throws Exception{
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals("Не соответствует ожидаемому списку еды", expectedFood, actualFood);
    }

    @Test //проверка что Feline семейства кошачьих
    public void testGetFamily() {
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Не соответсвует семейству expectedFamily", expectedFamily, actualFamily);
    }

    @Test //тест возвращает одного котенка
    public void testGetKittens(){
        int actualKittensCount = feline.getKittens();
        Assert.assertEquals("Количество котят не соответствует ожидаемому количеству EXPECTED_KITTENS_COUNT", EXPECTED_KITTENS_COUNT, actualKittensCount);
    }

    @Test //тест с определенным количеством котят
    public void testGetKittensWithCount(){
        int actualKittensCount = feline.getKittens(kittensExpectedCount);
        Assert.assertEquals("Количество котят не соответствует ожидаемому количеству kittensCount", kittensExpectedCount,actualKittensCount);
    }

}
