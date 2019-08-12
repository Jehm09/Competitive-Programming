import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * UVa 12640
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4388
 * @author Joe Hernandez
 */

public class LargestSumGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		
		while ((line = br.readLine())!=null) {
			String[] valores = line.split(" ");
			
			int max =0, actual =0;
			for (int i = 0; i < valores.length; i++) {
				
				int n = Integer.parseInt(valores[i]);

				max = Math.max(actual, max);
				actual  = (n > n+actual)? n:n+actual;
			}
			
			System.out.println(Math.max(actual, max));
		}
		
		
		
		
	}

}
