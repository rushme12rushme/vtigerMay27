package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement accntNametbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(name="industry")
	private WebElement industrydropdwn;
	
	@FindBy(name="accounttype")
	private WebElement typedropdwn;
	
	@FindBy(id="phone")
	private WebElement phonetbx;
	
	public WebElement getphonetbx() {
		return phonetbx;
	}
	
	public WebElement getTypedropdwn() {
		return typedropdwn;
	}

	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getAccntNametbx() {
		return accntNametbx;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createOrg(String orgname)
	{
		accntNametbx.sendKeys(orgname);
		savebtn.click();
	}
	public void createOrg(String orgname,String phone)
	{
		accntNametbx.sendKeys(orgname);
		phonetbx.sendKeys(phone);
		savebtn.click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndustrydropdwn() {
		return industrydropdwn;
	}

	public void createOrg(String orgname,String industry,String type)
	{
		accntNametbx.sendKeys(orgname);
		
		Select sind =new Select(industrydropdwn);
		sind.selectByValue(industry);
		
		
		Select stype=new Select(typedropdwn);
		stype.selectByValue(type);
		
		savebtn.click();
	}
	
}
