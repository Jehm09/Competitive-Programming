import java.io.*;
import java.util.*;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 10954
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895
public class AddAll {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = -1;
		while((t = Integer.parseInt(br.readLine()))!= 0) {
			String[] line = br.readLine().split(" ");
			PriorityQueue<Integer> cola = new PriorityQueue<>();
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(line[i]);
				cola.offer(n);
			}
			
			int total = 0;
			while (cola.size()>1) {
				int n1 = cola.poll();
				int n2 = cola.poll();
				
				int rst = n1+n2;
				total += rst;
				cola.offer(rst);
			}
			sb.append(total+"\n");
		}
		System.out.print(sb.toString());
	}
}
