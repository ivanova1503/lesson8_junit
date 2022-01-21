package dex.ivanova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class Homework_lesson8 {


    @BeforeEach
    void beforeEach() {
        System.out.println("Запуск теста");
    }



    @CsvSource(value= {
            "lesson",
            "JUnit",
            "test"
    }
    )


    @ParameterizedTest(name= "Тестирование поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {

        Selenide.open("https://github.com/ivanova1503");
        Selenide.$("input[type='text']").setValue(testData).submit();
        Selenide.$$("li.repo-list-item")
                .first()
                .shouldHave(Condition.text(testData));
    }

}




