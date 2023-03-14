package rs.booka.extentListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import rs.booka.base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class ExtentManager{

	private static ExtentReports extent;
	public static String fileName;







	public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Masha Komlushki");
	        extent.setSystemInfo("Organization", "MashaTesting");
	        extent.setSystemInfo("Build no", "M-01");
	        
	        
	        return extent;
	    }

	    
		public static void captureScreenshot() throws IOException {
			
			Date d = new Date();
			 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";


			
			File screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(".//reports//"+fileName));
		}
		
		

		public static void captureElementScreenshot(WebElement element) throws IOException {
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			
			
			File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(".//screenshot//"+"Element_"+fileName));
		}

	 


	}
