import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    private Cat cat;
    private final String expectedSound = "Мяу"; //объявляем переменную sound

    @Mock
    private Feline feline; //создали мок

    @Before
    public void createCat(){
        cat = new Cat(feline);
    }

    @Test //проверка, что возвращает Мау
    public void testGetSound(){
        String actualSound = cat.getSound();
        Assert.assertEquals("Не соответствует ожидаемому звуку", expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Не соответствует ожидаемому набору еды", expectedFood, actualFood);
    }

}
