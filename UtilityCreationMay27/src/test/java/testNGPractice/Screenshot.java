package testNGPractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
@Test
public void takeScreenshotMethod() throws IOException
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://amazon.com");
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String date=new Date().toString();
	
	String fileextn=date.replace(" ","").replace(":","_");
	String filename="./Screenshot/amazonpage_"+fileextn+".png";
	System.out.println(filename);

	File dest = new File(filename);
	FileUtils.copyFile(src, dest);
	//takescreenshot of webelement
	
	/*
	 * WebElement btn=
	 * driver.findElement(By.xpath("//button[text()='Continue shopping']"));
	 * TakesScreenshot ts1=(TakesScreenshot) btn; File
	 * src1=ts1.getScreenshotAs(OutputType.FILE); File dest1 = new
	 * File("./Screenshot/btnelement.png"); FileUtils.copyFile(src1, dest1);
	 */
	
	
}
}
