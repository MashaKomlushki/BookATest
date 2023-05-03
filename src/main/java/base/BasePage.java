package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public BaseMenu base;

    public BasePage(WebDriver driver){
        this.driver = driver;
        base= new BaseMenu(driver);
        PageFactory.initElements(driver, this);
    }


}
