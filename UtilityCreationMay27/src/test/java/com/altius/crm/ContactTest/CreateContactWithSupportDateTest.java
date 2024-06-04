
package com.altius.crm.ContactTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

import com.altius.crm.ExcelUtility.ExcelUtility;
import com.altius.crm.WebDriverUtility.JavaUtility;
import com.altius.crm.generic.fileutility.FileUtility;

public class CreateContactWithSupportDateTest {

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//fetch contact name from excel
		//user excelutility class
				ExcelUtility ex=new ExcelUtility();
				String excellastname=ex.getDataFromExcelFile("contact", 4, 2);
				//getrandomw number
				JavaUtility jlib=new JavaUtility();
						
				String lastname=excellastname+jlib.getRandomeNumber();;




		driver.findElement(By.name("lastname")).sendKeys(lastname);

		driver.findElement(By.name("support_start_date")).clear();

		driver.findElement(By.name("support_start_date")).sendKeys("2024-05-30");
		//enter todays date as start date 
		String sdate=jlib.getSystemDateYYYYDDMM();
		String enddate=jlib.getRequiredDateYYYYDDMM(30);
		driver.findElement(By.name("support_start_date")).clear();

		driver.findElement(By.name("support_start_date")).sendKeys(sdate);
		driver.findElement(By.name("support_end_date")).clear();

		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		System.out.println(sdate);
		System.out.println(enddate);



		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();



		if(header.contains(lastname))
		{

			ex.setDatainExcelFile("contact", 4, 7, "PASS");

		}
		else
		{
			ex.setDatainExcelFile("contact", 4, 7, "FAIL");

		}
		String tablelastname= driver.findElement(By.id("mouseArea_Last Name")).getText();
		if((tablelastname.trim()).equals(lastname))
			System.out.println(lastname + "  is created successfully");
		Actions a =new Actions(driver);
		WebElement signouticon = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(signouticon).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}


}


