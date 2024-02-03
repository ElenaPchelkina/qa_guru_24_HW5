package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiSearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void codeForJUnit () {
        // открыть Selenide в Github
        open("/selenide/selenide");
        // перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // раскрыть весь список страниц
        $(byText("Show 3 more pages…")).click();
        // проверить, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        // открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        // проверить, что внутри есть пример кода для JUnit5
        $(".Layout-main").shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}
