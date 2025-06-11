package contact;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.generic.fileutility.*;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.HomePage;
import com.crm.generic.BaseClassUtility.BaseClass;
import com.crm.objectrepository.ContactPage;

@Listeners(com.crm.generic.ListenerUtility.ListImp.class)
public class CreateContactWithLastNameTest extends BaseClass{

	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		@Test(groups="regressionTest")
		public void createContactWithLastNameTest() throws Throwable {
		//FileUtility futil = new FileUtility();
		ExcelUtility ex=new ExcelUtility();
		//String Browser = futil.getDataFromProp("bro");
		//String URL = futil.getDataFromProp("url");
		
		
        
		String lastname = ex.getDataFromExcel("Sheet1", 1, 2)+(int) (Math.random() * 10000);
		
        
		
		//Opening browser
		/*
		 * WebDriver driver; if(Browser.equalsIgnoreCase("chrome")) { driver = new
		 * ChromeDriver(); } else if(Browser.equalsIgnoreCase("edge")) { driver = new
		 * EdgeDriver(); } else if(Browser.equalsIgnoreCase("firefox")) { driver = new
		 * FirefoxDriver(); } else if(Browser.equalsIgnoreCase("safari")) { driver = new
		 * SafariDriver(); } else { driver = new ChromeDriver(); }
		 * 
		 */ /*
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 * 
			 * driver.get(URL);
			 * 
			 */ /*
				 * LoginPage lp = new LoginPage(driver);
				 * 
				 * lp.login();
				 */
		
		HomePage hp= new HomePage(driver);
		hp.getContact().click();
		ContactPage cp = new ContactPage(driver);
		cp.getPlus().click();
		cp.getLastnameTextfield().sendKeys(lastname);
		cp.getSave().click();
		
		//Integration
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.name("search_text")).sendKeys(lastname);
		WebElement search = driver.findElement(By.name("search_field"));
		
		Select sel = new Select(search);
		sel.selectByVisibleText("Last Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText(lastname)).click();
		
        String lastnameUI = driver.findElement(By.id("dtlview_Last Name")).getText()+" ";
		
		/*
		 * if(lastnameUI.equals(lastname)) {
		 * System.out.println("Lastname verified successfully"); }
		 */
		Assert.assertEquals(lastnameUI, lastname);
		Reporter.log("Lastname verified successfully",true);
		/*
		 * hp.logOut(); driver.quit();
		 */


	}
		
		@Test(groups="regressionTest")
		public void createConwithDate() {
			System.out.println("Contact with date is created");		}

}
