package n11.web.suite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {
    private WebDriver driver;

    public SearchPage()
    {

    }
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchData")
    public WebElement searchBar;

    @FindBy(className= "searchBtn")
    public WebElement searchButton;

    @FindBy(css = "#contentListing > div > div > div.productArea > section > div.header > div.resultText")
    public WebElement searchResultTextContainer;

    @FindBy(id = "contentListing")
    public WebElement productListingMenu;

    @FindBy(linkText = "2")
    public WebElement secondPage;

    @FindBy(className = "productArea")
    public WebElement productDetailsArea;

    @FindBy(css = "#view > ul > li:nth-child(3)")
    public WebElement thirdProduct;

    @FindBy(css = "span[class*='textImg followBtn']")
    public WebElement addToFavoriteButton;

    public boolean verifySearchResult(String searchResultText , String[] expectedResult){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(productDetailsArea));

        for (String expectedWord : expectedResult)
        {
            if (searchResultText.contains(expectedWord))
            {
                System.out.println("Searched Data is found");
            }
        }
            return true;}
        catch (Exception exception)
        {
            System.out.println("Searched Data is not found");
            return  false;
        }
    }

    public void searchData(String searchData){

        WebDriverWait waitForSearchBar = new WebDriverWait(driver, 10);
        waitForSearchBar.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(searchData);
        WebDriverWait waitForSearchButton = new WebDriverWait(driver, 10);
        waitForSearchButton.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public String getSearchResultText(){
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(searchResultTextContainer));
       String searchResultText = searchResultTextContainer.getText();
       return searchResultText;
    }

    public void goToSecondPage(){

    secondPage.click();
    }

    public boolean verifyOpenedPage(){
    String openedPageUrl = driver.getCurrentUrl();
    if(openedPageUrl.contains("pg=2"))
    {return true;}
    else{
        System.out.println("You are not at the second page.");
        return false;
    }
    }
    public void selectThirdProduct(){

    thirdProduct.click();
    }

    public void addThirdProductToFavorites(){

    addToFavoriteButton.click();
    }

    public WebElement getFavoriteProduct(){
        return thirdProduct;
    }
    
     public String getFavoriteProductTitle(){
        return thirdProduct.getAttribute("title");
    }
}
