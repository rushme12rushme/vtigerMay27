package com.altius.crm.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.altius.crm.ExcelUtility.ExcelUtility;

public class AmazonDPTest {
	@Test(dataProvider="amazonData")
	public void amazonDP(String brand,String product)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(""+brand+""+Keys.ENTER);
		try {
		String price=driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]/../../../../div[3]/div[1]/div/div/div/div/a/span/span[2]/span[2]")).getText();
		System.out.println(price);
		}catch(Exception e)
		{
			System.out.println("Price not available");
		}
	}

	@DataProvider
	public Object[][] amazonData() throws EncryptedDocumentException, IOException
	{
		Object[][]result=new Object[4][2];
		ExcelUtility exl=new ExcelUtility();
		int rowcount=exl.getRowCount("amazon");
		for(int i=0;i<rowcount;i++)
		{
			result[i][0]=exl.getDataFromExcelFile("amazon", i+1,0 );
			result[i][1]=exl.getDataFromExcelFile("amazon", i+1,1 );

		
		}
		
		return result;
	}
}
