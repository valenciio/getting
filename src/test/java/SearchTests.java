import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successfulSearchTest1() {
        open("https://www.google.com/");
        $x("//textarea[@name='q']").setValue("selenide1111").pressEnter();
        $x("//div[@id='search']").shouldHave(text("https://ru.selenide.org"));
    }
    private static String getMessage() {
        return "selenide1111";
    }
    @Test
    void successfulSearchTest2() {
        open("https://www.google.com/");
        $x("//textarea[@name='q']").setValue("mos.ru").pressEnter();
        $x("//div[@id='rcnt']").shouldHave(text("https://www.mos.ru"));
    }
    @Test
    void successfulSearchTest3() {
        open("https://ya.ru/");
        $x("//input[@name='text']").setValue("mos.ru").pressEnter();
        $x("//a[@href='https://www.mos.ru/']").shouldBe(visible);
    }
}
