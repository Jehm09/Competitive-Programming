import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution using BIT
 * UVa 10810
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1751
 * @author Joe Hernandez
 */

public class UltraQuickSort_BIT {
	public static int array[];
	public static long swaps = 0;
	 public static int[] BIT;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while (N > 0) {
			int max = N+1;
			array = new int[N];
			BIT = new int[max];

			for (int i = 0; i < N; i++) {
				array[i] = in.nextInt();
			}
			
			array = converArr(array.clone());

			long inv = 0;
			//Recorrido inverso
			for (int i = array.length-1; i > -1; i--) {
				inv += query(array[i]-1);
				update(array[i], 1, max);
			}

			System.out.println(inv);
			N = in.nextInt();
		}
		in.close();
	}

	public static void update(int x, int delta, int tam) {
		for (; x < tam; x += x & -x) {
			BIT[x] += delta;
		}
	}

	public static long query(int x) {
		long sum = 0;
		for (; x > 0; x -= x & -x) {
			sum += BIT[x];
		}
		return sum;
	}
	
	public static int[] converArr(int arr[]){
		int rst[] = arr.clone();
		int max = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		Arrays.sort(arr);
		for (int i = arr.length-1; i > -1; i--) 
			map.put(arr[i], max--);
			
		for (int i = 0; i < rst.length; i++) 
			rst[i] = map.get(rst[i]);
			
		
		return rst;
	}

}
/*
5
9
1
0
5
4
3
1
2
3
0
*/