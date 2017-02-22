package WebDriverStuff;

import DTOs.ConfigPropertiesDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class WebDriverStuff {

    public static WebDriver driver;

    ConfigPropertiesDTO configPropertiesDTO;

    public static WebDriver selectBrowser(ConfigPropertiesDTO configPropertiesDTO){

        if(configPropertiesDTO.getBrowser().equals("firefox")){
            System.setProperty(configPropertiesDTO.getFirefoxDriver(), configPropertiesDTO.getFirefoxDriverLocation());
            driver = new FirefoxDriver();
        } else if(configPropertiesDTO.getBrowser().equals("chrome")) {
            System.setProperty(configPropertiesDTO.getChromeDriver(), configPropertiesDTO.getChromeDriverLocation());
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void implicitWait(int timeInSec) {
        Reporter.log("waiting for page to load .....");

        try{
            driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
            Reporter.log("Page loaded");
        } catch (Throwable error){
            System.out.println("Page Loading TimedOut after" + timeInSec);
        }
    }

    public static void driverWait() throws InterruptedException{
        Thread.sleep(20000);
    }

    public static void explicitWait(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        Reporter.log("waiting for" + element.getText()+ "to appear");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectDropDownValue(WebElement element, String dropDownValue){
        Select select = new Select(element);
        Reporter.log("selecting "+dropDownValue+" value in dropdown");
        select.selectByVisibleText(dropDownValue);
    }
}
