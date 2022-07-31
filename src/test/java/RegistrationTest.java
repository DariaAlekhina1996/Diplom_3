import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.stellarburgers.pageobjects.ConstructorPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.CoreMatchers.containsString;

public class RegistrationTest extends BaseTest {
    private static ConstructorPage constructorPage;
    private String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";
    private String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";

    public RegistrationTest(WebDriver _driver) {
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
    @DisplayName("Check registration a new user")
    public void newUserRegisteredSuccessfully() {
        Steps.goToProfilePage(constructorPage).click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(1000) + "@yandex.ru", "password");
        Steps.registration(registration);

        WebDriver driver = WebDriverRunner.getWebDriver();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Auth_login__3hAey']/h2[text()='Вход']")));
        String currentUrl = driver.getCurrentUrl();
        MatcherAssert.assertThat(loginPageUrl, containsString(currentUrl));
    }

    @Test
    @DisplayName("It's not possible to register an user with password of less than 5 characters")
    public void notPossibleToRegisterUserWithIncorrectPassword() {
        Steps.goToProfilePage(constructorPage).click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(1000) + "@yandex.ru", "12345");
        Steps.registration(registration);

        RegistrationPage registrationPage = page(RegistrationPage.class);
        SelenideElement validationText = registrationPage.getIncorrectPasswordText();
        validationText.shouldBe(Condition.visible);
    }
}
