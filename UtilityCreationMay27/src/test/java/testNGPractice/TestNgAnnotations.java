package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	@Test
	public void createContact()
	{
		
		System.out.println("Create contact test case");
		Assert.fail();
	}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("Modify contact test case");
	
	}
	@Test
	public void deleteContact()
	{
		System.out.println("delete contact test case");

	}
	
	

}
