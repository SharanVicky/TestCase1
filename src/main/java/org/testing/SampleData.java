package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;

public class SampleData {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\smphasis\\eclipse-workspace\\MavenConcept\\TestData\\testSample.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Greens");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				System.out.println(c);
				int cellType = c.getCellType();
				if (cellType == 1) {
					String stringValue = c.getStringCellValue();

					System.out.println(stringValue);
				} else if (cellType == 0) {
					if (DateUtil.isCellDateFormatted(c)) {

						Date dateValue = c.getDateCellValue();
						SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yyyy");
						String format = dt.format(dateValue);
						System.out.println(format);

					} else {
						double nu = c.getNumericCellValue();
						long l = (long) nu;
						String result = String.valueOf(l);
						System.out.println(result);

					}
				}

			}

		}
	}

}
