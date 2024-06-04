package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactbtn;

	@FindBy(name="search_text")
	private WebElement searchtbx;
	
	@FindBy(id="bas_searchfield")
	private WebElement contactSearchdd;
	
	@FindBy(xpath="//input[@value=' Search Now ' and @onclick=\"callSearch('Basic');\"]")
	private WebElement searchbtn;
		
	public WebElement getContactSearchdd() {
		return contactSearchdd;
	}
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateContactbtn() {
		return createContactbtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSearchtbx() {
		return searchtbx;
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	

}
