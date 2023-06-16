package rs.booka;


import org.testng.annotations.Test;
import pages.HomePage;
import utilities.LoginDataProvider;

public class LoginTest extends BaseTest{


@Test(dataProviderClass = LoginDataProvider.class,dataProvider = "dp")
    public void testLogin(String Username, String Password){
        HomePage home = new HomePage(driver);
        home.goToSignIn();
        home.signIn(Username, Password);
    }
}
