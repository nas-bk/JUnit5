package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.lamoda.ru";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        open(Configuration.baseUrl);
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
