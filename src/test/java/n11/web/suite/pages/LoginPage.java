package n11.web.suite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver; 

    public LoginPage (){
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "btnSignIn")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement eMailTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(id = "loginButton")
    public WebElement loginButton;
    
    @FindBy(css = "a.menuLink.user")
    public WebElement myAccountMenu;


    public void clickSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void setEmail(String strEmail) {

        eMailTextBox.sendKeys(strEmail);
    }

    public void setPassword(String strPassword) {

        passwordTextBox.sendKeys(strPassword);
    }

    public HomePage clickLoginButton(){
        loginButton.click();
        return new HomePage(driver);
  
    }
    
   public boolean myAccountMenuVisibility(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountMenu));
        return myAccountMenu.isDisplayed();
    }


}
