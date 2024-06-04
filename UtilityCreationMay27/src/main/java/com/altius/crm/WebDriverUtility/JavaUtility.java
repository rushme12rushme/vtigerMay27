package com.altius.crm.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomeNumber()
{
	Random r =new Random();
	return (r.nextInt(5000));
	
}
public String getSystemDateYYYYDDMM()
{
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String dt = sdf.format(date);
	return dt;
	
}
public String getRequiredDateYYYYDDMM(int days)
{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_WEEK, 30);
	Date ldate=cal.getTime();
	
	 String reqdate = sdf.format(ldate);
	return reqdate;
}
}
