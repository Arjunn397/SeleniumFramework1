package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 

{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath , String sheetName) throws IOException
	{
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(sheetName);
	}

	public static int getRowcount() throws IOException
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of Rows : "+ rowCount);
		return rowCount;

	}

	public static int getColcount() throws IOException
	{
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of Column : "+ colCount);
		return colCount;


	}

	public static String getCelldata(int rowNum, int colNum) throws IOException
	{
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println("Cell Data :"+ cellData);
		return cellData;

	}



	public static void main(String[] args) throws IOException
	{
		
		getRowcount();
		getColcount();
		getCelldata(0, 0);
	}

}
