package techPandaMavenTest;

import org.testng.annotations.Test;

import techPandaMavenBase.Base;
import techPandaPom.HomePage;
import techPandaPom.MobilePage;
import techPandaPom.ShoppingCart;
import techPandaPom.SonyXperiyaPage;
import techPandaUtility.Utility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TechPandaTest extends Base 
{
	HomePage home;
	MobilePage mPage;
	SonyXperiyaPage sxp;
	ShoppingCart cart;
	
  @Test (priority =0 )
  public void sortedByFunctionality() throws InterruptedException, IOException 
  {
	  
	 Assert.assertEquals(home.gettingText(driver), Utility.readDataFromPropertyFile("homeText"));
	 home.clickOnMobButton(driver);
	 Assert.assertEquals(mPage.getMobText(driver), Utility.readDataFromPropertyFile("mobText"));
	 mPage.selectOptions();
	 Utility.wait(driver, 1);
	 Utility.takesScreenshot(driver, mPage.getMobText(driver));
	 String p1 = mPage.getingPriceOfSony(driver);
	 Reporter.log(p1, true);
	 mPage.clickingOnSonyButton(driver);
	 Reporter.log(sxp.sonyXpRate(driver), true);
	 Assert.assertEquals(p1, sxp.sonyXpRate(driver));
	 Reporter.log("Rate of Sony Xperiya mobile on both page is same", true);
	  
  }
  
  @Test (priority = 1)
  public void addToCartFunctionality() throws IOException
  {
	  home.clickOnMobButton(driver);
	  mPage.clickingOnAddToCart(driver);
	  cart.addingQtyToCart(driver);
	  Assert.assertEquals(cart.getErrorMsg(driver), Utility.readDataFromPropertyFile("errorMsg"));
	  Reporter.log("Actual and Expected Error are same", true);
	  Utility.takesScreenshot(driver, "ErrorMsg");
	  cart.removingItems(driver);
	 Assert.assertEquals(cart.checkingCart(driver), Utility.readDataFromPropertyFile("cart"));
	 Reporter.log("cart is empty", true);
	 Utility.takesScreenshot(driver, "cart");
	  
  }
  @Test (priority = 2)
  
  public void compairingTwoProduct() throws IOException, InterruptedException
  {
	  home.clickOnMobButton(driver);
	  mPage.selectingIteamForCompair(driver);
	  
	  
  }
  

  @BeforeClass
  public void launchingVctc() throws IOException 
  {
	  launchBrowser();
	  home=new HomePage(driver);
	  mPage=new MobilePage(driver);
	  sxp=new SonyXperiyaPage(driver);
	  cart=new ShoppingCart(driver);

	  
	  
  }

  @AfterClass
  public void closingBrowser() 
  {
	  closeBrowser();
	  
  }

}
