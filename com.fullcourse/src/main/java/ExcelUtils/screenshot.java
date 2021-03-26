package ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
//import org.apache.commons.io.FileUtils;





public class screenshot 
{
	static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://uat.transact.principalindia.com/app/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getScreenshot("Failed Screenshot");
		
		
	}
	
	
	
	public static void getScreenshot(String fileName) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(file, new File("/Users/arjun/git/SeleniumFramework1/com.fullcourse/Screenshots/"+fileName+".png"));
	}

}
