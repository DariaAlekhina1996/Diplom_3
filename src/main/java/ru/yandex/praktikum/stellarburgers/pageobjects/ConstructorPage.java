package ru.yandex.praktikum.stellarburgers.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorPage {
    //Все вкладки в хедере
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private ElementsCollection headerTabs;

    //StellarBurgers логотип
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logoStellarBurgers;

    //"Соберите бургер" заголовок
    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/h1[text()='Соберите бургер']")
    private SelenideElement assembleBurgerHeader;

    //"Булки" link
    @FindBy(how = How.XPATH, using = ".//span[starts-with(.,'Булки')]")
    private SelenideElement bunsLink;

    //"Соусы" link
    @FindBy(how = How.XPATH, using = ".//span[starts-with(.,'Соусы')]")
    private SelenideElement saucesLink;

    //"Начинки" link
    @FindBy(how = How.XPATH, using = ".//span[starts-with(.,'Начинки')]")
    private SelenideElement toppingsLink;

    //Выбранный раздел
    @FindBy(how = How.XPATH, using = ".//div/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement chosenSection;

    //"Булки" текст
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']")
    private SelenideElement bunsText;

    //"Соусы" текст
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']")
    private SelenideElement saucesText;

    //"Начинки" текст
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']")
    private SelenideElement toppingsText;

    //Ингредиенты для бургера
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredient_ingredient__1TVf6 ml-4 mr-4 mb-8")
    private ElementsCollection burgerIngredients;

    //Сбор бургера
    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__listItem__aWMu1 mr-4")
    private ElementsCollection burgerConstructorBasket;

    //Цена бургера
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerConstructor_basket__totalContainer__2Z-ho mr-10']/p[@class='text text_type_digits-medium mr-3']")
    private SelenideElement priceOfBurger;

    //"Оформить заказ" кнопка
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement setOrderButton;

    //"Войти в аккаунт" кнопка
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logIntoAccountButton;

    public ElementsCollection getHeaderTabs() {
        return headerTabs;
    }

    public SelenideElement getBunsLink() {
        return bunsLink;
    }

    public SelenideElement getLogoStellarBurgers() {
        return logoStellarBurgers;
    }

    public SelenideElement getSaucesLink() {
        return saucesLink;
    }

    public SelenideElement getToppingsLink() {
        return toppingsLink;
    }

    public SelenideElement getChosenSection() {
        return chosenSection;
    }

    public SelenideElement getLogIntoAccountButton() {
        return logIntoAccountButton;
    }
}
