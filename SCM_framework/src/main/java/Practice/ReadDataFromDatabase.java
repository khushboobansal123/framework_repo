package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connect = null;
		try {
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//System.out.println("===");
		
	    Statement stat = connect.createStatement();
	    
	    ResultSet result = stat.executeQuery("Select * from project45");
	    
	    while(result.next())
	    {
	    	System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3)+"\t"+result.getString(4));
	    }
	    
		}catch(Exception e)
		{
			System.out.println("Exception is caught");
		}finally {
	    
	    connect.close();
	    System.out.println("===");
		}

	}

}
