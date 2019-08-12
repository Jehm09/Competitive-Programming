import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Solution
 * UVa 10038
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=979
 * @author Joe Hernandez
 */

public class JollyJumper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String line = sc.nextLine();
			if (line.isEmpty()) break;

			PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
			
			String[] valores = line.split(" ");
			int now = Integer.parseInt(valores[1]);
			boolean st = true;
			
			for (int i = 2; i < valores.length && st; i++) {
				int next = Integer.parseInt(valores[i]);
				int res = Math.abs(now-next);
				now = next;
				cola.offer(res);
			}
			
			int actual = 0;
			if (!cola.isEmpty()) 
				actual = cola.poll();
			if (actual != 0 && actual != 1) 
				st = false;
			
			while (!cola.isEmpty() && st) {
				int actual1 = cola.poll();
				if (!(actual+1==actual1)) 
					st = false;
				
				actual = actual1;
			}
			
			System.out.println((st)?"Jolly":"Not jolly");
			
			
		}
		sc.close();
	}

}
