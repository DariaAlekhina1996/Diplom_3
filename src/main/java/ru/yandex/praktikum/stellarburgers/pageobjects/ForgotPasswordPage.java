package ru.yandex.praktikum.stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //"Восстановление пароля" заголовок
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Восстановление пароля']")
    private SelenideElement headerRecoverPassword;

    //"Email" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Email']")
    private SelenideElement emailLabelOnRecoverPasswordPage;

    //"Email" поле
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']")
    private SelenideElement fieldEmailOnRecoverPasswordPage;

    //Кнопка "Восстановить"
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Восстановить']")
    private SelenideElement recoverButton;

    //"Вспомнили пароль?" текст
    @FindBy(how = How.XPATH, using = ".//p[starts-with(.,'Вспомнили пароль?')]")
    private SelenideElement rememberPasswordText;

    //"Войти" линка
    @FindBy(how = How.XPATH, using = ".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Войти']")
    private SelenideElement loginLinkOnRecoverPasswordPage;

    public SelenideElement getLoginLinkOnRecoverPasswordPage() {return loginLinkOnRecoverPasswordPage;}
}
