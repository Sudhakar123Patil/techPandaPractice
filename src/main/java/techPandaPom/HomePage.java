package techPandaPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techPandaUtility.Utility;

public class HomePage 
{
	@FindBy(xpath="//h2[contains(text(),'This is demo site for')]") private WebElement text;
	@FindBy(xpath="//a[text()='Mobile']") private WebElement mobileButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettingText(WebDriver driver)
	{
		Utility.wait(driver, 4);
		return text.getText();
		
	}
	public void clickOnMobButton(WebDriver driver)
	{
		mobileButton.click();
		Utility.wait(driver, 4);
	}

}
