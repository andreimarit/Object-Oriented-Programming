import java.util.Scanner;
import java.math.BigInteger;

public class T5 {
	
	public static final BigInteger HUNDRED = new BigInteger("100");
	public static final BigInteger ZERO = new BigInteger("0");
	
	public static char getLetter(int x)
	{
		char c;
		switch(x) {
		case 0: c = ' ';
				break;
		case 1: c = ',';
				break;
		case 2: c = '.';
				break;
		default: c = (char) (x + 62);
				break;
		}
		return c;
	}
	
	public static String decode(BigInteger x)
	{
		String s = new String();
		
		while(x.compareTo(ZERO) != 0)
		{
			 int aux = x.remainder(HUNDRED).intValue();
			 x = x.divide(HUNDRED);
			 s = getLetter(aux) + s;
		}
		
		return s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger code = in.nextBigInteger();
		
		System.out.println(decode(code));
		
		in.close();
	}

}
