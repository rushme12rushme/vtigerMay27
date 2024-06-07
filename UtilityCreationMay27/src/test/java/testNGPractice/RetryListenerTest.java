package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.altius.crm.listenerutility.RetryListenerImplement;

public class RetryListenerTest {
//@Test(retryAnalyzer=RetryListenerImplement.class)
	public void retryMethod()
	{
		System.out.println("retry method");
		Assert.fail();
	}
}
