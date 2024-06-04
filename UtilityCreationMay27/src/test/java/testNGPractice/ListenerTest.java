package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.altius.crm.basetest.BaseClass;
@Listeners(com.altius.crm.listenerutility.ListenerImplementation.class)


public class ListenerTest extends BaseClass {
@Test
public void testMethodWithListenerImp1()
{
	//check for title
	String title=driver.getTitle();
	String exptitle="vtigerHomePage";
	Assert.assertEquals(title, exptitle);
	
}
@Test
public void testMethodWithListenerImp2()
{
	
	//check for title
		String title1=driver.getTitle();
		String exptitle1="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(title1, exptitle1);
}
}
