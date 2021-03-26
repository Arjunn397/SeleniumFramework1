package MainTest;

import org.testng.annotations.Test;

public class MainTest 
{

	@Test(dataProvider ="test1data")
	public void test(String username , String password)
	{
		System.out.println(username +"|"+ password);
	}

	
	
}
