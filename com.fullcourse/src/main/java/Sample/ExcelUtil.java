package Sample;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil 
{
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelUtil(String excelPath , String sheetName) throws IOException
	{
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(sheetName);
	}

	
	public static int getRowCount()
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of Rows:"+rowCount);
		return rowCount;
	}
	
	public static int getColCount()
	{
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of columns:"+colCount);
		return colCount;
	}
	
	public static String getCellData(int rownum , int colnum)
	{
		String cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		System.out.println("Cell Data:"+cellData);
		return cellData;
	}
	public static void main(String[] args) 
	
	{
		// TODO Auto-generated method stub
		
		getRowCount();
		getColCount();
		getCellData(0,0);

	}

}
