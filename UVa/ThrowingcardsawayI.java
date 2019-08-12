import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Solution
 * UVa 10935
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1876
 * @author Joe Hernandez
 */

public class ThrowingcardsawayI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n!=0){
			Queue<Integer> cola = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= n; i++) 
				cola.add(i);
			
			sb.append((cola.size()==1)?"Discarded cards:\n":"Discarded cards: ");
			
			while(cola.size()!=1){
				sb.append((cola.size()==2)?cola.poll()+"\n":cola.poll()+", ");
				int x = cola.poll();
				cola.add(x);
			}
			sb.append("Remaining card: "+cola.peek());
			
			System.out.println(sb.toString());
			n = sc.nextInt();
		}
		sc.close();
		
	}

}