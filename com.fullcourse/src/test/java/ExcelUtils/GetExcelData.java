package ExcelUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	public static void test(String username , String password) throws InterruptedException

	{
		SignInObjects signIn = new SignInObjects(driver);
		ProfileScreen pscreen = new ProfileScreen(driver);
		test = report.createTest("My First Test");
		//System.out.println(username+"|"+password);
		driver.get(baseUrl);
		Thread.sleep(20000);
		signIn.signIn();
		signIn.userName_enter(username);
		signIn.password_enter(password);
		signIn.submit();
		String title = driver.getTitle();
		System.out.println("Titel of the page is :"+title);
		Assert.assertEquals(title, "FinFreedom");
	    Thread.sleep(20000);
	    pscreen.profile_icon();
	    pscreen.profile_option();
	    Thread.sleep(20000);;
	    driver.getWindowHandles();
	    pscreen.modal_out();
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
