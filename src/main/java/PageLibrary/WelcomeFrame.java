package PageLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aditya.mullela on 23/02/17.
 */
public class WelcomeFrame {

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/div")
    private WebElement welcomeScreen;

    @FindBy(xpath = "//*[@id=\"lightboxContent\"]/div/button")
    private WebElement exitWelcomeScreen;

    public void exitWelcomeScreen(){
        exitWelcomeScreen.click();
    }


}
