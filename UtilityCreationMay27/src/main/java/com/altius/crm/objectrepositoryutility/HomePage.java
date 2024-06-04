package com.altius.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(partialLinkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getOrgLink() {
		return orgLink;
	}

public WebElement getContactLink()
{
	return contactLink;
}
	public void navigateToCampaignsPage()
	{
		Actions a =new Actions(driver);
		a.moveToElement(moreLink).perform();
		a.click(CampaignsLink).perform();
	}
	public void signout()
	{
		Actions a=new Actions(driver);
		a.moveToElement(signoutIcon).perform();
		signoutLink.click();
		
	}
	
}
