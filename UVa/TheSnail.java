import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * UVa 514
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=514
 * @author Joe Hernandez
 */

public class TheSnail {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		while (!(line = bReader.readLine()).equals("0 0 0 0")) {
			String arr[] = line.split(" ");
			double h = Integer.parseInt(arr[0])
				, u = Integer.parseInt(arr[1])
				, d = Integer.parseInt(arr[2])
				, f = Integer.parseInt(arr[3]);
			
			boolean finish = false;
			int days = 0;
			
			double temp = u*f/100;
			double up = 0;
			while (!finish) {
				days++;
				up += u;
				
				if (up>h) 
					finish = true;
				
				if (!finish) {
					up -= d;
					if (up<0) 
						finish = true;
				}
				u = u-temp;
				if (u<=0) 
					u = 0;
			}
			
			System.out.println((up<0)?"failure on day "+days:"success on day "+days);
		}
		
		bReader.close();
	}

}