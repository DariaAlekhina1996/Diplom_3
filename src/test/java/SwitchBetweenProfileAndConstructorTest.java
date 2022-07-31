import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.stellarburgers.pageobjects.*;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class SwitchBetweenProfileAndConstructorTest extends BaseTest {
    private static ConstructorPage constructorPage;
    private String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";

    public SwitchBetweenProfileAndConstructorTest(WebDriver _driver) {
        super(_driver);
    }

    @Before
    public void init() {
        WebDriverRunner.setWebDriver(BaseTest.driver);
        constructorPage = open(constructorPageUrl, ConstructorPage.class);
    }

    @After
    public void close() {
        BaseTest.driver.quit();
    }

    @Test
    @DisplayName("Check to switch from Profile to Constructor page by clicking logo")
    public void switchToConstructorPageByClickingLogo() {
        Steps.goToProfilePage(constructorPage).click();

        SelenideElement logoStellarBurgers = constructorPage.getLogoStellarBurgers();
        logoStellarBurgers.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(constructorPageUrl, containsString(currentUrl));
    }

    @Test
    @DisplayName("Check to switch from Profile to Constructor page by clicking 'Constructor' button")
    public void switchToConstructorPageByClickingButton() {
        Steps.goToProfilePage(constructorPage).click();
        ElementsCollection headerTabs = constructorPage.getHeaderTabs();

        SelenideElement constructorButton = headerTabs.findBy(Condition.text("Конструктор"));
        constructorButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(constructorPageUrl, containsString(currentUrl));
    }
}

