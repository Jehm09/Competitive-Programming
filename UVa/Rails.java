import java.util.Scanner;
import java.util.Stack;;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 514
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=455
public class Rails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sBuilder = new StringBuilder();
		
		while (sc.hasNext()) {
			int input = sc.nextInt();
			if (input==0) break;
			
			boolean st = true;
			
			while (st) {
				Stack<Integer> pila = new Stack<>();
				
				int conta = 0;
				for (int i = 0; i < input; i++) {
					int value = sc.nextInt();
					
					if (value == 0) {
						st = false;
						break;
					}
					
					while(conta < input && conta != value) {
						if (!pila.isEmpty() && pila.peek() == value) break;
						conta++;
						pila.push(conta);
					}
					if (pila.peek()==value) 
						pila.pop();
				}
				if (st) 
					sBuilder.append((pila.isEmpty())?"Yes\n":"No\n");
					
			}
			sBuilder.append("\n");
		}
        System.out.print(sBuilder.toString());
        sc.close();
    }
}