package com.altius.crm.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;


public class LoginPage {
	
	
	  @FindBy(xpath="//input[@name='user_name']") 
	  WebElement usernamebox;
	 
	
	


@FindBy(xpath="//input[@name='user_password']")
 WebElement pwdbox;

	/*
	 * @FindAll({@FindBy(id="submitButton"),@FindBy(
	 * xpath="//inpt[@value='Login' and @type='submit']")}) WebElement loginbtn;
	 */
	/*
	 * @FindBy(id="submitButton") WebElement loginbtn;
	 */
@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login' and @type='submit']")})
 WebElement loginbtn;

}
