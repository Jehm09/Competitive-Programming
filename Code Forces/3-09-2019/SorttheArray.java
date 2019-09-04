import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SorttheArray {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());
		int arr1[] = new int[n];
		int arr2[] = new int[n];

		String line[] = in.readLine().split(" ");

		for (int i = 0; i < line.length; i++) {
			arr1[i] = Integer.parseInt(line[i]);
			arr2[i] = arr1[i];
		}

		Arrays.sort(arr2);

		int l = -1, r = -1;

		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i]!=arr2[i] ) {
				l = i;
				break;
			}
		}
		for (int i = arr2.length - 1; i > -1; i--) {
			if (arr1[i]!=arr2[i] ) {
				r = i;
				break;
			}
		}
		
		if (l == -1 && r == -1) 
			out.write("yes\n1 1\n");
		else {
			reverse(l, r, arr1);
			
			boolean st = false;
			for (int i = 0; i < arr2.length; i++) {
				if (arr1[i]!=arr2[i] ) {
					st = true;
					break;
				}
			}
			
			if (st) 
				out.write("no\n");
			else 
				out.write("yes\n"+(l+1)+" "+(r+1)+"\n");
		}
		
		in.close();
		out.close();
	}
	
	public static void reverse(int l, int r, int arr[]) {
		   int [] t = new int[arr.length];
	        for(int i=l,j=r; i<=r; i++,j--) 
	        	t[i] = arr[j];
	        	
	        for(int i=l; i<=r; i++)
	            arr[i] = t[i];
	}

}