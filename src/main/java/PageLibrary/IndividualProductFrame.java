package PageLibrary;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aditya.mullela on 23/02/17.
 */
@Getter
@Setter
public class IndividualProductFrame {

    //add to cart button's xpath is same irrespective of product selected
    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[2]/span")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/button")
    private WebElement exit;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[2]/span[3]")
    private WebElement increment;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[2]/span[1]")
    private WebElement decrement;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[3]")
    private WebElement saveToList;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[3]")
    private WebElement removeFromMyList;

    public void exitProductWindow(){
//        exit.click();

    }

    public void addItemToCart(){
        addToCart.click();
    }

    //test view my cart alert
    public void incrementItemsInCart(){
        increment.click();
    }

    public void decrementItemsInCart(){
        decrement.click();
    }

    //test alert after saving to cart
    public void saveTheCart(){
        saveToList.click();
    }

    //test alert after removing from the cart
    public void removeItemFromCart(){
        removeFromMyList.click();
    }
}


