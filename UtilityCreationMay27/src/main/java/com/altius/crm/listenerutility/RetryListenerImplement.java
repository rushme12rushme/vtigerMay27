package com.altius.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryListenerImplement implements IRetryAnalyzer{
int limit=5;
int retrycount=0;
	@Override
	public boolean retry(ITestResult result) {
		while(retrycount<limit) {
			retrycount++;
			return true;
			
		}
	return false;
	}

	
}
