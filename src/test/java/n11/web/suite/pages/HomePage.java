package n11.web.suite.pages;

import n11.web.suite.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[title='hayat sana gelir']")
    public WebElement homePageTitle;

    @FindBy(className = "btnHolder")
    public WebElement userKvkkAcceptButton;

    @FindBy(className = "closeBtn")
    public WebElement cookieCloseButton;

    public boolean verifyHomePageIsOpened()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePageTitle));
            String n11HomePageTitleText = homePageTitle.getAttribute("title");
            System.out.println("Home Page Title : " +n11HomePageTitleText);
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Home Page is not opened.");
            return false;
        }
    }
}
