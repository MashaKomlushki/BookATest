package rs.booka;

import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTest extends BaseTest{


@Test
    public void testLogin(){
        HomePage home = new HomePage(driver);
        home.goToSignIn();
        home.signIn();
    }
}
