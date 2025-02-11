package framework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Utility 
{
	WebDriver driver;
	String browsername ;
	String Application;
	
	void driverSetting()
	{
		try
		{
			FileInputStream file = new FileInputStream("D:\\selenium\\setup\\testExcel\\book 2 framework.xlsx");
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			
			XSSFRow row = sheet.getRow(1);
			
			 browsername = row.getCell(0).getStringCellValue();
			
			 Application  = row.getCell(1).getStringCellValue();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		if(browsername.equals("chrome"))//two string variable we can compair by using equals method
		{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\setup\\ChromeDriverFile\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equals("firefox"))
		{
			System.out.println("firefox will be executed");
		}// TODO Auto-generated method stub
		else 
		{
			System.out.println("internet explore will be executed");
		}
        	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(Application);//that "application link,if customer want to change the browser then he will easily change from excel file which we provided.customer change that browser only. 
		}
	
    WebElement elementFinder(By obj)
{
	WebElement element = driver.findElement(obj);
	return element;
} }

