package n11.web.suite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FavoritesPage {
    private WebDriver driver;

    public FavoritesPage(){
    }

    public FavoritesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Favorilerim / Listelerim")
    public WebElement myFavoritesMenu;

    @FindBy(className = "listView")
    public List<WebElement> favoriteProductList;

    @FindBy(css = "span.btn.btnBlack.confirm")
    public WebElement removeFavoriteProductBtn;

    public void goToMyFavoritePage(){

        myFavoritesMenu.click();
    }

    public boolean isThereFavoriteProduct(WebElement favoriteProduct)
    {
        try{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(favoriteProduct));
        for (WebElement product:favoriteProductList)
        {
            if(product.getAttribute("title") == favoriteProduct.getAttribute("title"))
                System.out.println("Favorite product is available");
        }
        return true;
        }
        catch (Exception e)
        {
            System.out.println("Favorite product is not available");
            return false;
        }

    }

     public void removeFavoriteProduct(WebElement favoriteProduct){

         for (WebElement product:favoriteProductList)
         {
             if(product.getAttribute("title") == favoriteProduct.getAttribute("title"))
                 removeFavoriteProductBtn.click();
         }

     }

      public boolean verifyFavoriteProductIsRemoved(String favoriteProductName){
          
         List<String> favoritesNameList = new ArrayList<>();
         for (WebElement product : favoriteProductList) {
             String favoritesProductName = product.getAttribute("title");
             favoritesNameList.add(favoritesProductName);
         }
         return favoritesNameList.contains(favoriteProductName);
     }
}
