import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.stellarburgers.pageobjects.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;


public class LogoutTest extends BaseTest {
    private static ConstructorPage constructorPage;
    private static String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";
    private static String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";

    public LogoutTest(WebDriver _driver) {
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
    @DisplayName("Log out from User's profile")
    public void logOutFromUserProfile() {
        SelenideElement logIntoAccountButton = constructorPage.getLogIntoAccountButton();
        logIntoAccountButton.click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(1000) + "@yandex.ru", "password");
        Steps.registration(registration);

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        SelenideElement userProfileButton = Steps.goToProfilePage(constructorPage);
        userProfileButton.click();

        Steps.logOut();

        userProfileButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(loginPageUrl, containsString(currentUrl));
    }

}
