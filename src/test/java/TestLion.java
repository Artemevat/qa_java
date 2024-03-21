
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    private static final String TEXT_EXCEPTION_SEX_UNSUPPORTED = "Используйте допустимые значения пола животного - самей или самка";
    private static final String MALE = "Самец";
    private Lion lion;

    @Mock
    private Feline feline; //создали мок

    @Before
    public void createLion() throws Exception{
        lion = new Lion(MALE, feline);
    }

    @Test //ловит неподдерживаемый пол, сравнивает текст
    public void testLionHasMAneException() {
        try {
            Assert.assertTrue(lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals(TEXT_EXCEPTION_SEX_UNSUPPORTED, exception.getMessage());
        }
    }

    @Test //тест вызова метода один раз
    public void testGetKittens() throws Exception{
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test //вызов метода getFood с любым аргументом типа String
    public void testGetFood() throws Exception{
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }
}
