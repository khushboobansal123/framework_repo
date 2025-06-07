package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	   Actions act;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			act=new Actions(driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText = "Organizations")
		
		private WebElement organisation;
		
		public WebElement getOrganisation()
		{
			return organisation;
		}
		
		@FindBy(linkText = "Contacts")
		
		private WebElement contact;
		
		public WebElement getContact()
		{
			return contact;
		}
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		
		private WebElement profile;
		
		public WebElement getProfile()
		{
			return profile;
		}
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOut;
		
		public WebElement getSignOut()
		{
			return signOut;
		}
		
		public void logOut()
		{
			act.moveToElement(getProfile()).build().perform();
			act.click(getSignOut()).build().perform();
		}
		
		
		

}
