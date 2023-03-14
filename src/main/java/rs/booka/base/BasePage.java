package rs.booka.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage { ;
    public WebDriver driver;
    public TopMenu topMenu;

    public BasePage(WebDriver driver){
        topMenu = new TopMenu(driver);
        PageFactory.initElements(driver, this);
    }


    }


