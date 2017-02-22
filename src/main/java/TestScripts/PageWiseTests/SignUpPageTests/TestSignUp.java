package TestScripts.PageWiseTests.SignUpPageTests;

import PageLibrary.SignUpPage;
import TestScripts.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class TestSignUp extends TestBase {

    WebDriver driver = null;

    @BeforeTest
    public void initiate() throws InterruptedException {
        driver = super.setUp();
    }

    @Test(enabled = false)
    public void signUpPageElementExistence() throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        Thread.sleep(10000);

        Reporter.log("waiting for page to load .....");

        Assert.assertTrue(signUpPage.getEmailAddressField() != null);
        Assert.assertTrue(signUpPage.getPasswordField() != null);
        Assert.assertTrue(signUpPage.getConfirmPasswordField() != null);
        Assert.assertTrue(signUpPage.getSignUpButton() != null);
        Assert.assertTrue(signUpPage.getPrivacyAgreementCheckBox() != null);
    }


    @Test(dataProvider = "email_addresses", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = false)
    public void testEmailAddressField(String emailAddress, Boolean expectedResult ) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Thread.sleep(10000);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        signUpPage.enterEmailAddress(emailAddress);

        Assert.assertEquals(expectedResult, isAlertPresent());
    }

    @Test(dataProvider = "passwords", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = false)
    public void testPasswordFieldForConstraints(String password, Boolean expectedResult) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();
        signUpPage.enterEmailAddress("Agoeme80@gustr.com");
        signUpPage.enterPassWord(password);
        signUpPage.confirmPassword(password);

        signUpPage.checkThePrivacyAgreementBox();

        signUpPage.signUp();

        Assert.assertEquals(expectedResult, isAlertPresent());
    }

    @Test(dataProvider = "confirmPasswords", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = true)
    public void testPasswordFieldsForMismatches(String password, String confirmPassword) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        Thread.sleep(3000);

        signUpPage.enterEmailAddress("Agoeme80@gustr.com");
        signUpPage.enterPassWord(password);
        signUpPage.confirmPassword(confirmPassword);

        signUpPage.checkThePrivacyAgreementBox();

        signUpPage.signUp();

        if(password.equals(confirmPassword))
        Assert.assertTrue(isAlertPresent());
        else
            Assert.assertFalse(isAlertPresent());
    }


    @Test(enabled = false)
    public void testPrivacyAgreementCheckBoxIsCompulsory() throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        signUpPage.enterEmailAndPasswordDetails("bondinthepond@gmail.com", "Test123");

        signUpPage.signUp();

        Assert.assertTrue(isAlertPresent());
        Assert.assertEquals(textPresentInAlert(), "Please tick this box if you want to proceed.");
    }
}
