import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Solution
 * UVa 100
 * https://uva.onlinejudge.org/index.php?Itemid=8&option=com_onlinejudge&page=show_problem&problem=36
 * @author Joe Hernandez
 */

public class The3nPlus1problem {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sBuilder = new StringBuilder();
		int[] val = new int[2];
		
		while (sc.hasNext()) {
			//Inicializo el hashmap, key, valor son las entraddas.
			HashMap<Long, Long> primeraEntrada = new HashMap<Long, Long>();
			val[0] = sc.nextInt();
			val[1] = sc.nextInt();
			
			long max = 0;
			for (long i = Math.min(val[0], val[1]); i <= Math.max(val[0], val[1]); i++) {
				long sum = 1;
				
				long num = i;
				while(num!=1) {
					if (num%2 == 0) 
						num = num/2;
					else 
						num = (3*num)+1;
					if (primeraEntrada.containsKey(num)) {
						sum += primeraEntrada.get(num);
						break;
					}
					sum++;
				}
				if(!primeraEntrada.containsKey(i)) 
					primeraEntrada.put(i, sum);
				max = Math.max(max, sum);
			}
			sBuilder.append(val[0]+" "+val[1]+" "+max+"\n");
		}
		wr.write(sBuilder.toString()+"");
		
		sc.close();
		wr.close();
	}
	
}