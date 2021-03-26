package Sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcelUtil extends ExtentReport
{

	public Object[][] testdata(String excelPath, String sheetName) throws IOException
	{
		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
	int rowCount = 	excel.getRowCount();
	int colCount =excel.getColCount();
		Object [][] data = new Object [rowCount-1][colCount];
		for (int i =1; i<rowCount ; i++)
		{
			for(int j=0;j<colCount ;j++)
			{
				data[i-1][j] = excel.getCellData(i, j);
			}
		}
		return data;
		
	}
	
	
	@Test(dataProvider = "test1data")
	public void test(String username , String password) throws InterruptedException
	{
		driver.get("https://qa.ipru.cybrilla.io");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[contains(text(),\"Sign In\")]")).click();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement homescreen ;
		homescreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-col header__right')]")));
		driver.findElement(By.xpath("//div[contains(@class,'ant-col header__right')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		Thread.sleep(20000);
		driver.getWindowHandles();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ant-col header__right')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Thread.sleep(20000);
		test.pass("Navigated to Finfreedom");
		test.info("Test Completed");
	}
		
	
	
	
	
	
	
	@DataProvider(name = "test1data")
	public  Object[][] dataPro() throws IOException
{
		String excelPath = "/Users/arjun/eclipse-workspace/PMF/excel/Book1.xlsx";
		Object [][]data = testdata(excelPath, "login_credentials");
		return data;
}
	
}
