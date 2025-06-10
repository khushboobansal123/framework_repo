package contact;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.scm.generic.fileutility.*;
import com.crm.generic.BaseClassUtility.BaseClass;
import com.crm.objectrepository.*;



public class CreateContactWithOrganisationTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		@Test(groups="regressionTest")
		public void createContactWithOrganisationTest() throws Throwable
		{
		//FileUtility futil = new FileUtility();
		ExcelUtility ex=new ExcelUtility();
		
		//String Browser = futil.getDataFromProp("bro");
		
		
		String lastname = ex.getDataFromExcel("Sheet1", 1, 2) + (int) (Math.random()*10000); 
		String orgname = ex.getDataFromExcel("Sheet1", 1, 0) + (int) (Math.random()*10000);
		
		
		//Opening browser
		        
				//WebDriver driver=null;
				//if(Browser.equalsIgnoreCase("chrome"))
				//{
					//driver = new ChromeDriver();
				//}
				//else if(Browser.equalsIgnoreCase("edge"))
				//{
					//driver = new EdgeDriver();
				//}
				//else if(Browser.equalsIgnoreCase("firefox"))
				//{
					//driver = new FirefoxDriver();
				//}
				//else if(Browser.equalsIgnoreCase("safari"))
				//{
					//driver = new SafariDriver();
				//}
				//else {
					//driver = new ChromeDriver();
				//}
				
				
				
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//driver.get(URL);
		
        
		//Create Organization
		HomePage hp= new HomePage(driver);
		hp.getOrganisation().click();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.getPlus().click();;
		op.getOrganisationTextfield().sendKeys(orgname);
		op.getSave().click();
		
		Thread.sleep(3000);
		
		//Create contact with the help of Organization
		hp.getContact().click();
		ContactPage cp = new ContactPage(driver);
		cp.getPlus().click();
		cp.getLastnameTextfield().sendKeys(lastname);
		
		
		
		String parentId = driver.getWindowHandle();
		
		cp.getPlusOgranisation().click();
		Set<String> Ids = driver.getWindowHandles();
		Ids.remove(parentId);
		
		for(String id:Ids)
		{
			driver.switchTo().window(id);
			driver.findElement(By.name("search_text")).sendKeys(orgname);
			WebElement searchIn = driver.findElement(By.name("search_field"));
			Select sel=new Select(searchIn);
			sel.selectByVisibleText("Organization Name");
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.linkText(orgname)).click();
		}
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Integration
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.name("search_text")).sendKeys(lastname);
		WebElement search = driver.findElement(By.name("search_field"));
		
		Select sel = new Select(search);
		sel.selectByVisibleText("Last Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText(lastname)).click();
		
		String lastnameUI = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		if(lastnameUI.equals(lastname))
		{
			System.out.println("Lastname verified successfully");
		}
		
		//Boolean status = lastnameUI.equals(lastname);
		//SoftAssert asserts = new SoftAssert();
		//asserts.assertTrue(status);
		//System.out.println("lastname verified successfully");
		
		String orgnameui = driver.findElement(By.linkText(orgname)).getText();
		if(orgnameui.equals(orgname))
		{
			System.out.println("Organisation name verified successfully");
		}
		
		//Boolean status2 = orgnameui.equals(orgname);
		//Assert.assertTrue(status2);
		
		//System.out.println("Organisation name verified successfully");
		
		
		
		//asserts.assertAll();


	}

}
