package ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Properties.PropertiesFile;
//import com.extentReport.extentReporting.TestBase;
//import com.extentReport.extentReporting.TestBase;

public class TestBase 

{

	public static WebDriver driver;
	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String browserName = null;
	public static String baseUrl = null;

	@BeforeTest
	public static void initDriver() throws IOException
	{
		
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/geckodriver/geckodriver 2");
		driver = new FirefoxDriver();
		}
	}


	@BeforeTest
	public void setExtent() 
	{
		extent = new ExtentHtmlReporter("extentReport.html");

		report = new ExtentReports();

		report.attachReporter(extent);

	}



	@AfterTest
	public static void closeBrowser()
	{
		report.flush();
		driver.quit();

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

			String screenshotPath = TestBase.getScreenshot(driver, result.getName());

			test.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS" + result.getName());

		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS" + result.getName());
		}

		
	}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("Failed screenshot.png"));
		return screenshotName;
	}


}
