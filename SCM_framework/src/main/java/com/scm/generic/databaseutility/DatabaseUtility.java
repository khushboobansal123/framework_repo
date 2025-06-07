package com.scm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class DatabaseUtility {
	
	Connection conn;
	
	public void getConnection(String url, String username, String password)
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void getConnection()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void closeDbconnection()
	{
		try {
			conn.close();
		}
		catch(Exception e)
		{
	}
	}
	
	public ResultSet executeSelectQuery(String query)
	{ ResultSet result=null;
		try {
			Statement stat=conn.createStatement();
			result=stat.executeQuery(query);
		}
		catch(Exception e)
		{
			
		}
		
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{ int result=0;
		try {
			Statement stat=conn.createStatement();
			result=stat.executeUpdate(query);
		}
		catch(Exception e)
		{
			
		}
		
		return result;
	}
	

}
