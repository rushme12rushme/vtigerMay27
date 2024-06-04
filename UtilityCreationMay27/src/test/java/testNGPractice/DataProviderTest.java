package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {
	@Test(dataProvider="DataProviderMethod")
	public void createContactDP(String fname,String lname)
	{
		System.out.println(fname+lname);
	}
	
	@DataProvider
	public Object[][] DataProviderMethod()
	{
		Object [][] dataobj=new Object[3][2];
		dataobj[0][0]="fname1";
		dataobj[0][1]="lname1";
		dataobj[1][0]="fname2";
		dataobj[1][1]="lname2";
		dataobj[2][0]="fname3";
		dataobj[2][1]="lnmae3";
		return dataobj;
		
	}
}
