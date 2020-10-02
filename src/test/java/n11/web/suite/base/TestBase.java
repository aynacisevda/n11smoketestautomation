package n11.web.suite.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public static WebDriver setDriver(BrowserType browserType)
    {
        if (driver == null)
            switch (browserType){
                case CHROME:
                    System.out.println("Launching Chrome Browser");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case IE:
                    System.out.println("Launching IE Browser");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case FIREFOX:
                    System.out.println("Launching Firefox Browser");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
            }
        return driver;
    }

    public static WebDriver openHomePage(String URL) {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        try {
            driver.get(URL);
        }
        catch (Exception exception){
            System.out.println("TimeOut Exception Caught : Home Page is not loaded within 10 seconds!");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void acceptUserKvkkPopUp(WebElement userKvkkPopupElement,WebDriver driver){
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        userKvkkPopupElement.click();
        driver.switchTo().window(winHandleBefore);
    }



    public static void closeCookiesPopUp(WebElement cookiesPopUpElement){
        cookiesPopUpElement.click();
    }



}
