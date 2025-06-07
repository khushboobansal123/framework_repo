package Practicescripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleClassToCheckProjectInBackend {
	
	@Test
	public void toCheckProject() throws SQLException
	{
		String expectedprojname = "Apple Iphone_13";
		Boolean flag = false;
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//System.out.println("===");
		
	    Statement stat = connect.createStatement();
	    
	    ResultSet result = stat.executeQuery("Select * from project");
	    
	    while(result.next())
	    {
	    	String actresult = result.getString(2);
	    	if(actresult.equals(expectedprojname))
	    	{
	    		System.out.println(expectedprojname+" is available and test is pass");
	    		flag=true;
	    	}
	    	
	    	
	    }
	    
	    if(flag==false)
	    {
	    	System.out.println(expectedprojname+" is not available and test is fail");
	    	Assert.fail();
	    	
	    }
	    
	    
	    connect.close();
	}

}
