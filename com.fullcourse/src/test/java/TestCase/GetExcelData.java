package TestCase;

import org.testng.annotations.Test;

import ExcelUtils.ExcelUtil;
import ExcelUtils.TestBase;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ProfileScreen;
import pages.SignInObjects;

public class GetExcelData extends TestBase
{

  
    
    
	@Test(dataProvider = "test1data")
	public static void test(String username,String password) throws InterruptedException

	{
		SignInObjects signIn = new SignInObjects(driver);
		ProfileScreen pscreen = new ProfileScreen(driver);
		test = report.createTest("My First Test");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Thread.sleep(20000);
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		            .withTimeout(30, TimeUnit.SECONDS)
		            .pollingEvery(5, TimeUnit.SECONDS)
		            .ignoring(NoSuchElementException.class);

		    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
		        }
		    });
	
		//Sign in using the Existing Investor Credentials
		signIn.signIn();
		signIn.userName_enter(username);
		signIn.password_enter(password);
		signIn.submit();
		Thread.sleep(20000);
		
		//Get the Title of the Home page and Compare it with the Expected
		String title = driver.getTitle();
		System.out.println("Titel of the page is :"+title);
		AssertJUnit.assertEquals(title, "FinFreedom");
		Thread.sleep(20000);
	    
	    //Navigate to profile screen and close the Modal
	    pscreen.profile_icon();
	    pscreen.profile_option();
	    Thread.sleep(20000);
	    driver.getWindowHandles();
	    pscreen.modal_out();
	    
	    //Logout the Investor
	    pscreen.profile_icon2();
	    pscreen.logout();
	    
	}


	
	public Object[][] testData(String excelPath, String sheetName) throws IOException
	{
		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object [][] data = new Object[rowCount-1][colCount];
		for(int i = 1; i<rowCount ; i++)
		{
			for (int j =0 ; j<colCount ; j++)
			{
				data[i-1][j] = excel.getCellData(i, j);
			}
		}
		return data;

	}





	@DataProvider(name = "test1data")
	public Object[][] dataProvide() throws IOException
	{
		String excelPath = "/Users/arjun/eclipse-workspace/PMF/excel/Book1.xlsx";
		Object [][] data = testData(excelPath,"login_credentials");
		return data;
	}

}
