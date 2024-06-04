package com.altius.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;

	public void getConnection() throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}catch(Exception e)
		{
			
		}
		}
	public void getConnection(String url,String username,String password) throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(url,username,password);
		}catch(Exception e)
		{
			
		}
		}
	public void closeDbConnection() throws SQLException
	{
		try {
		conn.close();
		}catch (Exception e)
		{
			
		}
	}
	public ResultSet executeQuery(String query) throws SQLException
	{
		ResultSet result=null;
		try {
		Statement statement = conn.createStatement();
		 result = statement.executeQuery(query);
		
		}catch(Exception e)
		{
			
		}
		return result;
	}
	public int executeUpdate(String query) throws SQLException
	{
		int status=0;
		try {
		Statement statement = conn.createStatement();
		 status = statement.executeUpdate(query);
		
		}catch (Exception e)
		{
			
		}
		return status;
	}
}
