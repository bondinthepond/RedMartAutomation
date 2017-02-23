package TestScripts.PageWiseTests.HomePageTests;

import PageLibrary.HomePage;
import TestScripts.TestBase;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class TestHomePage extends TestBase{

    WebDriver driver = null;

    @BeforeClass
    public void initiate() throws InterruptedException {
        driver = super.setUp();
    }

    @Test
    public void homePageElementExistence() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Thread.sleep(10000);
        Reporter.log("waiting for page to load .....");

        Assert.assertTrue(homePage.getSignUpButton() != null);

        Assert.assertTrue(homePage.getSearchBar()!= null);
    }

}
