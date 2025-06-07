package Practicescripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromWebAndWriteIntoExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		driver.findElement(By.xpath("//span[text()='Buses']")).click();
		driver.findElement(By.xpath("//input[@id=\"travelDate\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Tue Jun 17 2025\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"search_button\"]")).click();
		List<WebElement> names = driver.findElements(By.xpath("//p[@class=\"makeFlex hrtlCenter appendBottom8 latoBold blackText appendRight15\"] | //span[@class=\"sc-ckVGcZ kafEbu\"]"));
		
		/*
		 * for(int i=0; i<names.size(); i++) {
		 * System.out.println(names.get(i).getText()); }
		 */
		 
		
		FileInputStream fis = new FileInputStream("./src/test/resources/PlayersData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		if(sh==null)
			sh=wb.createSheet("Sheet2");
		  Row row = sh.getRow(0);
		  if(row==null)
		    row=sh.createRow(0);
		    row.createCell(0).setCellValue("Bus Name");
		    row.createCell(1).setCellValue("Bus Price");
		    int rowcount=1;
		    
		    
		for(int i=0; i<names.size(); i+=2)
		{ 
			Row row1=sh.createRow(rowcount++);
			row1.createCell(0).setCellValue(names.get(i).getText());
			row1.createCell(1).setCellValue(names.get(i+1).getText());
			
			
		}
		
		FileOutputStream fis2 = new FileOutputStream("./src/test/resources/PlayersData.xlsx");
		wb.write(fis2);
		System.out.println("====");
		wb.close();
		

	}

}
