package techPandaUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static void wait(WebDriver driver,int timeSec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSec));
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\techPandaMaven\\src\\main\\resources\\configure.properties");
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	public static void takesScreenshot(WebDriver driver,String element) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\screen\\scshot"+element+".jpg");
		FileHandler.copy(src, dest);
		
	}
	public static String readDataFromExcel(int Row,int Cell) throws EncryptedDocumentException, IOException
	{
		File f=new File("D:\\Jul23B\\Sheet1.xlsx");
		Sheet mySheet = WorkbookFactory.create(f).getSheet("Sheet4");
		return mySheet.getRow(Row).getCell(Cell).getStringCellValue();
	}
	public static void scrolling(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}

}
