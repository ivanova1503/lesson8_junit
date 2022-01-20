package dex.ivanova;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


// @Disabled класс не будет запускаться

@DisplayName("Класс с тестами сравнивает 3 и 2")
public class SimpleTest {

    @Test
   // @Disabled тест не будет запускаться
    @DisplayName("Тест проверяет, что 3 < 2")
    void test() {
        Assertions.assertTrue(3 < 2);
    }


    @Test
    @DisplayName("Тест проверяет, что 3 > 2")
    void test1() {
        Assertions.assertTrue(3 > 2);
    }



}