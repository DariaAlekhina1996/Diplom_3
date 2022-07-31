import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.yandex.praktikum.stellarburgers.pageobjects.ConstructorPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.LoginPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.RegistrationPage;
import ru.yandex.praktikum.stellarburgers.pageobjects.UserProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

class Login {
    String email;
    String password;

    public Login(String email, String password){
        this.email = email;
        this.password = password;
    }
}
class Registration {
    String name;
    String email;
    String password;

    public Registration(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

public final class Steps {
    @Step("Login as an user")
    public static void login(Login login) {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        SelenideElement inputEmail = loginPage.getFieldEmailOnLoginPage();
        inputEmail.setValue(login.email);

        SelenideElement inputPassword = loginPage.getFieldPasswordOnLoginPage();
        inputPassword.setValue(login.password);

        SelenideElement loginButton = loginPage.getLoginButton();
        loginButton.click();
    }

    @Step("New user registration")
    public static void registration(Registration registration) {
        LoginPage loginPage = page(LoginPage.class);

        SelenideElement registerLink = loginPage.getRegisterLink();
        registerLink.click();

        RegistrationPage registrationPage = page(RegistrationPage.class);

        ElementsCollection registrationFields = registrationPage.getRegistrationFields();

        for (SelenideElement registrationInput: registrationFields) {
            switch (registrationInput.getText()) {
                case "Имя":
                    registrationInput.find(By.tagName("input")).setValue(registration.name);
                    break;
                case "Email":
                    registrationInput.find(By.tagName("input")).setValue(registration.email);
                    break;
                case "Пароль":
                    registrationInput.find(By.tagName("input")).setValue(registration.password);
                    break;
            }
        }
        SelenideElement registerButton = registrationPage.getRegistrationButton();
        registerButton.click();
    }

    @Step("Switch to Profile page")
    public static SelenideElement goToProfilePage(ConstructorPage constructorPage) {
        ElementsCollection headerTabs = constructorPage.getHeaderTabs();
        SelenideElement userProfileButton = headerTabs.findBy(Condition.text("Личный кабинет"));
        return userProfileButton;
    }

    @Step("Log out")
    public static void logOut() {
        UserProfilePage userProfilePage = page(UserProfilePage.class);
        SelenideElement logOutButton = userProfilePage.getLogoutButtonOnUserProfilePage();
        logOutButton.click();
    }
}
