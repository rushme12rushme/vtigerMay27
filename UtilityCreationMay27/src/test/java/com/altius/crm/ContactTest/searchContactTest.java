package com.altius.crm.ContactTest;

import org.testng.annotations.Test;

import com.altius.crm.WebDriverUtility.UtilityClassObject;
import com.altius.crm.WebDriverUtility.WebDriverUtility;
import com.altius.crm.basetest.BaseClass;
import com.altius.crm.objectrepositoryutility.ContactsPage;
import com.altius.crm.objectrepositoryutility.HomePage;
import com.aventstack.extentreports.Status;
/**
 * Author Rashmi
 * Search for a contact
 */
public class searchContactTest extends BaseClass {
	/**
	 *Login==>click on contacts==> Searchfor contact 
	 */
	
	@Test
	public void searchContact()
	{
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		/*
		 * Search for contact using lastname
		 */
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getSearchtbx().sendKeys("amazon");
		WebDriverUtility wutil=new WebDriverUtility();
		
		wutil.select(cp.getContactSearchdd(), "Last Name");
		UtilityClassObject.getTest().log(Status.INFO, "Contact Search with Lastname Amazon");

		cp.getSearchbtn().click();
	
	}

}
