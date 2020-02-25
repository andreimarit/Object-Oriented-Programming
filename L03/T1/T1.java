import java.math.BigInteger;
import java.util.Scanner;

public class T1 {
	
	public static BigInteger factorial(int a, int b)
	{
		BigInteger f = new BigInteger("1");
		for(int i = a; i <= b; i++)
		{
			BigInteger aux = new BigInteger("" + i);
			f = f.multiply(aux);
		}
		return f;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
	//	int odds = factorial(n - k +  1, n)/factorial(1, k);
		
		BigInteger odds = new BigInteger("" + factorial(n - k +  1, n));
		BigInteger temp1 = new BigInteger("" + factorial(1, k));
		odds = odds.divide(temp1);
		
		System.out.println(odds);
		
		in.close();
	}
}
