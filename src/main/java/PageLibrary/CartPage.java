package PageLibrary;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by aditya.mullela on 23/02/17.
 */

@Getter
@Setter
public class CartPage {

    @FindBy(xpath = "//*[@id=\"cartPreviewProductList\"]/div/div[1]/li[1]/div[2]/div/div/button")
    private WebElement removeFromCart;

    @FindBy(className = "productPreview horizontal")
    private WebElement productList;

    private List<WebElement> listOfProductsOnCart;

    public List<WebElement> getListOfItemAddedToCart(WebDriver driver){
        listOfProductsOnCart =
        driver.findElements(By.xpath("//div[starts-with(@id, 'cartMain')]//div[starts-with(@class, 'productList')]//li[starts-with(@class, 'productPreview horizontal')]//h4[(@title)]"));
        return listOfProductsOnCart;
    }
}
