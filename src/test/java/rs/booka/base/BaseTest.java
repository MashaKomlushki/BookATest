package rs.booka.base;

import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import rs.booka.utilities.ExcelReader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;




public class BaseTest {
    public  WebDriver driver;
    private Properties config = new Properties();
    private FileInputStream fis;
    private Logger log = Logger.getLogger(BaseTest.class);
    public ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
    public WebDriverWait wait;

    public ExtentTest test;
    public String browser;

    public TopMenu menu;


    public BaseTest() {
        PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

        if (driver == null) {
            try {
                fis = new FileInputStream("./src/test/resources/properties/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.info("Config file loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }



            if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

                browser = System.getenv("browser");
            } else {

                browser = config.getProperty("browser");

            }

            config.setProperty("browser", browser);


            if (config.getProperty("browser").equals("chrome")) {


                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                log.info("Launching Chrome!!!");
            } else if (config.getProperty("browser").equals("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("Launching Firefox !!!");

            } else if (config.getProperty("browser").equals("ie")) {

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                log.info("Launching Internet Explorer");

            }
            driver.get(config.getProperty("testSiteURL"));
            log.info("Navigated to : " + config.getProperty("testSiteURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
            wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));

            menu = new TopMenu(driver);
        }
    }




    @AfterMethod
    public void tearDown() {

        driver.quit();
        log.info("Test Execution completed !!!");
    }

    }


