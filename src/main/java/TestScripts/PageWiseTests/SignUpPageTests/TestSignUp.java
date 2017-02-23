package TestScripts.PageWiseTests.SignUpPageTests;

import PageLibrary.SignUpPage;
import TestScripts.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class TestSignUp extends TestBase {

    WebDriver driver = null;

    @BeforeClass
    public void initiate() throws InterruptedException {
        driver = super.setUp();
    }

    @Test(enabled = true, priority = 0,groups = "testSingUp")
    public void signUpPageElementExistence() throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        driverWait();

        Reporter.log("waiting for page to load .....");

        Assert.assertTrue(signUpPage.getEmailAddressField() != null);
        Assert.assertTrue(signUpPage.getPasswordField() != null);
        Assert.assertTrue(signUpPage.getConfirmPasswordField() != null);
        Assert.assertTrue(signUpPage.getSignUpButton() != null);
        Assert.assertTrue(signUpPage.getPrivacyAgreementCheckBox() != null);
    }


    @Test(dataProvider = "email_addresses", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = true, groups = "testSingUp")
    public void testEmailAddressField(String emailAddress, Boolean expectedResult ) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        driverWait();

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        signUpPage.enterEmailAddress(emailAddress);

        Assert.assertTrue(expectedResult.equals(isAlertPresent()));
    }

    //this test will fail
    @Test(dataProvider = "passwords", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = false, groups = "testSingUp")
    public void testPasswordFieldForConstraints(String password, Boolean expectedResult) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        driverWait();

        signUpPage.startSignUp();
        signUpPage.enterEmailAddress("Daunt1969@einrot.com");
        signUpPage.enterPassWord(password);
        signUpPage.confirmPassword(password);

        signUpPage.checkThePrivacyAgreementBox();

        signUpPage.signUp();

        Assert.assertTrue(expectedResult.equals(isAlertPresent()));
    }

    @Test(dataProvider = "confirmPasswords", dataProviderClass = DataProviders.DataProviderForSignUpPage.class, enabled = true, groups = "testSingUp")
    public void testPasswordFieldsForMismatches(String password, String confirmPassword) throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        driverWait();

        signUpPage.enterEmailAddress("Daunt1969@einrot.com");
        signUpPage.enterPassWord(password);
        signUpPage.confirmPassword(confirmPassword);

        signUpPage.checkThePrivacyAgreementBox();

        signUpPage.signUp();

        if(password.equals(confirmPassword))
        Assert.assertTrue(isAlertPresent());
        else
            Assert.assertFalse(isAlertPresent());
    }


    @Test(enabled = false, groups = "testSingUp")
    public void testPrivacyAgreementCheckBoxIsCompulsory() throws InterruptedException {

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        Reporter.log("waiting for page to load .....");

        signUpPage.startSignUp();

        signUpPage.enterEmailAndPasswordDetails("Daunt1969@einrot.com", "Test123!@#");

        signUpPage.signUp();

        Assert.assertTrue(isAlertPresent());
        Assert.assertEquals(textPresentInAlert(), "Please tick this box if you want to proceed.");
    }

    @AfterTest
    public void endTest(){
        driver.close();
        driver.quit();
    }
}
