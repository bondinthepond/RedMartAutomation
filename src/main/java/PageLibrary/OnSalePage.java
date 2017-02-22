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
public class OnSalePage {


    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/div/ul/li[2]/div[1]/div/a[1]/img")
    private WebElement colgateSensitiveProImg;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/div/ul/li[2]/div[3]/a/span[2]")
    private WebElement addToCartColgateSensitivePro;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/div/ul/li[4]/div[1]/div/a[1]/img")
    private WebElement mamyPokoImg;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/div/ul/li[4]/div[3]/a/span")
    private WebElement addToCartMamyPoko;

    public void selectColgateSensitivePro(){
        colgateSensitiveProImg.click();
    }

    public void selectMamyPoko(){
        mamyPokoImg.click();
    }
}
