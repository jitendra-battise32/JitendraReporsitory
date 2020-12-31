package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public void excelSheetMethod() throws IOException {
		
		File src = new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
		FileInputStream fis =  new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from the Excel is "+data0);
		
		String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from the Excel is "+data1);
		
		
		wb.close();
		
		
	}
	
	
	
}
