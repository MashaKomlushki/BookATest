package rs.booka;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
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
    void setUp(){
    	String browser = generalSettings.getString("browser");
    
        driver = loadWebdriver(browser);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(generalSettings.getString("implicit.wait"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(generalSettings.getString("explicit.wait"))));
        driver.get(generalSettings.getString("baseURL"));
    }
    
    private WebDriver loadWebdriver(String browser) {
    	if("firefox".equalsIgnoreCase(browser)) {
    		return new FirefoxDriver();
    	}
    	return new ChromeDriver();
    }

    @AfterMethod

    public void tearDown(){

        driver.quit();
    }

}
