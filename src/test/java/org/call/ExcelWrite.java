package org.call;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\smphasis\\eclipse-workspace\\MavenConcept\\TestData\\Excel_Write.xlsx");
		FileInputStream fi =new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fi);
		Sheet s1 = w.getSheet("Greens");
		Row r = s1.getRow(0);
		Cell c1 = r.getCell(0);
		String value = c1.getStringCellValue();
		if (value.equals("Nisha")) {
			c1.setCellValue("Sharan");
		}
//		Sheet wt = w.createSheet("Greens");
//		Row row = wt.createRow(0);
//		Cell cell = row.createCell(0);
//		cell.setCellValue("Nisha");
		FileOutputStream ft = new FileOutputStream(f);
		w.write(ft);
		
		
		
		
	}

}
