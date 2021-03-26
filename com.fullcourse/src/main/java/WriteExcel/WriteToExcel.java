package WriteExcel;

import java.io.IOException;

import org.testng.annotations.Test;

public class WriteToExcel 
{

	WriteExcel excel = new WriteExcel();
	@Test
	public void writeToExcelTest() throws IOException
	{
		excel.writeExcel("login_credentials", "Arjunn", 1, 3);
	}
	
}
