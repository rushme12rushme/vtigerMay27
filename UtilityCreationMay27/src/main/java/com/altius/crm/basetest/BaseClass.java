package com.altius.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.altius.crm.ExcelUtility.ExcelUtility;
import com.altius.crm.WebDriverUtility.JavaUtility;
import com.altius.crm.WebDriverUtility.UtilityClassObject;
import com.altius.crm.WebDriverUtility.WebDriverUtility;
import com.altius.crm.generic.databaseutility.DataBaseUtility;
import com.altius.crm.generic.fileutility.FileUtility;
import com.altius.crm.objectrepositoryutility.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Baseclass containing all reusable methods like open browser,Login
 * logout and Close Browser
 */
public class BaseClass {
	public  WebDriver driver=null;
	public static WebDriver edriver=null;
	public DataBaseUtility dbutil = new DataBaseUtility();
	public FileUtility flutil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public ExcelUtility excelutil = new ExcelUtility();
	public WebDriverUtility webutil = new WebDriverUtility();

	@BeforeSuite(groups= {"smoketest","regressiontest"})
	public void createDBconn() throws SQLException{
		System.out.println("====DB Connection");
		dbutil.getConnection();
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smoketest", "regressiontest" })
	public void openBrowser() throws IOException {
		System.out.println("==Open Browser==");
		
		//String browser = flutil.getDataFromPropertyFile("browser");
		String browser=System.getProperty("browser",flutil.getDataFromPropertyFile("browser"));
		// String browser=BROWSER;
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		edriver=driver;
		UtilityClassObject.setdriver(driver);

	}

	@BeforeMethod(groups = { "smoketest", "regressiontest" })
	public void login() throws IOException {
		System.out.println("---Login---");
		LoginPage lp = new LoginPage(driver);
		String url = System.getProperty("url",flutil.getDataFromPropertyFile("url"));

		String username = System.getProperty("username",flutil.getDataFromPropertyFile("username"));
		String password = System.getProperty("password",flutil.getDataFromPropertyFile("password"));
		lp.loginToApp(url, username, password);

	}

	@AfterMethod(groups = { "smoketest", "regressiontest" })
	public void logout() {
		System.out.println("---Logout---");
		HomePage hp = new HomePage(driver);
		hp.signout();

	}

	@AfterClass(groups = { "smoketest", "regressiontest" })
	public void closeBrowser() {
		System.out.println("---Close browser--");
		driver.quit();
	}

	@AfterSuite(groups = { "smoketest", "regressiontest" })
	public void closeDbConnection() throws SQLException {
		System.out.println("close db conn");
		dbutil.closeDbConnection();
		
	}

}
