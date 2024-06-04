package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	@FindBy(className="dvHeaderText")
	private WebElement headertxt;
	@FindBy(id="mouseArea_Last Name")
	private WebElement tablelastnametxt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement tableorgnametxt;
	
	public WebElement getTableOrgnametxt() {
		return tableorgnametxt;
	}
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTablelastnametxt() {
		return tablelastnametxt;
	}

	public ContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeadertxt() {
		return headertxt;
	}

	
}
