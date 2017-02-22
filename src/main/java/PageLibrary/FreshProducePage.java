package PageLibrary;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aditya.mullela on 22/02/17.
 */
@Getter
@Setter
public class FreshProducePage {

    //Fresh Vegetables
    //Fresh Fruits
    //Asian Vegetables
    //Ready-to-eat
    //Salads
    //Herbs & Spices
    //Tomatoes
    //Peppers & Capsicums
    //Broccoli & Cauliflower
    //Potatoes & Carrots
    //Cooking Styles
    //Organics

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/ul/li[1]/div[1]/div/a/img")
    private WebElement largeBananasImg;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/ul/li[1]/div[3]/a/span")
    private WebElement addToCartLargeBananas;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/ul/li[3]/div[1]/div/a/img")
    private WebElement lemonsImg;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/ul/li[3]/div[3]/a/span")
    private WebElement addToCartLemons;

    public void selectLargeBananas(){
        addToCartLargeBananas.click();
    }

    public void selectLemons(){
        addToCartLemons.click();
    }
}
