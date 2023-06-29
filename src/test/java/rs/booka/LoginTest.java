package rs.booka;


import org.testng.annotations.Test;
import pages.HomePage;
import utilities.CSVDataProvider;


public class LoginTest extends BaseTest{


@Test(dataProviderClass = CSVDataProvider.class,dataProvider = "dp1")
    public void testLogin(String Username, String Password){
        HomePage home = new HomePage(driver);
        home.goToSignIn();
        home.signIn(Username, Password);
    }
}
