package All_concepts_under_selenium;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest 
{
	
	public static WebDriver driver ;
	
	public static void initDriver()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
	}
	
	public static void searchChrome()
	{
		driver.get("https://qa.ipru.cybrilla.io");
	}
	
	public static void tearDown()
	{
		driver.quit();
	}
   
	
     public static void main(String[] args)
     {
    	 initDriver();
    	 searchChrome();
    	 tearDown();
    	 
     }

}
