package testNGPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.altius.crm.ExcelUtility.ExcelUtility;

public class amzonPriceList {
	
	public  static void main(String []args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String[] a={"samsung","vivo"};
	
		for(int i=0;i<a.length;i++)
		{
			
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(""+a[i]+""+Keys.ENTER);
		try {
		String price=driver.findElement(By.xpath("//span[text()='"+a[i]+"']/../../../../descendant::span[@class='a-price-whole']")).getText();
		
		System.out.println(price);
		}catch(Exception e)
		{
			System.out.println("Price not available");
		}
		driver.navigate().back();
	}
	}
}

	