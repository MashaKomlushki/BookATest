package rs.booka.testcases;

import org.testng.annotations.Test;
import rs.booka.base.BaseTest;
import rs.booka.base.TopMenu;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        TopMenu menu = new TopMenu(driver);
        menu.gotoPrijaviSe().doLogin("mama.komlumku18", "ZaTest183!");

    }


}
