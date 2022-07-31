package ru.yandex.praktikum.stellarburgers.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfilePage {

    //"Профиль" линка
    @FindBy(how = How.XPATH, using = ".//li[@class='Account_listItem__35dAP']/a[text()='Профиль']")
    private SelenideElement profileLink;

    //"История заказов" линка
    @FindBy(how = How.XPATH, using = ".//li[@class='Account_listItem__35dAP']/a[text()='История заказов']")
    private SelenideElement historyOrdersLink;

    //"Выход" кнопка
    @FindBy(how = How.XPATH, using = ".//li[@class='Account_listItem__35dAP']/button[text()='Выход']")
    private SelenideElement logoutButtonOnUserProfilePage;

    //"В этом разделе вы можете изменить свои персональные данные" текст
    @FindBy(how = How.XPATH, using = ".//nav[@class='Account_nav__Lgali']/p[@class='Account_text__fZAIn text text_type_main-default']")
    private SelenideElement textOnUserProfilePage;

    //"Имя" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/label[text()='Имя']")
    private SelenideElement nameLabelOnUserProfilePage;

    //"Логин" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/label[text()='Логин']")
    private SelenideElement loginLabelOnRegistrationPage;

    //"Пароль" label
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/label[text()='Пароль']")
    private SelenideElement passwordLabelOnRegistrationPage;

    //Формы для редактирования
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div")
    private ElementsCollection fieldsForEditing;

    //Иконка карандаша
    @FindBy(how = How.CLASS_NAME, using = "input__icon input__icon-action")
    private ElementsCollection pencilIcon;

    //"Отмена" кнопка
    @FindBy(how = How.XPATH, using = ".//div[@class='Profile_buttonBox__1JlBI']/button[text()='Отмена']")
    private SelenideElement cancelButton;

    //"Сохранить" кнопка
    @FindBy(how = How.XPATH, using = ".//div[@class='Profile_buttonBox__1JlBI']/button[text()='Сохранить']")
    private SelenideElement saveButton;

    public SelenideElement getLogoutButtonOnUserProfilePage() {return logoutButtonOnUserProfilePage;}

}
