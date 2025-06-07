package com.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitForElementtoLoad(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchNewBrowserTabByURL(WebDriver driver, String partialURL)
	{
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			String actURL = driver.getCurrentUrl();
			if(actURL.contains(partialURL))
				break;
		}
	}
	
	public void switchNewBrowserTabByTitle(WebDriver driver, String partialTitle)
	{
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle))
				break;
		}
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * @author Khushboo
	 * This method is used to switch to alert popup and accept it
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * @author Khushboo
	 * This method is used to switch to alert popup and dismiss it
	 * @param driver
	 */
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	
	/**
	 * @author Khushboo
	 * This method is used to select an option based on index in a select dropdown
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * @author Khushboo
	 * This method is used to select an option based on the attribute value in a select dropdown
	 * @param element
	 * @param value
	 */
	
	public void select(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * @author Khushboo
	 * This method is used to select a value based on visible text of an option in a select dropdown
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	
	
	
	

}
