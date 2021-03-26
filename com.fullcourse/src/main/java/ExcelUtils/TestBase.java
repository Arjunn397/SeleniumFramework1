package ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class TestBase 
{
	
	public static WebDriver driver;
	public static String username;
	public static String password;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void  setExtent()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	
	@AfterTest(alwaysRun = true)
	public void endExtent()
	{
		extent.flush();
		driver.quit();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult itr) throws IOException
	{
		if(itr.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed is"+itr.getName());
			test.log(Status.FAIL, "Test Case Failed is"+ itr.getThrowable());
			String screenshotPath = TestBase.getScreenshot(driver, itr.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
		else if(itr.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case SKIPPED IS" + itr.getName());
		}
		
		else if(itr.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.SKIP, "Test Case SKIPPED IS" + itr.getName());
		}
	
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmdss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") +"/test-output/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;

	}
		
	}


