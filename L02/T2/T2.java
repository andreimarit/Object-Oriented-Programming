import java.math.BigInteger;
import java.util.Scanner;

public class T2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		BigInteger x = new BigInteger("2");
		
		x = x.pow(i-1);
		System.out.println(x);
		
		in.close();
	}

}
