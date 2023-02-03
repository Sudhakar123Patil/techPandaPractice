package techPandaPom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techPandaUtility.Utility;

public class ShoppingCart 
{
	@FindBy(xpath="(//input)[4]") private WebElement quantityBox;
	@FindBy(xpath="(//button)[8]") private WebElement updateButton;
	@FindBy(xpath="(//p)[5]") private WebElement errorText;
	@FindBy(xpath="(//a)[5]") private WebElement cartBt;
	@FindBy(xpath="(//a)[10]") private WebElement qtyRemovingLink;
	@FindBy(xpath="//p[@class='empty']") private WebElement qtyStatus;


	
	public ShoppingCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addingQtyToCart(WebDriver driver)
	{
		quantityBox.sendKeys("000");
		Utility.wait(driver, 3);
		updateButton.click();
	}
	public String getErrorMsg(WebDriver driver)
	{
		Utility.wait(driver, 3);
		return errorText.getText();
	}
	
	public void removingItems(WebDriver driver)
	{
		cartBt.click();
		Utility.wait(driver, 3);
		qtyRemovingLink.click();
		Utility.wait(driver, 3);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
	}
	public String checkingCart(WebDriver driver)
	{
		Utility.wait(driver, 3);
		return qtyStatus.getText();
	}


}
