package ExcelUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcelUtil 
{

	public Object[][] testdata(String excelPath, String sheetName) throws IOException
	{
		ExcelUtil excel = new ExcelUtil(excelPath,sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object [][] data = new Object[rowCount-1][colCount];
		for(int i = 1; i<rowCount ;i++)
		{
			for(int j = 0 ; j<colCount ; j++)
			{
				data[i-1][j] = excel.getCellData(i, j);
			}
		}
		return data;
	}
	
	
	
	
	
	@DataProvider(name="test1data")
	public Object[][] dataPro() throws IOException
	{
		String excelPath = "/Users/arjun/eclipse-workspace/PMF/excel/Book1.xlsx";
		Object [][] data = testdata(excelPath, "login_credentials");
		return data;
	}
	
}
