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

    @FindBy(xpath = "//a[starts-with(@class, 'PdpAtcButton')]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/button")
    private WebElement exit;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[1]/span[3]")
    private WebElement increment;

    @FindBy(xpath = "//span[starts-with(@class, 'PdpAtcButton-decrement')]")
    private WebElement decrement;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[3]")
    private WebElement saveToList;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[2]/a[3]")
    private WebElement removeFromMyList;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/article/section/div/div[1]/div[1]/h2")
    private WebElement emptySpace;


    public void exitProductWindow(){
        exit.click();

    }

    public void eliminateAlert(){
        emptySpace.click();
    }

    public void addItemToCart(){
        if(addToCart.isDisplayed()) addToCart.click();
        else incrementItemsInCart();
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


