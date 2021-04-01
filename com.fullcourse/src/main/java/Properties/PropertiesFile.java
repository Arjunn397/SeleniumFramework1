package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import ExcelUtils.TestBase;

public class PropertiesFile 
{
	
	static Properties prop = new Properties();

	public static void getProperties() throws IOException
	{
		
		InputStream input = new FileInputStream("/Users/arjun/git/SeleniumFramework1/com.fullcourse/src/main/java/Properties/config.properties");
		prop.load(input);
		String browser = prop.getProperty("browser");
		String baseUrl = prop.getProperty("baseUrl");
		System.out.println(browser);
		System.out.println(baseUrl);
		TestBase.browserName = browser;
		TestBase.baseUrl = baseUrl;
	}
	
	
	public static void setProperties() throws IOException
	{
		OutputStream output = new FileOutputStream("/Users/arjun/git/SeleniumFramework1/com.fullcourse/src/main/java/Properties/config.properties");
		prop.setProperty("browser" , "firefox");
		prop.store(output, null);
		
	}
	
	
	public static void main(String[] args) throws IOException
	{
		getProperties();
		setProperties();
		getProperties();
	}
}
