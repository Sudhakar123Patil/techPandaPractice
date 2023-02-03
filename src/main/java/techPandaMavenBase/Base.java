package techPandaMavenBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import techPandaUtility.Utility;

public class Base 
{
	protected static WebDriver driver;
	public static void launchBrowser() throws IOException 
	{
		System.setProperty("webdriver.Geco.driver", "D:\\Jul23B\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get(Utility.readDataFromPropertyFile("url"));
		Utility.wait(driver, 2);
	}
	public static void closeBrowser()
	{
		Utility.wait(driver, 2);
		driver.close();
	}

}
