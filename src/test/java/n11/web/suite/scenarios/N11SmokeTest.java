package n11.web.suite.scenarios;

import n11.web.suite.pages.FavoritesPage;
import n11.web.suite.pages.HomePage;
import n11.web.suite.pages.LoginPage;
import n11.web.suite.pages.SearchPage;
import n11.web.suite.base.TestBase;
import n11.web.suite.base.*;
import n11.web.suite.utilities.ConfigFileReader;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class N11SmokeTest {
    public static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SearchPage searchPage;
    public static FavoritesPage favoritesPage;
    public static ConfigFileReader configFileReader;

    public static void initPageObjects(WebDriver driver){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        searchPage = PageFactory.initElements(driver,SearchPage.class);
        favoritesPage = PageFactory.initElements(driver,FavoritesPage.class);
    }

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        configFileReader = new ConfigFileReader();
        driver = TestBase.setDriver(BrowserType.CHROME);
        initPageObjects(driver);
    }
     //1
    @Test
    public void testA_HomePageIsOpened(){
        TestBase.openHomePage(configFileReader.getApplicationURL());
        TestBase.acceptUserKvkkPopUp(homePage.userKvkkAcceptButton,driver);
        TestBase.closeCookiesPopUp(homePage.cookieCloseButton);
        Assert.assertTrue(homePage.verifyHomePageIsOpened());
        System.out.println("Home Page is opened successfully.");
    }
    
    //2
    @Test
    public void testB_LoggedInFlow(){
        loginPage.clickSignInButton();
        loginPage.setEmail(configFileReader.getLoginEmail());
        loginPage.setPassword(configFileReader.getLoginPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.myAccountMenuVisibility());
        System.out.println("Logged in flow is completed successfully :)");
    }
    @Test
    public void testC_SearchDataAndAddToFavorites()  {
        //3
        searchPage.searchData(configFileReader.getSearchData());
        String[] expectedResultContainsWords = {searchPage.getSearchResultText(), "için", "sonuç","bulundu."};
        //4
        Assert.assertTrue(searchPage.verifySearchResult(searchPage.getSearchResultText(),expectedResultContainsWords));
        System.out.println("Searched Data is loaded successfully.");
        searchPage.productListingMenu.click();
        //5
        searchPage.goToSecondPage();
        Assert.assertTrue(searchPage.verifyOpenedPage());
        System.out.println("You are at the second page.");
        searchPage.productDetailsArea.click();
        //6
        searchPage.selectThirdProduct();
        searchPage.addThirdProductToFavorites();
    }


    @Test
    public void testD_FavoriteProductAvailability(){
        //7
        favoritesPage.goToMyFavoritePage();
        //8
        favoritesPage.isThereFavoriteProduct(searchPage.getFavoriteProduct());
        //9
        favoritesPage.removeFavoriteProduct(searchPage.getFavoriteProduct());
        //10
        Assert.assertTrue(favoritesPage.verifyFavoriteProductIsRemoved(searchPage.getFavoriteProductTitle()));
        System.out.println("Favorite product is removed from my favorite's list successfully.");
    }

    @AfterClass
    public static void tearDown(){

        TestBase.quitDriver();
    }



}
