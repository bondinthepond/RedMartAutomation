package TestScripts.FlowWiseTests;

import PageLibrary.*;
import TestScripts.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
        driverWait();
        homePage.login();
        login();
    }

    public void login() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.login("adityamallela.1988@gmail.com", "Tester123!@#");

        driverWait();
        driverWait();
        //needToAdd an explicit wait statement

//        maximize();
//
        addItemsToCart();
//        activateMainSideBar();
    }

    public void activateMainSideBar() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.showMenu();

        addItemsToCart();
    }

    public void addItemsToCart() throws InterruptedException {
        MainSideBar mainSideBar = PageFactory.initElements(driver, MainSideBar.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.showMenu();
        mainSideBar.clickOnSale();
        addItemFromOnSalePage();

        homePage.showMenu();
        mainSideBar.selectFreshProduce();
        addItemFromFreshProducePage();

        homePage.showMenu();
        mainSideBar.selectMarketPlace();
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

    public void addItemFromFreshProducePage(){

        FreshProducePage freshProducePage = PageFactory.initElements(driver, FreshProducePage.class);

        explicitWait(freshProducePage.getLargeBananasImg(), 10);
        freshProducePage.selectLargeBananas();

        addToCartFromIndividualProductFrame();
    }

    public void addItemFromMarketPlacePage(){

        MarketPlacePage marketPlacePage = PageFactory.initElements(driver, MarketPlacePage.class);

        explicitWait(marketPlacePage.getCoconutSheaButterBodyWash(), 10);
        marketPlacePage.selectBodyWash();

        addToCartFromIndividualProductFrame();
    }

    public void addToCartFromIndividualProductFrame(){

        IndividualProductFrame productFrame = PageFactory.initElements(driver, IndividualProductFrame.class);

        explicitWait(productFrame.getAddToCart(), 10);
        productFrame.addItemToCart();

        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
//        productFrame.exitProductWindow();
    }

    public void getToCartPage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.getCart();
    }


    @Test
    public void TestCartPageForAdditions(){

       CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        List<WebElement> listOfProductOnCart = new ArrayList<WebElement>();

        listOfProductOnCart = cartPage.getListOfItemAddedToCart(driver);

        Assert.assertEquals(listOfProductOnCart.size(), 3);
        Assert.assertEquals(listOfProductOnCart.get(0).getText(), "Colgate Sensitive Pro Relief Repair And Prevent Toothpaste");

    }

    @AfterTest
    public void endTest(){
        driver.close();
        driver.quit();
    }
}
