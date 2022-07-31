import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class BaseTest {
    public static WebDriver driver;

    public BaseTest(WebDriver _driver) {
        driver = _driver;
    }

    @Parameterized.Parameters
    public static List<WebDriver> getBrowserType() {
        List<WebDriver> list = new ArrayList<WebDriver>();
        list.addAll(List.of(new WebDriver[]{
                setYandex(),
                setChrome()
        }));
        return list;
    }

    private static WebDriver setYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "D:\\Yandex.Praktikum\\chromedriver2.exe");
        options.setBinary("C:\\Users\\koval\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        return new ChromeDriver(options);
    }

    private static WebDriver setChrome() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "D:\\Yandex.Praktikum\\chromedriver103.exe");
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        return new ChromeDriver(options);
    }

}
