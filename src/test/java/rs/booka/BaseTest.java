package rs.booka;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    
	protected static ResourceBundle generalSettings = ResourceBundle.getBundle("general-settings");
	
	@BeforeClass
	static void initTests() {
        //dodato zbog greske sa Chrome driverom
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        
	}

    @Test
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.booka.rs/");
    }

}
