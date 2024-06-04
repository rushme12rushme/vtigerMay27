package com.altius.crm.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToTabWithUrl(WebDriver driver ,String partialUrl)
	{
			Set<String> allwhs=driver.getWindowHandles();
	for(String wh:allwhs)
	{
	 driver.switchTo().window(wh);
	 String acturl=driver.getCurrentUrl();
	 if(acturl.contains(partialUrl))
	 {
		 break;
	 }
	 
	}
	}
	public void switchToTabOnTitle(WebDriver driver,String partialtitle)
	{
		Set<String> allwhs=driver.getWindowHandles();
		Iterator<String> i=allwhs.iterator();
		while(i.hasNext())
		{
			driver.switchTo().window(i.next());
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialtitle))
			{
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver,int id)
	{
		driver.switchTo().frame(id);
	}
	public void switchToFrame(WebDriver driver,String text)
	{
		driver.switchTo().frame(text);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element,Object option)
	{
		Select s = new Select(element);
		if(option instanceof String)
		{
			s.selectByVisibleText((String)option);
		}
		if(option instanceof Integer)
			s.selectByIndex((int) option);
	}
	}

