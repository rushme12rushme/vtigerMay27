package com.altius.crm.OrgTest;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.altius.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.altius.crm.objectrepositoryutility.HomePage;
import com.altius.crm.objectrepositoryutility.OrganizationInfoPage;
import com.altius.crm.objectrepositoryutility.OrganizationsPage;
import com.altius.crm.basetest.BaseClass;
public class CreateOrganizationPomTest extends BaseClass {
	@Test(groups="smoketest")
	public  void createOrgTest() throws IOException, InterruptedException {

		//navigate to Organizations page
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		//click on newOrg button
		OrganizationsPage orgp=new OrganizationsPage(driver);
		orgp.getCreateOrgBtn().click();
		//fetch org name from excel
		//user excelutility class
		String excelorg=excelutil.getDataFromExcelFile("org", 1, 2);
		String orgname=excelorg+jutil.getRandomeNumber();
		//create org using POM class
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgname);
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(orgname))
		{

			excelutil.setDatainExcelFile("org", 4, 7, "PASS");

		}
		else
		{
			excelutil.setDatainExcelFile("org", 4, 7, "FAIL");
		}
		String tableorgname= driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(tableorgname.equals(orgname)) {
			System.out.println(orgname + "  is created successfully");
			System.out.println("CreateOrgTest PASSED");
		}
		}

	@Test(groups="regressiontest")
	public void CreateOrgWithTypeTest() throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();

		//fetch org name from excel
		//user excelutility class
		String excelorg=excelutil.getDataFromExcelFile("org", 1, 2);

		String orgname=excelorg+jutil.getRandomeNumber();

		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		String excelindustry=excelutil.getDataFromExcelFile("org", 4, 3);
		String excelindustrytype=excelutil.getDataFromExcelFile("org", 4, 4);

		cop.createOrg(orgname, excelindustry, excelindustrytype);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String header=oip.getHeaderMsg().getText();

		if(header.contains(orgname))
		{

			excelutil.setDatainExcelFile("org", 1, 7, "PASS");
		}
		else
		{
			excelutil.setDatainExcelFile("org", 1, 7, "FAIL");		}
		String tableorgname= driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(tableorgname.equals(orgname)) {
			System.out.println(orgname + " org is created successfully");
		System.out.println("CreateOrgTestWithType PASSED");
		}
		else
			System.out.println(orgname + " org creation failed");

	}
@Test(groups="regressiontest")
	public void createOrgWithPhoneTest () throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();

		//fetch org name from excel
		//user excelutility class
		String excelorg=excelutil.getDataFromExcelFile("org", 7, 2);

		String orgname=excelorg+jutil.getRandomeNumber();


		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		String phone=excelutil.getDataFromExcelFile("org", 7, 3);
		cop.createOrg(orgname,phone);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		//String header=oip.getHeaderMsg().getText();

			
		String tableorgname= driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(tableorgname.equals(orgname))
		{
			System.out.println(orgname + " org is created successfully with phone number "+phone);
			System.out.println("CreateOrg with Ohone Number PASSED");
		}
			else
			System.out.println(orgname + " org creation failed");

		String act_phone=driver.findElement(By.id("dtlview_Phone")).getText();
		if(act_phone.equals(phone))
		{
			System.out.println("Phone number is verified PASS");
			
		}
		else
			System.out.println("Phone number is NOT verified FAIL");

	}
}






