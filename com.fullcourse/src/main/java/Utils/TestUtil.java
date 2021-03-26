package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil 

{

	public static Object[][] testData(String excelPath, String sheetName) throws IOException
	{
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowcount();
		int colCount = excel.getColcount();
		Object [][] data = new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++)
		{
           for(int j =0; j<colCount;j++)
           {
        	  data[i-1][j] = excel.getCelldata(i,j);
           }
		}
		return data;

	}
	
	
	@Test(dataProvider = "test1data")
	public void test(String username , String password)
	{
		System.out.println(username + "|" + password);
	}


   @DataProvider(name = "test1data")
	public Object[][] getData() throws IOException
	{
	   
	   String excelPath = "/Users/arjun/eclipse-workspace/PMF/excel/Book1.xlsx";
	   
	   Object data [][] = testData(excelPath,"login_credentials");
	   
		return data;
		
	}



}
