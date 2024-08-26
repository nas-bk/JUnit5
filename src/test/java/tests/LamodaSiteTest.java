package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.components.StartPageSite;
import tests.data.Links;

import java.util.List;
import java.util.stream.Stream;

import static tests.data.Constants.*;

@DisplayName("Тесты для главной страницы сайта Lamoda")
public class LamodaSiteTest extends TestBase {

    StartPageSite startPageSite = new StartPageSite();

    @ValueSource(strings = {"IRO", "Befree"})
    @DisplayName("Поисковой запрос должен отдавать не пустой список карточек")
    @ParameterizedTest(name = "Поисковой запрос {0}")
    void searchResultsShouldNotBeEmpty(String query) {
        startPageSite
                .querySearch(query)
                .checkSearchResultsIsNotEmpty();
    }

    @EnumSource(Links.class)
    @DisplayName("Кнопки меню должны содержать ссылки")
    @ParameterizedTest(name = "Проверка ссылки для кнопки {0}")
    void menuItemShouldContainExpectedUrl(Links links) {
        startPageSite.checkButtonContainUrl(links);
    }


    static Stream<Arguments> menuShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Links.women,
                        MENU_BUTTONS
                ),
                Arguments.of(
                        Links.men,
                        MENU_BUTTONS
                ),
                Arguments.of(
                        Links.kids,
                        MENU_BUTTONS_KIDS
                )
        );
    }

    @MethodSource
    @DisplayName("Раздел должен содержать корректный список кнопок")
    @ParameterizedTest(name = "проверка списка для раздела {0}")
    void menuShouldDisplayCorrectButtons(Links links, List<String> expectedButtons) {
        startPageSite
                .setGender(links)
                .checkMenuContainsCorrectButtons(expectedButtons);
    }


}
