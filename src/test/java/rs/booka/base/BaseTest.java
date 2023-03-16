package rs.booka.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.time.Duration;
import java.util.HashMap;
import java.util.Map;





public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public TopMenu menu;

    @BeforeMethod
    public void setUpDriver() {

                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");

                driver = new ChromeDriver(options);
                driver.get("https://www.booka.rs/");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                menu =new TopMenu(driver);
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}


