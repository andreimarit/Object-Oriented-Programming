import java.util.Scanner;
import java.math.BigInteger;

public class T4 {
	
	public static final BigInteger HUNDRED = new BigInteger("100");
	
	public static boolean flag;
	
	public static void checkLeadingZero(String s)
	{
		int c = encode(s.charAt(0));
		if(c < 10)
			flag = true;
		else
			flag = false;
	}
	
	public static int encode(char letter)
	{
		int c;
		switch(letter) {
		case ' ': c = 0;
				  break;
		case ',': c = 1;
				  break;
		case '.': c = 2;
				  break;
		default: c = letter - 62;
				  break;
		}
		return c;
	}
	
	public static BigInteger encodePhrase(String s)
	{
		BigInteger x = new BigInteger("0");
		int len = s.length();
		
		checkLeadingZero(s);
		
		for(int i = 0; i < len; i++)
		{
			x = x.multiply(HUNDRED);
			x = x.add(new BigInteger("" + encode(s.charAt(i))));
		}
		
		return x;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		BigInteger code = new BigInteger("" + encodePhrase(text));
		
		if(flag)
			System.out.print("" + 0);
		
		System.out.print(code);

		in.close();
	}

}
