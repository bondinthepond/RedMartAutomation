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
public class HomePage {

    @FindBy(xpath = "//*[@id=\"signup\"]/a/span")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"signin\"]/a/span")
    private WebElement loginButton;

    @FindBy(name = "productSearch")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"contentSection\"]/div/article/div[2]/div/div/ul[1]/li[1]/div[1]/div/a/img")
    private WebElement catalogItemOliveOil;

    public void signUp(){
        signUpButton.click();
    }

    public void searchStuff(String productName){
        searchBar.sendKeys(productName);
        searchBar.submit();
    }
}
