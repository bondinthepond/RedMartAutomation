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

    @FindBy(xpath = "//*[@id=\"cartPreviewInner\"]/span")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"showMenu\"]/a/span[3]")
    private WebElement showMenu;

    public void signUp(){
        signUpButton.click();
    }

    public void searchForStuff(String productName){
        searchBar.sendKeys(productName);
        searchBar.submit();
    }

    public void getCart(){
        cartButton.click();
    }

    public void login(){
        loginButton.click();
    }

    public void showMenu(){
        showMenu.click();
    }

}
