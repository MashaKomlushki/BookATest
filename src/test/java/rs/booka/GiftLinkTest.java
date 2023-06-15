package rs.booka;

import base.BaseMenu;
import org.testng.annotations.Test;


public class GiftLinkTest extends BaseTest{

    @Test
    public void testGiftLink(){
        BaseMenu base = new BaseMenu(driver);
        base.goToGift();
    }
}
