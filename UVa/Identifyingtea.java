import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 13012
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4900
public class Identifyingtea {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while((line = bReader.readLine())!=null){
			int[] val = new int[6];
			int n = Integer.parseInt(line);
			String[] entra = bReader.readLine().split(" ");
			
			for (int i = 0; i < 5; i++) 
				val[Integer.parseInt(entra[i])] += 1;
			
			System.out.println(val[n]);
		}
		
	}

}
