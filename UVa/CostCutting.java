import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Solution
 * Uva 11727
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2827
 * @author Joe Hernandez
 */

public class CostCutting {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int c = 1;
		
		while (n-- > 0) {
			String arrL[] = in.readLine().split(" ");
			int arr[] = {Integer.parseInt(arrL[0]), Integer.parseInt(arrL[1]), Integer.parseInt(arrL[2])};
			Arrays.sort(arr);
			
			System.out.println("Case "+(c++)+": "+arr[1]);
		}
		
		in.close();
	}

}