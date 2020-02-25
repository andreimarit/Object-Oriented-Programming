
public class Ex1 {
	
	private static float divide(float x, float y) throws Exception
	{
		if(y == 0) {
			throw new Exception("Can not divide a number by zero");
		}
		else {
			return x/y;
		}
	}

	public static void main(String[] args) {
		
		float x = 5, y = 0;
		
		try {
			divide(x, y);
		}
		catch(Exception e){
			System.out.println("" + e.getMessage());
		}
		finally
		{
			System.out.println("I got to the finally block");
		}
	}
	
}
