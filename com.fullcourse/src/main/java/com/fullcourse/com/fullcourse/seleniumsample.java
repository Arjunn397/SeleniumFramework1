package com.fullcourse.com.fullcourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumsample 
{
	WebDriver driver;

	public void initializeBrowser()
	{
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "/Users/arjun/eclipse-workspace/com.fullcourse/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
	}
	
	public void openURL() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qa.ipru.cybrilla.io/");
		//driver.manage().window().maximize();
		System.out.println("Page Title is"+driver.getTitle());

	    Thread.sleep(20000);
		driver.findElement(By.xpath("//a[contains(text(),\"Sign In\")]")).click();
		System.out.println("Successfully clicked on Sign In link");
	}
	
	public void signIn() throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys("Arjun@cybrilla.com");
		driver.findElement(By.id("password")).sendKeys("Arjun@123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}
	
	public void Homescreen() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement homescreen ;
		homescreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-col header__right')]")));
		driver.findElement(By.xpath("//div[contains(@class,'ant-col header__right')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		Thread.sleep(20000);
		
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		seleniumsample s = new seleniumsample();
		s.initializeBrowser();
		s.openURL();
		s.signIn();
		s.Homescreen();
		s.closeBrowser();
		

	}

}
