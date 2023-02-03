package techPandaPom;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import techPandaUtility.Utility;

public class MobilePage 
{
	@FindBy(xpath="//h1[text()='Mobile']") private WebElement testOnMobPg;
	@FindBy(xpath="(//select[@title='Sort By'])[1]") private WebElement options;
	@FindBy(id="product-collection-image-1") private WebElement sonyMobButton;
	@FindBy(xpath="(//span[@class='price'])[4]") private WebElement sonyMobPrice;
	@FindBy(xpath="(//span[text()='Add to Cart'])[2]") private WebElement addToCartBt;
	@FindBy(xpath="(//a[text()='Add to Compare'])[1]") private WebElement addToCompair1;
	@FindBy(xpath="(//a[text()='Add to Compare'])[3]") private WebElement addToCompair2;
	@FindBy(xpath="//span[text()='Compare']") private WebElement compairBt;
	@FindBy(xpath="//span[text()='Close Window']") private WebElement closeWindowBt;

	public MobilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getMobText(WebDriver driver)
	{
		Utility.wait(driver, 4);
		return testOnMobPg.getText();
		
		
	}
	public void selectOptions()
	{
		Select se=new Select(options);
		se.selectByVisibleText("Name");
		
	}
	
	public String getingPriceOfSony(WebDriver driver)
	{
		Utility.wait(driver, 3);
		return sonyMobPrice.getText();
	}
	
	public void clickingOnSonyButton(WebDriver driver)
	{
		sonyMobButton.click();
	}
	public void clickingOnAddToCart(WebDriver driver)
	{
		addToCartBt.click();
	}
	
	public void selectingIteamForCompair(WebDriver driver) throws IOException, InterruptedException
	{
		addToCompair1.click();
		addToCompair2.click();
		compairBt.click();
		Thread.sleep(3000);
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		Iterator<String> it = ids.iterator();
		String mainPg = it.next();
		String childPg = it.next();
		driver.switchTo().window(childPg);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Utility.takesScreenshot(driver, "compairing");
		Thread.sleep(1000);
        Utility.scrolling(driver, closeWindowBt);
		
		Thread.sleep(1000);
		closeWindowBt.click();
		driver.switchTo().window(mainPg);
	}

}
