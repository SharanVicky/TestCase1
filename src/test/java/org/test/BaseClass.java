package org.test;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void pageMax() {
		driver.manage().window().maximize();
	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);

	}

	public static void btnClick(WebElement ele) {
		ele.click();
	}
	
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		
			File f = new File("C:\\Users\\smphasis\\eclipse-workspace\\MavenConcept\\TestData\\testSample.xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fin);
			Sheet sheet = w.getSheet("Greens");
			
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			int cellType = cell.getCellType();
			String value="";
			if (cellType==1) {
				 value = cell.getStringCellValue();
				
			}
			else if (cellType==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
					 value = s.format(dateValue);
					
				}
				else {
					double d = cell.getNumericCellValue();
					long l = (long)d;
				 value = String.valueOf(l);
					
				}		

		}
			return value;
			

	}
	public static void tabClose() {
		driver.close();

	}

}
