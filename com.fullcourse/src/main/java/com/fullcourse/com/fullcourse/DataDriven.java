package com.fullcourse.com.fullcourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven 
{
	WebDriver driver ;
	
	@Test(dataProvider="Dataset")
	public void LoginTest(String username , String password) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/arjun/git/SeleniumFramework1/com.fullcourse/drivers/chromedriver/chromedriver" );
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qa.ipru.cybrilla.io/");
		//driver.manage().window().maximize();
		System.out.println("Page Title is"+driver.getTitle());

	    Thread.sleep(20000);
		driver.findElement(By.xpath("//a[contains(text(),\"Sign In\")]")).click();
		System.out.println("Successfully clicked on Sign In link");
		
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
		
		
	}
	
	
	@DataProvider(name="Dataset")
	public Object[][] passData()
	{
		
		Object[][] data = new Object[1][2];
		
		data[0][0]="Arjun@cybrilla.com";
		data[0][1]="Arjun@123";
		
		return data;
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
