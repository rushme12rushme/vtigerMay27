package com.altius.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

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

import com.altius.crm.ExcelUtility.ExcelUtility;
import com.altius.crm.WebDriverUtility.JavaUtility;
import com.altius.crm.WebDriverUtility.WebDriverUtility;
import com.altius.crm.generic.fileutility.FileUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//fetch org name from excel
		ExcelUtility ex=new ExcelUtility();
		String exceldataorg=ex.getDataFromExcelFile("contact", 7, 3);
		JavaUtility jlib=new JavaUtility();
		
		String orgname=exceldataorg+jlib.getRandomeNumber();;

		driver.findElement(By.name("accountname")).sendKeys(orgname);

		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();



		String tableorgname= driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(tableorgname.equals(orgname))
			System.out.println(orgname + " orgname  is created successfully");





		//navigate to contacts tab
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//fetch contact name from excel
		String exceldatacontact=ex.getDataFromExcelFile("contact", 7, 2);
		String lastname=exceldatacontact+jlib.getRandomeNumber();



		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//enter org name
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToTabWithUrl(driver, "module=Account");
		
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgname)).click();
		
		//switch back to parent window
		wlib.switchToTabWithUrl(driver, "Contacts&action");
					
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		String tablelastname= driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(tablelastname.contains(lastname))
			System.out.println(lastname + " contact is created successfully");
		//verify Orgname in Contact details page
		String tableOrg=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		if((tableOrg.trim()).equals(orgname))
		{
			System.out.println("Org name in contact details page is verified PASS");
		}
		else
			System.out.println("Org name in contact details page is NOT verified FAIL");


//signout

		Actions a =new Actions(driver);
		WebElement signouticon = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(signouticon).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}


