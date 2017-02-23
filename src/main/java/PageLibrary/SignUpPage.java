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
public class SignUpPage {

    @FindBy(xpath = "//*[@id=\"signup\"]/a/span")
    private WebElement homePageSignUpButton;

    @FindBy(xpath = "//*[@id=\"topBarSignUpForm\"]/input[1]")
//    @FindBy(name = "email")
    private WebElement emailAddressField;

    @FindBy(xpath = "//*[@id=\"topBarSignUpForm\"]/input[2]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"topBarSignUpForm\"]/input[3]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"topBarSignUpForm\"]/span/input")
    private WebElement privacyAgreementCheckBox;

    @FindBy(xpath = "//*[@id=\"topBarSignUpForm\"]/button")
    private WebElement signUpButton;

    public void enterEmailAddress(String emailAddress){
        emailAddressField.sendKeys(emailAddress);
        emailAddressField.submit();
    }

    public void startSignUp() { homePageSignUpButton.click(); }

    public void enterPassWord(String password){
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public void confirmPassword(String password){
        confirmPasswordField.sendKeys(password);
        confirmPasswordField.submit();
    }

    public void checkThePrivacyAgreementBox(){
        privacyAgreementCheckBox.click();
    }

    public void enterEmailAndPasswordDetails(String email, String password){
        emailAddressField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void signUp(){
        signUpButton.click();
    }

}
