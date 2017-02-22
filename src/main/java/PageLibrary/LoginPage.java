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
public class LoginPage {


    @FindBy(xpath = "//*[@id=\"loginBarInner\"]/form/input[1]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"loginBarInner\"]/form/input[2]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"loginBarInner\"]/form/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"accountPreviewInner\"]/span")
    private WebElement accountPreviewButton;

    public void enterEmail(String emailAddress){
        emailField.sendKeys(emailAddress);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void login(){
        loginButton.click();
    }

    public void login(String emailAddress, String password){
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
