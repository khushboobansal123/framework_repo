package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plus;
	
	public WebElement getPlus()
	{
		return plus;
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTextfield;
	
	public WebElement getLastnameTextfield()
	{
		return lastnameTextfield;
	}
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement plusOrganisation;
	
	public WebElement getPlusOgranisation()
	{
		return plusOrganisation;
	}
	
	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement save;
	
	public WebElement getSave()
	{
		return save;
	}
	

}
