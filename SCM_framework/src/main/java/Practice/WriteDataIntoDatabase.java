package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//System.out.println("===");
		
	    Statement stat = connect.createStatement();
	    
	    int result = stat.executeUpdate("insert into project values('52','Apple Iphone_12','20','2025-05-16');");
	    System.out.println(result);
	    
	    
	    
	    connect.close();

	}

}
