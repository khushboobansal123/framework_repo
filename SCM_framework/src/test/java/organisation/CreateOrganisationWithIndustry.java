package organisation;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.scm.generic.fileutility.ExcelUtility;
import com.scm.generic.fileutility.FileUtility;
import com.crm.objectrepository.LoginPage;
import com.crm.generic.BaseClassUtility.BaseClass;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.OrganisationPage;

public class CreateOrganisationWithIndustry extends BaseClass {

	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
         @Test(groups="regressionTest")
         public void createOrganisationWithIndustry() throws Throwable, IOException
         {
		//FileUtility futil = new FileUtility();
		ExcelUtility ex=new ExcelUtility();
		//String Browser = futil.getDataFromProp("bro");
		//String URL = futil.getDataFromProp("url");
		
		
		
		
		String orgname = ex.getDataFromExcel("Sheet1", 1, 0) + (int) (Math.random() * 10000);
		
	    
		String industry = ex.getDataFromExcel("Sheet1", 1, 1); 
		
		
		
		
		
		
		
		
		//Opening browser
		/*
		 * WebDriver driver; if(Browser.equalsIgnoreCase("chrome")) { driver = new
		 * ChromeDriver(); } else if(Browser.equalsIgnoreCase("edge")) { driver = new
		 * EdgeDriver(); } else if(Browser.equalsIgnoreCase("firefox")) { driver = new
		 * FirefoxDriver(); } else if(Browser.equalsIgnoreCase("safari")) { driver = new
		 * SafariDriver(); } else { driver = new ChromeDriver(); }
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 * 
		 * driver.get(URL);
		 * 
		 * LoginPage lp = new LoginPage(driver);
		 * 
		 * lp.login();
		 */		
		HomePage hp= new HomePage(driver);
	    hp.getOrganisation().click();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.getPlus().click();
		op.getOrganisationTextfield().sendKeys(orgname);
		WebElement industryUI = op.getIndustryTextfield();
		Select sel= new Select(industryUI);
		
		sel.selectByValue(industry);
		
		
		op.getSave().click();
		
		//Integration
		Thread.sleep(3000);
		 driver.findElement(By.linkText("Organizations")).click();
		    
		    driver.findElement(By.name("search_text")).sendKeys(orgname);
		    
		    WebElement searchIn = driver.findElement(By.name("search_field"));
		    
		    Select sel2=new Select(searchIn);
		    sel2.selectByVisibleText("Organization Name");
		    
		    driver.findElement(By.xpath("//input[@name='submit']")).click();
		    
		    
		    
		    driver.findElement(By.linkText(orgname)).click();
		    
		    String orgnameUI = driver.findElement(By.id("dtlview_Organization Name")).getText();
		    String industryui = driver.findElement(By.id("dtlview_Industry")).getText();
		    
		    
		    if(orgnameUI.equals(orgname) && industryui.equals(industry))
		    {
		    	System.out.println("Organization name, Industry name verified successfully");
		    }
		    
			/*
			 * hp.logOut(); driver.quit();
			 */
		    
	}

}
