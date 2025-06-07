package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\SCM_framework\\src\\main\\resources\\datadriven.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("bro");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("un");
		String password = pobj.getProperty("pwd");
		
		Random random = new Random();
		int num=random.nextInt(1000);
		
		
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Asus\\OneDrive\\Desktop\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh=wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String lastname = cell.toString() + num;
		
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
				
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				
				Date dateobj = new Date();
				SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
				String startdate=sim.format(dateobj);
				
				
				Calendar cal=sim.getCalendar();
				cal.add(Calendar.DAY_OF_MONTH, 30);
				String enddate=sim.format(cal.getTime());
				
				
				
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(startdate);
				
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(enddate);
				
				
				
				
				driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
				
				
				String startdateUI = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(startdateUI.equals(startdate))
					{
						System.out.println("Support Start Date verified successfully");
					}
				else
				{
					System.out.println("Support Start Date not verified successfully");
				}
				
				String enddateUI = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(enddateUI.equals(enddate))
					{
						System.out.println("Support End Date verified successfully");
					}
				else
				{
					System.out.println("Support End Date not verified successfully");
				}
				
				Actions act = new Actions(driver);
				WebElement profile = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				act.moveToElement(profile).build().perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
		

	}

}
