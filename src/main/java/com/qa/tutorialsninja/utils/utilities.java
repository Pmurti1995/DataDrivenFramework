package com.qa.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilities {

	public static final int Implicit_Wait_Time = 10;
	public static final int PageLoad_Wait_Time = 5;

	public static  String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "amotoori07012024"+timestamp+"@gmail.com";

	}
	public static Object[][] getTestDataFromExcel(String sheetname) {

		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null;
		try{
			FileInputStream fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for(int i =0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break; 
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;



				}

			}
		}
		return data;

	}



}
