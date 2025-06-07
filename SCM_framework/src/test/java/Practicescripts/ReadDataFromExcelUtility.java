package Practicescripts;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromExcelUtility {
	
	private static String url = "jdbc:mysql://localhost:3306/projects";
	private static String username = "root";
	private static String password="root";
	private static String excelpath="./src/test/resources/PlayersData.xlsx";
	private static String sheetname="Sheet1";
	
	public static void main(String[] args) throws Throwable
	{   Scanner sc=new Scanner(System.in);
		Connection connect=connecttoDB();
		createtable(connect);
		readDataFromExcelandwriteintodatabase(fetchdatafromexcel(sheetname,excelpath),connect);
		System.out.println("Enter the data you want to check and the column name");
		String expecteddata = sc.nextLine();
		String columnname= sc.nextLine();
		if(readdatafromdatabase(expecteddata,columnname,connect))
			System.out.println(expecteddata+" is available in the database");
		else
			System.out.println(expecteddata+" is not available in the database");
		
		
		
	}
	
	public static void createtable(Connection connect) throws Throwable
	{
		Statement stat = connect.createStatement();
		String createquery = "CREATE TABLE IF NOT EXISTS Player(Player_ID VARCHAR(50) PRIMARY KEY,Player_Name VARCHAR(100) NOT NULL,Matches_Played VARCHAR(50), Matches_Won VARCHAR(50),Ranking VARCHAR(50))"; 
		stat.executeUpdate(createquery);
		connect.close();
		
	}
			

	public static void readDataFromExcelandwriteintodatabase(List<List<String>> exceldata,Connection connect) throws Throwable
	{    Boolean flag=false;
		// TODO Auto-generated method stub
		for(int i=0; i<exceldata.size(); i++)
		{ List<String> li = exceldata.get(i);
		 
		try
		{
		 String query = "INSERT INTO Player VALUES('" +li.get(0)+ "','" +li.get(1)+ "','" +li.get(2)+ "','" +li.get(3)+ "','" +li.get(4)+ "')";
			connect.createStatement().executeUpdate(query);
			
		}catch(Exception e)
		{  flag=true;  
		}
		
		}
		
		if(flag)
		System.out.println("Data already exist in the table");
		else 
			System.out.println("Data inserted successfully");
		
		connect.close();		
	}
	
	public static Connection connecttoDB() throws Throwable
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connect = DriverManager.getConnection(url, username, password);
		return connect;
		
	}
	
	public static List<List<String>> fetchdatafromexcel(String sheetname, String excelpath) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		List<List<String>> exceldata = new ArrayList<>();
		for(int i=1; i<=sh.getLastRowNum(); i++)
		{
			Row row = sh.getRow(i);
			List<String> rowdata = new ArrayList<>();
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				Cell cell = row.getCell(j);
				if(cell==null)
				{rowdata.add("");
			}
				else {
					rowdata.add(cell.toString().trim());
				}
		}
			exceldata.add(rowdata);
		
		
	}
		return exceldata;

}
	
	public static boolean readdatafromdatabase(String expecteddata,String columnname, Connection connect) throws Throwable
	{
		String query = "Select * from Player";
		ResultSet result=connect.createStatement().executeQuery(query);
		while(result.next())
		{
			String actualresult = result.getString(columnname);
			if(actualresult.equals(expecteddata))
				{ connect.close();
				return true;}
		}
		
		connect.close();
		return false;
	}
}
