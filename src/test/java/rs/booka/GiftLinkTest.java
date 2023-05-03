package rs.booka;

import base.BaseMenu;
import org.testng.annotations.Test;


public class GiftTest extends BaseTest{

    @Test
    public void testGift(){
        BaseMenu base = new BaseMenu(driver);
        base.goToGift();
    }
}
