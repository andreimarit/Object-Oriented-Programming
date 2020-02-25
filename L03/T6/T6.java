import java.util.*;

public class T6 {
	
	public static boolean checkIfPrime(int x)
	{
		boolean isPrime = true;
		
		for(int i = 2; i < x / 2; i++)
			if(x % i == 0)
			{
				isPrime = false;
				break;
			}
		return isPrime;
	}
	
	public static List<Integer> generatePrimeNumbers(int n)
	{
		List<Integer> prime = new ArrayList<Integer>();
		int count = 0;
		
		prime.add(count++, 2);
		
		for(int i = 3; i <= n; i = i + 2)
			if(checkIfPrime(i))
				prime.add(count++, i);
		
		return prime;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		List<Integer> prime = generatePrimeNumbers(n);
		
		if(m % 2 != 0)
			m++;
		if(n % 2 != 0)
			n--;
	//	System.out.println(prime.size() + " " + prime.get(3));
		for(int i = m; i <= n; i = i + 2)
		{
			int left = 0;
			int right = prime.size() - 1;
			while(left <= right)
			{
				if(prime.get(left) + prime.get(right) == i)
					break;
				else if(prime.get(left) + prime.get(right) < i)
					left++;
				else right--;
			}
			if(prime.get(left) + prime.get(right) == i)
				System.out.println(i + " = " + prime.get(left) + " + "+ prime.get(right));
			else
				System.out.println(i + "can not be written as the sum of 2 prime numbers");
		}
		in.close();
	}
	
}
