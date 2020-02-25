

public class T3 {

	public static final int UNU = 1; 
	public static int size = 0;
	
	public static long inverse(long x)
	{
		long y = 0;
		long temp = 0;
		while(x > 0)
		{
			temp = x & UNU;
			x = x >> UNU;
			y = y << UNU;
			y = y | temp;
			size++;
		}
		return y;
	}
	
	public static void orderAscOrDesc(long order, int place, int sign)
	{
		for(int i = 0; i < 6; i++)
		{
			long aux = 0;
			while (aux == 0)
			{
				aux = order & UNU;
				order = order >> UNU;
				place = place + sign;
			}
			System.out.print(place + " ");
		}
	}
	
	public static void main(String[] args) {
		long order = 0;
		long order_inverse = 0;
		
		System.out.println("the numbers drawn are: ");
		
		for(int i = 0; i < 6; i++)
		{
			boolean numbersDifferent = false;
			int lottery = T2.random();
			long temp = 1;
			while(!numbersDifferent)
			{
				long aux = order; 
				temp = 1;
				temp = temp << lottery;
				aux = aux & temp;
				if(aux == 0)
					numbersDifferent = true;
				else
					lottery = T2.random();
			}
			System.out.print(lottery + " ");
			order = order | temp;
		}
		
		order_inverse = inverse(order);
		
		System.out.println("in ascending order: ");
		orderAscOrDesc(order, -1, 1);
		
		System.out.println("\nin descending order: ");
		orderAscOrDesc(order_inverse, size, -1);
		
		
	}

}
