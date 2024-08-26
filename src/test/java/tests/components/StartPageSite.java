package tests.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.data.Links;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPageSite {
    private final SelenideElement searchString = $("._input_1su1z_19");
    private final ElementsCollection
            gridCatalog = $$(".grid__catalog .x-product-card__card"),
            genderWrapper = $$("._genderWrapper_i3n1m_74 a"),
            menuWrapper = $$("._menuWrapper_i3n1m_94 a");

    public StartPageSite querySearch(String value) {
        searchString.setValue(value).pressEnter();
        return this;
    }

    public StartPageSite checkSearchResultsIsNotEmpty() {
        gridCatalog.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public StartPageSite checkButtonContainUrl(Links links) {
        genderWrapper
                .findBy(attribute("data-genders", links.name()))
                .shouldHave(attribute("href", links.description));
        return this;
    }

    public StartPageSite setGender(Links links) {
        genderWrapper
                .findBy(attribute("data-genders", links.toString())).click();
        return this;
    }

    public StartPageSite checkMenuContainsCorrectButtons(List<String> expectedButtons) {
        menuWrapper
                .filter(visible)
                .shouldHave(texts(expectedButtons));
        return this;
    }
}
