import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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
import ru.yandex.praktikum.stellarburgers.pageobjects.ForgotPasswordPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.LoginPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginTest extends BaseTest {
    private static ConstructorPage constructorPage;

    private static LoginPage loginPage;
    private static RegistrationPage registrationPage;
    private static ForgotPasswordPage forgotPasswordPage;
    private static String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";
    private String profilePageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    public LoginTest(WebDriver _driver) {
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
    @DisplayName("Login as an user using 'User's profile' button")
    public void loginUsingUserProfileButton(){
        SelenideElement userProfileButton = Steps.goToProfilePage(constructorPage);
        userProfileButton.click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(100000) + "@yandex.ru", "password");
        Steps.registration(registration);

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        userProfileButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(profilePageUrl, containsString(currentUrl));

        Steps.logOut();
    }

    @Test
    @DisplayName("Login as an user using 'Login' button on the 'Registration' form")
    public void loginUsingLoginButtonOnRegistrationForm(){
        SelenideElement userProfileButton = Steps.goToProfilePage(constructorPage);
        userProfileButton.click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(100000) + "@yandex.ru", "password");
        Steps.registration(registration);

        loginPage = page(LoginPage.class);

        SelenideElement registerLink = loginPage.getRegisterLink();
        WebDriver driver = WebDriverRunner.getWebDriver();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("Зарегистрироваться")));
        registerLink.click();

        registrationPage = page(RegistrationPage.class);

        SelenideElement loginLink = registrationPage.getLoginLinkOnRegistrationPage();
        loginLink.click();

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        userProfileButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(profilePageUrl, containsString(currentUrl));

        Steps.logOut();
    }

    @Test
    @DisplayName("Login as an user using 'Login' button on the 'Recover-password' form")
    public void loginUsingLoginButtonOnRecoverPasswordForm() {
        SelenideElement userProfileButton = Steps.goToProfilePage(constructorPage);
        userProfileButton.click();

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(100000) + "@yandex.ru", "password");
        Steps.registration(registration);

        loginPage = page(LoginPage.class);

        SelenideElement recoverPasswordLink = loginPage.getRecoverPasswordLink();
        WebDriver driver = WebDriverRunner.getWebDriver();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("Восстановить пароль")));
        recoverPasswordLink.click();

        forgotPasswordPage = page(ForgotPasswordPage.class);

        SelenideElement loginLinkOnRecoverPasswordPage = forgotPasswordPage.getLoginLinkOnRecoverPasswordPage();
        loginLinkOnRecoverPasswordPage.click();

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        userProfileButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(profilePageUrl, containsString(currentUrl));

        Steps.logOut();
    }

    @Test
    @DisplayName("Login as an user using 'Log into account' button")
    public void loginUsingLogIntoButton() {
        SelenideElement logIntoAccountButton = constructorPage.getLogIntoAccountButton();
        logIntoAccountButton.click();

        loginPage = page(LoginPage.class);

        Registration registration = new Registration("Daria", "test-data" + new Random().nextInt(100000) + "@yandex.ru", "password");
        Steps.registration(registration);

        Login login = new Login(registration.email, registration.password);
        Steps.login(login);

        Steps.goToProfilePage(constructorPage).click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        MatcherAssert.assertThat(profilePageUrl, containsString(currentUrl));

        Steps.logOut();
    }
}
