package ExcelUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport 
{



static ExtentHtmlReporter extent;
static ExtentReports reports;
static ExtentTest test;
static WebDriver driver;

public static void main (String[] args)
{
	extent = new ExtentHtmlReporter("extentReport.html");
	reports = new ExtentReports();
	reports.attachReporter(extent);
	
	test = reports.createTest("MyFirstTest");
	

	System.setProperty("webdriver.chrome.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver");
	driver = new ChromeDriver();
	driver.get("https://qa.ipru.cybrilla.io");
	test.pass("Navigated to Finfreedom");
	test.info("Test Completed");
	
	reports.flush();
	
}

}
