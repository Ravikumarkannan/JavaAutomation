package com.automationpractice.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream inputStream = null;
	public FileOutputStream outputStream = null;
	private XSSFSheet workSheet;
	private XSSFWorkbook workBook;
	private XSSFCell cell;
	private XSSFRow row;

	public String[][] getExcelData(String filePath, String sheetName) {

		String[][] dataArray = null;

		try {
			inputStream = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(inputStream);
			workSheet = workBook.getSheet(sheetName);
			row = workSheet.getRow(0);

			int totalRows = workSheet.getPhysicalNumberOfRows();
			int totalColumns = row.getLastCellNum();
//			System.out.println("total rows" + totalRows);
//			System.out.println("total columns" + totalColumns);

			dataArray = new String[totalRows - 1][totalColumns];
			
			for (int rowCount = 1; rowCount < totalRows; rowCount++) {
				
				for (int columnCount = 0; columnCount < totalColumns; columnCount++) {
					row = workSheet.getRow(rowCount);
					cell = row.getCell(columnCount);
					dataArray[rowCount - 1][columnCount] = cell.getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return dataArray;

	}
}
