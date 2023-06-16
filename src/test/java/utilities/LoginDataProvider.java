package utilities;

import org.testng.annotations.DataProvider;
import rs.booka.BaseTest;

public class LoginDataProvider extends BaseTest {
    @DataProvider(name = "dp")
    public Object[][] getLoginData(){
        Object[][] loginData = new Object[1][2];

        loginData[0][0] = "mama.komlumku18@gmail.com";
        loginData[0][1] = "ZaTest183!";

        return loginData;
    }
}
