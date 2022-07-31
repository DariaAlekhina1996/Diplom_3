import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.stellarburgers.pageobjects.ConstructorPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;

public class SwitchToProfilePageTest extends BaseTest {
    private static ConstructorPage constructorPage;
    private String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";
    private String profilePageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    public SwitchToProfilePageTest(WebDriver _driver) {
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
    @DisplayName("Check to switch to Profile page")
    public void switchToProfilePage() {
        SelenideElement userProfileButton = Steps.goToProfilePage(constructorPage);
        userProfileButton.click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(1000) + "@yandex.ru", "password");
        Steps.registration(registration);

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        userProfileButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(profilePageUrl, containsString(currentUrl));
    }
}
