package com.altius.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.altius.crm.WebDriverUtility.UtilityClassObject;
import com.altius.crm.basetest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation extends BaseClass implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String extn = new Date().toString().replace(":","_").replace(" ","");
		spark=new ExtentSparkReporter("./ExtentReport/sampleExtentReport_"+extn+".html");
		spark.config().setDocumentTitle("CreateContactTestReport");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add environment details and and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows10");
		report.setSystemInfo("Browser","Chrome");
	
			
	
				
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		TakesScreenshot ts=(TakesScreenshot)BaseClass.edriver;
		 String src = ts.getScreenshotAs(OutputType.BASE64);
		
		String date = new Date().toString();

		String fileextn = date.replace(" ", "").replace(":", "_");
	
		test.addScreenCaptureFromBase64String(src,result.getMethod().getMethodName()+"_"+fileextn);
		test.log(Status.INFO,"TestCase" +result.getMethod().getMethodName() +"Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
	UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+" Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,result.getMethod().getMethodName()+"Test Success");

	}

}
