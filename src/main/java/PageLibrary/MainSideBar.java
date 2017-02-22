package PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class MainSideBar {

    @FindBy(xpath = "//*[@id=\"categoryNav\"]/section[1]/div[4]/a")
    private WebElement marketPlace;

    @FindBy(xpath = "//*[@id=\"categoryNav\"]/section[1]/div[2]/a")
    private WebElement onSale;

    @FindBy(xpath = "//*[@id=\"megaMenu\"]/div[2]/a")
    private WebElement freshProduce;


    public void selectMarketPlace() {
        marketPlace.click();
    }

    public void clickOnSale() {
        onSale.click();
    }

    public void selectFreshProduce(){
        freshProduce.click();
    }

    public void hoverOnFreshProduce(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(freshProduce).build().perform();
    }

    public void selectCategoryFromFreshProduce(String category){

        Select freshProduceDropDown = new Select(freshProduce);

        freshProduceDropDown.selectByValue(category);

    }


}
