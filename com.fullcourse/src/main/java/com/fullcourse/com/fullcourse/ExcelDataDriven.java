package com.fullcourse.com.fullcourse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven 


{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;


	public ExcelDataDriven(String excelPath , String sheetName)
	{

		try {
			wb = new XSSFWorkbook(excelPath);
			sheet = wb.getSheet(sheetName);
		} 

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static int getRowcount()
	{
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of Rows:"+rowCount);
		return rowCount;

	}
	
	public static int getColcount()
	{
		
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of Column:"+colCount);
		return colCount;

	}

	public static int getCelldata(int rowNum, int colNum)
	{
		
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println("Data Present in Cell is :"+cellData);
		return colNum;

	}

	public static void main(String[] args)
	{

		getRowcount();
		getCelldata(0, 0);

	}



}
