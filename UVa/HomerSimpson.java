import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 10465
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1406
public class HomerSimpson {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = br.readLine())!=null) {
			String[] line1 = line.split(" ");
			int m = Integer.parseInt(line1[0]), n = Integer.parseInt(line1[1]), t = Integer.parseInt(line1[2]);
			int arr[] = calcularMax(m, n, t);
			int max = arr[0], rst = arr[1], beer = t-max;
			System.out.println((beer==0)?rst:rst+" "+beer);
		}
		
		br.close();
	}
	
	public static int[] calcularMax(int m, int n , int t) {
		int max = 0, i = 0, suma = 0;
		int may = Math.max(m, n);
		int men = Math.min(n, m);
		while (i*may<=t && max!=t) {
			int j = 0;
			while (j*men<=t && max!=t) {
				int temp = (j*men) + (i*may);
				if (temp <= t) {
					if (max<temp) {
						max = temp;
						suma = i+j;
					}
				}
				j++;
			}
			i++;
		}
		int arr[] = new int[2];
		arr[0] = max;
		arr[1] = suma;
		return arr;
	}
}