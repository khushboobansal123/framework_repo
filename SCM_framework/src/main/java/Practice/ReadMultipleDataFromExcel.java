package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\OneDrive\\Desktop\\PracticeData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		for(int i=1; i<=rowcount; i++)
		{
			Row row = sh.getRow(i);
			String col1Data = row.getCell(0).toString();
			String col2Data = row.getCell(1).toString();
			System.out.println(col1Data+" "+col2Data);
			
		}
		
		wb.close();

	}

}
