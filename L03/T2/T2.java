import java.util.Scanner;
import java.util.Arrays;

public class T2 {
	
	public static int random()
	{
		int x = (int) (Math.random() * 49) + 1;
		return x;
	}

	public static boolean check(int arr[], int n, int key)
	{
		for(int i = 0; i < n; i++)
			if(arr[i] == key)
				return true;
		return false;
	}
	
/*	public static int[] lottery()
	{
		int arr[] = new int[6];
		for(int k = 0; k < 6; k++)
		{
			arr[k] = random();
			while(check(arr, k, arr[k]))         ?????????
				arr[k] = random();
		}
		return arr;
	}
*/	
	public static void main(String[] args) {
		int arr[], v[];
		int i = 0;
		Scanner in = new Scanner(System.in);
		arr = new int[6];
		v = new int [6];
		
		System.out.println("Introduceti 6 numere diferite de loterie (6 din 49):");
		
		while(i < 6)
		{
			v[i] = in.nextInt();
			if(v[i] < 1 || v[i] > 49 || check(v, i, v[i]))
				System.out.println("Introduceti un numar valid!:");
			else
				i++;
		}
		
		for(int k = 0; k < 6; k++)
		{
			arr[k] = random();
			while(check(arr, k, arr[k]))
				arr[k] = random();
		}
		
		System.out.println("Numerele castigatoare sunt:" + Arrays.toString(arr));
		
		Arrays.sort(v);
		Arrays.sort(arr);
		
		if (v.equals(arr))
			System.out.println("Felicitari, ati castigat!!!!!");
		else 
			System.out.println("Ai pierdut. Incearca din nou");
		
		in.close();
			
	}

}
