package com.scm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String data= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
		
		
	}
	
	public int getRowCount(String Sheetname) throws Throwable
	{
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		int rows=wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rows;
		
	}
	
	public void setDataIntoExcel(String sheetname, int rownum, int cellnum, String data) throws Throwable
	{
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		 wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
		
		 FileOutputStream fis = new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
		 wb.write(fis);
		 wb.close();
	}
}
