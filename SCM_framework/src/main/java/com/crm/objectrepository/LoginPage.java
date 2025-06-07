package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	
	private WebElement userEdit;
	
	public WebElement getUserEdit()
	{
		return userEdit;
	}
	
	@FindBy(name = "user_password")
	
	private WebElement passEdit;
	
	public WebElement getPassEdit()
	{
		return passEdit;
	}
	
	@FindBy(id="submitButton")
	
	private WebElement loginBtn;
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	
	public void login()
	{
	
		getUserEdit().sendKeys("admin");
		getPassEdit().sendKeys("admin");
		getLoginBtn().click();
	}
	
	
}
