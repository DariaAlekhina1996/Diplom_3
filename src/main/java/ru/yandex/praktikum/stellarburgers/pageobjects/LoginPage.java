package ru.yandex.praktikum.stellarburgers.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //"Вход" заголовок
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Вход']")
    private SelenideElement headerLogin;

    //"Email" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Email']")
    private SelenideElement emailLabelOnLoginPage;

    //"Пароль" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/label[text()='Пароль']")
    private SelenideElement passwordLabelOnLoginPage;

    //"Email" поле
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']")
    private SelenideElement fieldEmailOnLoginPage;

    //"Пароль" поле
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']")
    private SelenideElement fieldPasswordOnLoginPage;

    //Иконка "eye"
    @FindBy(how = How.CLASS_NAME, using = "input__icon input__icon-action")
    private SelenideElement eyeIconOnLoginPage;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Войти']")
    private SelenideElement loginButton;

    //"Вы — новый пользователь?" текст
    @FindBy(how = How.XPATH, using = ".//p[starts-with(.,'Вы')]")
    private SelenideElement youAreNewUserText;

    //"Зарегистрироваться" линка
    @FindBy(how = How.XPATH, using = ".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    //"Забыли пароль?" текст
    @FindBy(how = How.XPATH, using = ".//p[starts-with(.,'Забыли пароль?')]")
    private SelenideElement forgotPasswordText;

    //"Восстановить пароль" линка
    @FindBy(how = How.XPATH, using = ".//p[@class='undefined text text_type_main-default text_color_inactive']/a[text()='Восстановить пароль']")
    private SelenideElement recoverPasswordLink;

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getFieldEmailOnLoginPage() {
        return fieldEmailOnLoginPage;
    }

    public SelenideElement getFieldPasswordOnLoginPage() {
        return fieldPasswordOnLoginPage;
    }

    public SelenideElement getRegisterLink() {return registerLink;}

    public SelenideElement getRecoverPasswordLink() {return recoverPasswordLink;}

}
