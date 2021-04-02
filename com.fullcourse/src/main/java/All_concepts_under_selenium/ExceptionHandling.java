package All_concepts_under_selenium;

public class ExceptionHandling 
{

	public static void getException()
	{
		try
		{
		int i = 1/0;
		}
		catch(Exception e)
		{
			System.out.println("Excluding Exception");
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	public static void main(String[] args) 
	
	{
		// TODO Auto-generated method stub
		System.out.println("Exception");
		getException();

	}

}
