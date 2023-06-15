package rs.booka;

import base.BaseMenu;
import org.testng.annotations.Test;

public class BooksLinkTest extends BaseTest{

    @Test
    public void testBooksLink(){
        BaseMenu base = new BaseMenu(driver);
        base.goToBooks();
    }



}
