package com.altius.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PomLoginImplement {
@Test
	public void login() {
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/");

LoginPage l=new LoginPage();
PageFactory.initElements(driver, l);
l.usernamebox.sendKeys("dmin");
l.pwdbox.sendKeys("manager");
l.loginbtn.click();
driver.navigate().refresh();
l.usernamebox.sendKeys("admin");
l.pwdbox.sendKeys("manager");
l.loginbtn.click();
	}

}
