package dex.ivanova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedWebTest {


    static String str;
    @BeforeAll
    static void beforeAll() {
        str ="!";
        //общие данные для всех тестов, например токен, другие тестовые данные
    }


    // будет три разных теста и три записи beforeEach
    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }


    static Stream <Arguments> commonSearchTestDataProvider() { //аргументы с разными типами данных в разном количесттве
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1","2")),
                Arguments.of("JUnit", true, List.of("3","4"))
        );
    }

    @MethodSource("commonSearchTestDataProvider")
    /*
    @CsvSource(value= {      //будет 2 запуска по два аргумета для проверки
            "Selenide, Вышла Selenide",
            "JUnit, 5 is the next generation of"
    }
    //если в тексте есть запятая, то будет ошибка, поэтому можно использовать delimeter=';' и тогдап будет делиться по ;
    )*/

    // @ValueSource(strings = {"selenide", "junit"})
   // @ValueSource(ints = {1, 2}) если бы мы искали цифры
    @ParameterizedTest(name= "Тестирование поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, boolean flag, List<String > list) {
        System.out.println("Flag: " + flag);
        System.out.println("List: " + list.toString());

        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));
    }

}
