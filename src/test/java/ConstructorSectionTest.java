import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.stellarburgers.pageobjects.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorSectionTest extends BaseTest {
    private static ConstructorPage constructorPage;
    private static String constructorPageUrl = "https://stellarburgers.nomoreparties.site/";

    public ConstructorSectionTest(WebDriver _driver) {
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
    @DisplayName("Check to switch from Buns to Sauces section")
    public void switchFromBunsToSaucesSection() {
        SelenideElement saucesLink = constructorPage.getSaucesLink();
        saucesLink.click();

        SelenideElement saucesChosenLink = constructorPage.getChosenSection();
        saucesChosenLink.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
        saucesChosenLink.shouldHave(Condition.text("Соусы"));
    }

    @Test
    @DisplayName("Check to switch from Buns to Toppings section")
    public void switchFromBunsToToppingsSection() {
        SelenideElement toppingsLink = constructorPage.getToppingsLink();
        toppingsLink.click();

        SelenideElement toppingsChosenLink = constructorPage.getChosenSection();
        toppingsChosenLink.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
        toppingsChosenLink.shouldHave(Condition.text("Начинки"));
    }

    @Test
    @DisplayName("Check to switch from Toppings to Buns section")
    public void switchFromToppingsToBunsSection() {
        SelenideElement toppingsLink = constructorPage.getToppingsLink();
        toppingsLink.click();

        SelenideElement bunsLink = constructorPage.getBunsLink();
        bunsLink.click();

        SelenideElement bunsChosenLink = constructorPage.getChosenSection();
        bunsChosenLink.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
        bunsChosenLink.shouldHave(Condition.text("Булки"));
    }

}
