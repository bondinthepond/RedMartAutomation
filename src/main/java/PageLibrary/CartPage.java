package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by aditya.mullela on 23/02/17.
 */
public class CartPage {


    @FindBy(xpath = "//*[@id=\"cartPreviewProductList\"]/div/div[1]/li[1]/div[2]/div/div/button")
    private WebElement removeFromCart;

    @FindBy(xpath = "//*[@id=\"cartPreviewProductList\"]/div/div[1]")
    private WebElement productList;

    private List<WebElement> listOfProductsOnCart;

    public List<WebElement> getListOfItemAddedToCart(WebDriver driver){
        listOfProductsOnCart = driver.findElements(By.xpath("//*[@id=\"cartPreviewProductList\"]/div/div[1]"));
        return listOfProductsOnCart;
    }

    private List<String> listOfXpathsOfProducts;

    public void computeXpathOfProduct(int lengthOfProductList){

    }
    //*[@id="cartPreviewProductList"]/div/div[1]/li[1]/div[1]/div[2]/div[1]/h4

    //*[@id="cartPreviewProductList"]/div/div[1]/li[2]/div[1]/div[2]/div[1]/h4
}
