package extentReports;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest {
	@Test
	public void createExtentReportTest() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/sampleExtentReport.html");
	spark.config().setDocumentTitle("CreateContactTestReport");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);
	//add environment details and and create test
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Windows10");
	report.setSystemInfo("Browser","Chrome");
	ExtentTest test = report.createTest("CreateContactTest");
	test.log(Status.INFO, "Running test CreateContactTest");
	 if("HDFC".equals("HDFF"))
	{
		test.log(Status.PASS,"Strings matching ");
	}
	else
		test.log(Status.FAIL, "Strings not matching");
	
	test.log(Status.INFO, "Test Case end");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
	TakesScreenshot ts=(TakesScreenshot)driver;
	 String src = ts.getScreenshotAs(OutputType.BASE64);
	test.addScreenCaptureFromBase64String(src, "google screenshot");
	report.flush();
	
}
}
