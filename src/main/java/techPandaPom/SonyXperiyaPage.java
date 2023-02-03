package techPandaPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techPandaUtility.Utility;

public class SonyXperiyaPage 
{
	@FindBy(xpath="//span[@class='price']") private WebElement sonyXpPrice;
	

	
	public SonyXperiyaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String sonyXpRate(WebDriver driver)
	{
		Utility.wait(driver, 3);
		return sonyXpPrice.getText();
	}
	

}
