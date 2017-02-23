package TestScripts.FlowWiseTests;

import PageLibrary.*;
import TestScripts.TestBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by aditya.mullela on 23/02/17.
 */
public class TestAddItemsToCart extends TestBase {

    WebDriver driver = null;

    @BeforeTest
    public void initiate() throws InterruptedException {
        driver = super.setUp();
        driverWait();
        getToLoginPage();
    }


    public void getToLoginPage() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.login();

        login();
    }

    public void login() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        driverWait();

        loginPage.login("Daunt1969@einrot.com", "Test123!@#");
        driverWait();
        addItemsToCart();
    }

    public void addItemsToCart() throws InterruptedException {
        MainSideBar mainSideBar = PageFactory.initElements(driver, MainSideBar.class);

        driverWait();

        mainSideBar.clickOnSale();
        driverWait();
        addItemFromOnSalePage();

        mainSideBar.selectFreshProduce();
        driverWait();
        addItemFromFreshProducePage();

        mainSideBar.selectMarketPlace();
        driverWait();
        addItemFromMarketPlacePage();

        getToCartPage();
    }

    public void addItemFromOnSalePage() throws InterruptedException {

        OnSalePage onSalePage = PageFactory.initElements(driver, OnSalePage.class);

        explicitWait(onSalePage.getColgateSensitiveProImg(), 10);
        driverWait();
        onSalePage.selectColgateSensitivePro();

        addToCartFromIndividualProductFrame();
    }

    public void addItemFromFreshProducePage() throws InterruptedException {

        FreshProducePage freshProducePage = PageFactory.initElements(driver, FreshProducePage.class);

        explicitWait(freshProducePage.getLargeBananasImg(), 10);
        driverWait();
        freshProducePage.selectLargeBananasImg();

        addToCartFromIndividualProductFrame();
    }

    public void addItemFromMarketPlacePage() throws InterruptedException {

        MarketPlacePage marketPlacePage = PageFactory.initElements(driver, MarketPlacePage.class);

        driverWait();
        marketPlacePage.selectBodyWash();

        addToCartFromIndividualProductFrame();
    }

    public void addToCartFromIndividualProductFrame() throws InterruptedException {

        IndividualProductFrame productFrame = PageFactory.initElements(driver, IndividualProductFrame.class);

        explicitWait(productFrame.getAddToCart(), 10);
        driver.switchTo().activeElement();
        driverWait();
        productFrame.addItemToCart();

        productFrame.eliminateAlert();

        productFrame.exitProductWindow();
        driverWait();
        driver.switchTo().defaultContent();
    }

    public void getToCartPage() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        driverWait();
        homePage.getCart();
    }


    @Test(groups = "testCart")
    public void TestCartPageForAdditions(){

       CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        List<WebElement> listOfProductOnCart = cartPage.getListOfItemAddedToCart(driver);

        //Test for number of elements added
        Assert.assertEquals(listOfProductOnCart.size(), 3);

        Assert.assertTrue(listOfProductOnCart.get(0).getText().contains("Large Bananas"));
        Assert.assertTrue(listOfProductOnCart.get(1).getText().contains("Coconut And Shea Butter"));
        Assert.assertTrue(listOfProductOnCart.get(2).getText().contains("Colgate"));
    }

    @Test(groups = "testCart")
    public void TestDeleteItemFromCart() throws InterruptedException {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        List<WebElement> listOfProductOnCart = cartPage.getListOfItemAddedToCart(driver);

        listOfProductOnCart.get(1).click();

        driverWait();

        deleteFromCartFromIndividualProductFrame();


        try{
            listOfProductOnCart.get(1).getText();
        } catch (StaleElementReferenceException exception){
            Assert.assertTrue(true);
            Reporter.log("Element is stale..");
        }

        List<WebElement> newListOfProductOnCart = cartPage.getListOfItemAddedToCart(driver);

        Assert.assertEquals(newListOfProductOnCart.size(), 2);

        Assert.assertTrue(newListOfProductOnCart.get(0).getText().contains("Large Bananas"));
        Assert.assertTrue(newListOfProductOnCart.get(1).getText().contains("Colgate"));
    }

    public void deleteFromCartFromIndividualProductFrame() throws InterruptedException {
        IndividualProductFrame productFrame = PageFactory.initElements(driver, IndividualProductFrame.class);

        driver.switchTo().activeElement();

        productFrame.decrementItemsInCart();

        productFrame.exitProductWindow();
        driverWait();
        driver.switchTo().defaultContent();

    }

    @AfterTest
    public void endTest(){
        driver.close();
        driver.quit();
    }
}
