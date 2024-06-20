package com.altius.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.altius.crm.WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	@FindBy (name="user_name")
	private WebElement usernametbx;
	@FindBy(name="user_password")
	private WebElement passwordtbx;
	@FindBy (id="submitButton")
	private WebElement loginbtn;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String url,String username,String password)
	{
		waitForPageLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernametbx.sendKeys(username);
		passwordtbx.sendKeys(password);
		loginbtn.click();
	}


}
