package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	@FindBy(name="lastname")
	private WebElement lastnametbx;
	@FindBy(name="support_start_date")
	private WebElement startdatetbx;
	@FindBy(name="support_end_date")
	private WebElement enddatetbx;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savectbtn;
	@FindBy(name="account_name")
	private WebElement orgnametbx;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrg;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastnametbx() {
		return lastnametbx;
	}
	public WebElement getStartdatetbx() {
		return startdatetbx;
	}
	public WebElement getEnddatetbx() {
		return enddatetbx;
	}
	public WebElement getSavectbtn() {
		return savectbtn;
	}
	public WebElement getOrgnametbx() {
		return orgnametbx;
	}
	public WebElement getSelectOrg() {
		return selectOrg;
	}
public void createContact(String lastname)
{
	getLastnametbx().sendKeys(lastname);
	getSavectbtn().click();
}
public void createContact(String lastname,String sdate,String edate)
{
	
	getLastnametbx().sendKeys(lastname);
	startdatetbx.clear();
	startdatetbx.sendKeys(sdate);
	enddatetbx.clear();
	enddatetbx.sendKeys(edate);
	getSavectbtn().click();
}
public void createContact(String lastname,String orgname)
{
	
	getLastnametbx().sendKeys(lastname);
	getOrgnametbx().sendKeys(orgname);
	getSavectbtn().click();
}
}
