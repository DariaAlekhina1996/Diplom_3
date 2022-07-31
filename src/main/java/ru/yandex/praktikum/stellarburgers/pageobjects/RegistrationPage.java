package ru.yandex.praktikum.stellarburgers.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //"Регистрация" заголовок
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Регистрация']")
    private SelenideElement headerRegistration;

    //"Имя" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Имя']")
    private SelenideElement nameLabelOnRegistrationPage;

    //"Email" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Email']")
    private SelenideElement emailLabelOnRegistrationPage;

    //"Пароль" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/label[text()='Пароль']")
    private SelenideElement passwordLabelOnRegistrationPage;

    //Все поля для регистрации
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div")
    private ElementsCollection registrationFields;

    //Иконка "eye"
    @FindBy(how = How.CLASS_NAME, using = "input__icon input__icon-action")
    private SelenideElement eyeIconOnRegistrationPage;

    //"Зарегистрироваться" кнопка
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //"Уже зарегистрированы?" текст
    @FindBy(how = How.XPATH, using = ".//p[starts-with(.,'Уже зарегистрированы?')]")
    private SelenideElement alreadyRegisteredText;

    //"Войти" ссылка
    @FindBy(how = How.XPATH, using = ".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Войти']")
    private SelenideElement loginLinkOnRegistrationPage;

    //"Некорректный пароль" текст
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordText;

    public ElementsCollection getRegistrationFields() {return registrationFields;}

    public SelenideElement getRegistrationButton() {return  registrationButton;}

    public SelenideElement getIncorrectPasswordText() {return incorrectPasswordText;}

    public SelenideElement getLoginLinkOnRegistrationPage() {return loginLinkOnRegistrationPage;}

}
