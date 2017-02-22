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
public class MarketPlacePage {

    // add products whose presence needs to be tested

    @FindBy(xpath = "//*[@id=\"marketPlaceLanding\"]/div[1]/div[1]/div[1]/li/div[1]/div/a[1]/img")
    private WebElement mangoPouch;

    @FindBy(xpath = "//*[@id=\"marketPlaceLanding\"]/div[1]/div[1]/div[2]/div/li[1]/div[1]/div/a[1]/img")
    private WebElement coconutSheaButterBodyWash;

    public void selectMangoPouch(){
        mangoPouch.click();
    }

    public void selectBodyWash(){
        coconutSheaButterBodyWash.click();
    }


}
