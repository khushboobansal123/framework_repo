package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
WebDriver driver;
	
	public OrganisationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plus;
	
	public WebElement getPlus()
	{
		return plus;
	}
	
	@FindBy(name="accountname")
	private WebElement organisationTextfield;
	
	public WebElement getOrganisationTextfield()
	{
		return organisationTextfield;
	}
	
	@FindBy(name="industry")
	private WebElement industryTextfield;
	
	public WebElement getIndustryTextfield()
	{
		return industryTextfield;
	}
	
	@FindBy(id="phone")
	private WebElement phoneTextfield;
	
	public WebElement getPhoneTextfield()
	{
		return phoneTextfield;
	}
	
	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement save;
	
	public WebElement getSave()
	{
		return save;
	}
	
	

}
