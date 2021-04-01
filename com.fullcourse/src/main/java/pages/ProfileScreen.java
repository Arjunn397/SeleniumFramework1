package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileScreen 
{
	WebDriver driver;
	By profile_icon = By.xpath("//div[contains(@class,'ant-col header__right')]");
	By profile_option = By.xpath("//a[contains(text(),'Profile')]");
	By modal_out = By.xpath("//button[@type='button']");
	By profile_icon2  = By.xpath("//div[contains(@class,'ant-col header__right')]");
	By logout = By.xpath("//a[contains(text(),'Logout')]");
	
	
	
	public ProfileScreen(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void profile_icon()
	{
			driver.findElement(profile_icon).click();
			
	}

	public void profile_option()
	{
		driver.findElement(profile_option).click();
	}

	public void modal_out()
	{
		driver.findElement(modal_out).click();
	}

	public void profile_icon2()
	{
		driver.findElement(profile_icon2).click();
	}
	
	public void logout()
	{
		driver.findElement(logout).click();
	}


}
