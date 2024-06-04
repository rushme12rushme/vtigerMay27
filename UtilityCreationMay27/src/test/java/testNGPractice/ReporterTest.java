package testNGPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterTest {
	@Test
	public void repoterFeature()
	{
		Reporter.log("Log1",true);
		Reporter.log("Log2",false);
	}

}
