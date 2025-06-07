package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganisation {
	
	@Test
	public void createOrganisationtest(XmlTest test) throws IOException {
		//FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\SCM_framework\\src\\main\\resources\\datadriven.properties");
		//Properties pobj=new Properties();
		//pobj.load(fis);
		//String Browser = System.getProperty("browser");
		//String url = System.getProperty("url");
		//String username = System.getProperty("un");
		//String password = System.getProperty("pwd");
		String Browser = test.getParameter("browser");
		String url = test.getParameter("url");
		String username = test.getParameter("username");
		String password = test.getParameter("password");
		Random random = new Random();
		int num=random.nextInt(1000);
		
		
		FileInputStream fis2 = new FileInputStream("C:\\\\Users\\\\Asus\\\\OneDrive\\\\Desktop\\\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh=wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String orgname = cell.toString() + num;
		
		WebDriver driver = null;
				if(Browser.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(Browser.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
				}
				else if(Browser.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else if(Browser.equalsIgnoreCase("safari"))
				{
					driver = new SafariDriver();
				}
				else {
					driver = new ChromeDriver();
				}
				
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				driver.get(url);
				
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				
				driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
				
		

	}


}
