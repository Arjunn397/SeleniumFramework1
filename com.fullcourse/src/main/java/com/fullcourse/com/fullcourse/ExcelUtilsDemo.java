package com.fullcourse.com.fullcourse;

public class ExcelUtilsDemo 

{

	
	public static void main(String[] args)
	{
		ExcelDataDriven excel = new ExcelDataDriven("/Users/arjun/eclipse-workspace/PMF/excel/Book1.xlsx", "login_credentials");
		
		excel.getRowcount();
		excel.getCelldata(0, 0);
	}
	
}
