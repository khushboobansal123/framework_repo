package com.crm.generic.BaseClassUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;
import com.scm.generic.fileutility.FileUtility;

public class BaseClass {
	FileUtility futil = new FileUtility();
	public WebDriver driver=null;
	
	
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void bSuite()
	{
		Reporter.log("DB connection, report configuration",true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void bClass() throws Throwable
	{
		
		//String Browser = futil.getDataFromProp("bro");
		String Browser=System.getProperty("bro", futil.getDataFromProp("bro"));
		
		//String Browser=browser;
		//String URL = futil.getDataFromProp("url");
		String URL=System.getProperty("url", futil.getDataFromProp("url"));
		
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
		
		UtilityClassObject.setDriver(driver);
		
		Reporter.log("Launch the Browser",true);
		
		
		
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          driver.get(URL);
		
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void bMethod()
	{  
		LoginPage lp = new LoginPage(driver);
	
	     lp.login();
	     Reporter.log("login",true);
	
		
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void aMethod()
	{
		
		HomePage hp= new HomePage(driver);
		hp.logOut();
		Reporter.log("logout",true);
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void aClass()
	{    
		driver.quit();
		Reporter.log("Close the browser",true);		
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void aSuite()
	{
		Reporter.log("Database close, report backup",true);
		
	}
	

}
