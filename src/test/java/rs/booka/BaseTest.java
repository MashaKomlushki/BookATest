package rs.booka;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //to disable browser notifications
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false); //to disable the save password popup

        List<String> driverArgs = Arrays.asList("--disable-extensions", "--disable-infobars", "--headless");


        if("firefox".equalsIgnoreCase(browser)) {

            FirefoxOptions options = new FirefoxOptions();

            options.addArguments(driverArgs);
            prefs.forEach((key, value)->{
                options.addPreference(key, value);
            });
            return new FirefoxDriver(options);
    	}

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments(driverArgs);

    	return new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
