package Sample;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport 
{

	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	static ExtentTest test;
	static WebDriver driver;
	
	@BeforeMethod
	public void htmlreport() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		reporter = new  ExtentHtmlReporter("ExtentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("My first TEST");
		getScreenShot("Failed Screenshot");
	}
	
	
	public void getScreenShot(String fileName) throws IOException
	{
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(file, new File("/Users/arjun/git/SeleniumFramework1/com.fullcourse/Screenshots/"+fileName+".png"));
	}
	
	@AfterMethod
	public void endReport()
	{
		extent.flush();
		//driver.quit();
	}
	
	
}
