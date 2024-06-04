package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement orgSearchbox;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchdropdown;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchbtn;
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
	public void searchOrg(String orgname)
	{
		orgSearchbox.sendKeys(orgname);
		Select s=new Select(searchdropdown);
		s.selectByVisibleText("Organization Name");
		searchbtn.click();
	}

	
	

}
