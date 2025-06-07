package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultpleRowBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		Boolean flag=false;
		String expectedtestID = "tc_02";
		String data="";
		String data1="";
		String data2="";
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Asus\\\\OneDrive\\\\Desktop\\\\PracticeData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		int rows=sh.getLastRowNum();
		for(int i=1; i<=rows; i++)
		{   
			try {
			data=sh.getRow(i).getCell(0).toString();
			//if(data.equals(expectedtestID))
			//{
				//flag=true;
				//data1=sh.getRow(i).getCell(1).toString();
				//data2=sh.getRow(i).getCell(2).toString();
				//break;
			//}
		}
			catch(Exception e)
			{
				}
			System.out.println(data);
			
			}
		
		//if(flag==true)
			
		//{System.out.println(data1);
		//System.out.println(data2);}
		//else
		//{
			//System.out.println(expectedtestID+" is not available");
		//}

}
}