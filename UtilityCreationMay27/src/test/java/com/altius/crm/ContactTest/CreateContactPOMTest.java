package com.altius.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.altius.crm.ExcelUtility.ExcelUtility;
import com.altius.crm.WebDriverUtility.JavaUtility;
import com.altius.crm.WebDriverUtility.UtilityClassObject;
import com.altius.crm.basetest.BaseClass;
import com.altius.crm.generic.fileutility.FileUtility;
import com.altius.crm.objectrepositoryutility.ContactInfoPage;
import com.altius.crm.objectrepositoryutility.ContactsPage;
import com.altius.crm.objectrepositoryutility.CreatingNewContactPage;
import com.altius.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.altius.crm.objectrepositoryutility.HomePage;
import com.altius.crm.objectrepositoryutility.OrganizationsPage;
import com.aventstack.extentreports.Status;
@Listeners(com.altius.crm.listenerutility.ListenerImplementation.class)
public class CreateContactPOMTest extends BaseClass{
	@Test(groups="smoketest")
	public void createContactTest()  throws IOException  {
		UtilityClassObject.getTest().log(Status.PASS, "go to contacts tab");

		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactbtn().click();
		//fetch contact name from excel
		//user excelutility class
		UtilityClassObject.getTest().log(Status.PASS, "fetch data from excel");

		String exceldata=excelutil.getDataFromExcelFile("contact", 1, 2);
		int randmnum = jutil.getRandomeNumber();
		String lastname=exceldata+randmnum;
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createContact(lastname);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String header=cip.getHeadertxt().getText();
		boolean headerchk=header.contains(lastname);
		Assert.assertTrue(headerchk);
		UtilityClassObject.getTest().log(Status.PASS, "Contact created");
		if(header.contains(lastname))
		{

			excelutil.setDatainExcelFile("contact", 1, 7, "PASS");
		}
		else
		{

			excelutil.setDatainExcelFile("contact", 1, 7, "FAIL");
		}
		String tablelastname= driver.findElement(By.id("mouseArea_Last Name")).getText();
		boolean res=tablelastname.contains(lastname);
		System.out.println(res+"actual table name and lastname");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(res, true);
		UtilityClassObject.getTest().log(Status.PASS, "contact created");

		sa.assertAll();
		
	}

	@Test(groups="regressiontest")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException
	{

		UtilityClassObject.getTest().log(Status.PASS, "CreateContactWith SupportDate started");

		String excellastname=excelutil.getDataFromExcelFile("contact", 4, 2);
		String lastname=excellastname+jutil.getRandomeNumber();;
		String sdate=jutil.getSystemDateYYYYDDMM();
		String edate=jutil.getRequiredDateYYYYDDMM(30);
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactbtn().click();

		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);

		cnp.createContact(lastname,sdate,edate);
		System.out.println(sdate);
		System.out.println(edate);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String header=cip.getHeadertxt().getText();


		if(header.contains(lastname))
		{

			excelutil.setDatainExcelFile("contact", 4, 7, "PASS");

		}
		else
		{
			excelutil.setDatainExcelFile("contact", 4, 7, "FAIL");

		}
		String tablelastname= driver.findElement(By.id("mouseArea_Last Name")).getText();
		if((tablelastname.trim()).equals(lastname))
		{
			System.out.println(lastname + "  is created successfully");
		System.out.println("createContactWithSupportDateTest PASSED");
		}
	}



@Test(groups="regressiontest")
public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
{

	UtilityClassObject.getTest().log(Status.PASS, "CreateContactWith org started");
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			//click on newOrg button
			OrganizationsPage orgp=new OrganizationsPage(driver);
			orgp.getCreateOrgBtn().click();
			//fetch org name from excel
			//user excelutility class
			String excelorg=excelutil.getDataFromExcelFile("contact", 7, 3);
			String orgname=excelorg+jutil.getRandomeNumber();
			//create org using POM class
			CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
			cop.createOrg(orgname);
			
			
			
	String excellastname=excelutil.getDataFromExcelFile("contact", 7, 2);
	String lastname=excellastname+jutil.getRandomeNumber();

	
	hp.getContactLink().click();
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateContactbtn().click();

	CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
	cnp.getSelectOrg().click();
	webutil.switchToTabWithUrl(driver, "module=Accounts");
	driver.findElement(By.id("search_txt")).sendKeys(orgname);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText(orgname)).click();
	webutil.switchToTabWithUrl(driver, "module=Contacts");
	

	
	cnp.createContact(lastname,orgname);
	ContactInfoPage cip=new ContactInfoPage(driver);
	String contactheader=cip.getHeadertxt().getText();
	String tableorgname= cip.getTableOrgnametxt().getText();


	if(contactheader.contains(lastname))
	{

		excelutil.setDatainExcelFile("contact", 4, 7, "PASS");

	}
	else
	{
		excelutil.setDatainExcelFile("contact", 4, 7, "FAIL");

	}
	String tablelastname=cip.getTablelastnametxt().getText();
	if((tablelastname.trim()).equals(lastname) && (tableorgname.equals(orgname)))
	{
		System.out.println(lastname + "  is created successfully with org "+orgname);
		System.out.println("createContactWithOrgTest PASSED");
	}
}


}



