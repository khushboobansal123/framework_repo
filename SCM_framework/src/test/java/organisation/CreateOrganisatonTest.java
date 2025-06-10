package organisation;

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
import org.testng.annotations.Test;

import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganisationPage;
import com.scm.generic.fileutility.ExcelUtility;
import com.scm.generic.fileutility.FileUtility;
import com.crm.generic.BaseClassUtility.BaseClass;
import com.crm.objectrepository.HomePage;


public class CreateOrganisatonTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		       
	           @Test(groups="smokeTest")
	           public void createOrganisationTest() throws Throwable
	           {
		       //FileUtility futil = new FileUtility();
		       ExcelUtility ex=new ExcelUtility();
				//String Browser = futil.getDataFromProp("bro");
				//String URL = futil.getDataFromProp("url");
				
				
		        
				String orgname = ex.getDataFromExcel("Sheet1",1,0) + (int) (Math.random()*10000);
				
		        
				
				//Opening browser
				/*
				 * WebDriver driver=null; if(Browser.equalsIgnoreCase("chrome")) { driver = new
				 * ChromeDriver(); } else if(Browser.equalsIgnoreCase("edge")) { driver = new
				 * EdgeDriver(); } else if(Browser.equalsIgnoreCase("firefox")) { driver = new
				 * FirefoxDriver(); } else if(Browser.equalsIgnoreCase("safari")) { driver = new
				 * SafariDriver(); } else { driver = new ChromeDriver(); }
				 * 
				 * 
				 * driver.manage().window().maximize();
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				 * 
				 * driver.get(URL);
				 * 
				 * LoginPage lp = new LoginPage(driver);
				 * 
				 * lp.login();
				 */
				
				//Create Organization
			    HomePage hp= new HomePage(driver);
			    hp.getOrganisation().click();
				
				OrganisationPage op=new OrganisationPage(driver);
				op.getPlus().click();
				op.getOrganisationTextfield().sendKeys(orgname);
				op.getSave().click();
				
				
				
				
				//Integration Scenario
				
				Thread.sleep(5000);
				hp.getOrganisation().click();
			    
			    driver.findElement(By.name("search_text")).sendKeys(orgname);
			    
			    WebElement searchIn = driver.findElement(By.name("search_field"));
			    
			    Select sel=new Select(searchIn);
			    sel.selectByVisibleText("Organization Name");
			    
			    driver.findElement(By.xpath("( //input[contains(@value, 'Search Now')])[1]  ")).click();
			    
			    driver.findElement(By.linkText(orgname)).click();
			    
			
			   // String header = driver.findElement(By.className("dvHeaderText")).getText();
			    String orgnameui = driver.findElement(By.id("dtlview_Organization Name")).getText();
			   // Boolean status2 = orgnameui.equals(orgname);
				//Assert.assertTrue(status2);
				
				//System.out.println("Organisation name verified successfully");
				if(orgnameui.equals(orgname))
					System.out.println("Organisation created successfully");
				
				
				
				
				
				/*
				 * hp.logOut(); driver.quit();
				 */
				
				
				

	}

}
