import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.mullela on 22/02/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        TestNG testNG = new TestNG();

        List<String> suiteFile = new ArrayList<String>();

        suiteFile.add("/Users/aditya.mullela/git2/RedMartAutomation/src/main/resources/testng.xml");

        testNG.setTestSuites(suiteFile);

        testNG.run();
    }
}
