package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\OneDrive\\Desktop\\PracticeData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		Row rw = sh.getRow(1);
		Cell cell = rw.createCell(3);
		cell.setCellValue("Fail");
		
		FileOutputStream fis2 = new FileOutputStream("C:\\\\Users\\\\Asus\\\\OneDrive\\\\Desktop\\\\PracticeData.xlsx");
		wb.write(fis2);
		wb.close();

	}

}
