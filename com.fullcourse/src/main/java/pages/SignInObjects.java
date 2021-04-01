package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInObjects 
{
	
	WebDriver driver;
	By signIn_click = By.xpath("//a[contains(text(),'Sign In')]");
	By userName_enter = By.xpath("//input[@id='email']");
	By password_enter = By.xpath("//input[@id='password']");
	By submit  = By.xpath("//button[@type='submit']");
	
	
	
	public SignInObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
public void signIn()
{
		driver.findElement(signIn_click).click();
		
}

public void userName_enter(String username)
{
	driver.findElement(userName_enter).sendKeys(username);
}

public void password_enter(String password)
{
	driver.findElement(password_enter).sendKeys(password);
}

public void submit()
{
	driver.findElement(submit).click();
}

}
