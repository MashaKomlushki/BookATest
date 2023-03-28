package rs.booka;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

@Test
    public void openWebsite(){

    driver.get(generalSettings.getString("baseURL"));
    String URL = driver.getCurrentUrl();
    Assert.assertEquals(URL, generalSettings.getString("baseURL") );


}
}
