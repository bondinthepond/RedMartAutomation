package DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class DataProviderForSignUpPage {

    @DataProvider(name = "email_addresses")
    public static Object[][] emailAddresses() {
        return new Object[][] {
                {"tester", false},
                {"bondinthepond@", false},
                {" ", false},
                {"bondinthepond@gmail", false},
                {"bondinthepond@gmail.com", true}};
    }

    @DataProvider(name = "passwords")
    public static Object[][] passwords() {
        return new Object[][] {
                {"tester", false},
                {"Tst12!", false},
                {"Test123!@#", true},};
    }

    @DataProvider(name = "confirmPasswords")
    public static Object[][] confirmPasswords() {
        return new Object[][] {
                {"Test123!@#","Test456$%"}};
    }
}
