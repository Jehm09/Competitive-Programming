import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * UVa 1753
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1753
 * @author Joe Hernandez
 */

//
//
public class BeattheSpread {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bReader.readLine());
		
		while (t-->0) {
			String line[] = bReader.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int a = s+b;
			int q = s-b;
			if (a<0 || q<0 || a%2==1 || q%2==1)
				System.out.println("impossible");
			else 
				System.out.println(a/2+" "+q/2);
			
		}
		bReader.close();
	}

}