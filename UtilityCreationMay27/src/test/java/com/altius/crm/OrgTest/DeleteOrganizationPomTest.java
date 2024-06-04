package com.altius.crm.OrgTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.altius.crm.ExcelUtility.ExcelUtility;
import com.altius.crm.WebDriverUtility.JavaUtility;
import com.altius.crm.generic.fileutility.FileUtility;
import com.altius.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.altius.crm.objectrepositoryutility.HomePage;
import com.altius.crm.objectrepositoryutility.LoginPage;
import com.altius.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrganizationPomTest {
	
@Test
	public  void deleteOrg() throws IOException, InterruptedException {
		//read from property file
		FileUtility fil=new FileUtility();
		String browser=fil.getDataFromPropertyFile("browser");

		String url=fil.getDataFromPropertyFile("url");
		String username=fil.getDataFromPropertyFile("username");
		String password=fil.getDataFromPropertyFile("password");


		WebDriver driver=null;


		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}


		
		//login using POM class
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url,username, password);
		//navigate to Organizations page
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		//click on newOrg button
		OrganizationsPage orgp=new OrganizationsPage(driver);
		orgp.getCreateOrgBtn().click();

		//fetch org name from excel
		//user excelutility class
		ExcelUtility ex=new ExcelUtility();
		String excelorg=ex.getDataFromExcelFile("org", 1, 2);
		JavaUtility jlib=new JavaUtility();
		String orgname=excelorg+jlib.getRandomeNumber();

		//create org using POM class
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgname);




		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if(header.contains(orgname))
		{

			ex.setDatainExcelFile("org", 4, 7, "PASS");

		}
		else
		{
			ex.setDatainExcelFile("org", 4, 7, "FAIL");
		}
		String tableorgname= driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(tableorgname.equals(orgname))
			System.out.println(orgname + "  is created successfully");

		hp.getOrgLink().click();
		orgp.searchOrg(orgname);
		driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]/../../td[8]/a[text()='del']")).click();
		driver.switchTo().alert().accept();
		//signout
		hp.signout();
	}

}


