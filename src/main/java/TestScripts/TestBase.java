package TestScripts;

import DTOs.ConfigPropertiesDTO;
import JSONReader.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class TestBase {

    ConfigPropertiesDTO configPropertiesDTO;
    ConfigReader configReader;

    WebDriver driver = null;

    public WebDriver setUp() throws InterruptedException {

        configReader = new ConfigReader();
        configPropertiesDTO = configReader.readConfigProperties();

        if(configPropertiesDTO.getBrowser().toLowerCase().equals("chrome")) {
            System.setProperty(configPropertiesDTO.getChromeDriver(), configPropertiesDTO.getChromeDriverLocation());

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--kiosk");//for mac, for windows "--start-maximized"

            driver = new ChromeDriver(options);

        } else if(configPropertiesDTO.getBrowser().toLowerCase().equals("firefox")){
            System.setProperty(configPropertiesDTO.getFirefoxDriver(), configPropertiesDTO.getFirefoxDriverLocation());
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize(); //works only for firefox, gets ignored for chrome
        driver.get(configPropertiesDTO.getUrl());

        return driver;
    }

    public WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
        String locatorType = split[0];
        String locatorValue = split[1];

        if (locatorType.equals("id"))
            return driver.findElement(By.id(locatorValue));
        else if (locatorType.equals("name"))
            return driver.findElement(By.name(locatorValue));
        else if ((locatorType.equals("classname")) || (locatorType.equals("class")))
            return driver.findElement(By.className(locatorValue));
        else if ((locatorType.equals("tagname")) || (locatorType.equals("tag")))
            return driver.findElement(By.className(locatorValue));
        else if ((locatorType.equals("linktext")) || (locatorType.equals("link")))
            return driver.findElement(By.linkText(locatorValue));
        else if (locatorType.equals("partiallinktext"))
            return driver.findElement(By.partialLinkText(locatorValue));
        else if ((locatorType.equals("cssselector")) || (locatorType.equals("css")))
            return driver.findElement(By.cssSelector(locatorValue));
        else if (locatorType.equals("xpath"))
            return driver.findElement(By.xpath(locatorValue));
        else
            throw new Exception("Unknown locator type '" + locatorType + "'");
    }


    public String textPresentInAlert(){

        try
        {
            return driver.switchTo().alert().getText();
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return null;
        }   // ca

    }

    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }

    public void driverWait() throws InterruptedException{
        Thread.sleep(4000);
    }

    public void explicitWait(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        Reporter.log("waiting for" + element.getText()+ "to appear");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void maximize(){
        driver.manage().window().maximize();
    }
//    public WebElement getWebElement(String locator) throws Exception{
//        return getLocator(Repository.getProperty(locator));
//    }

}
