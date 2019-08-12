import java.util.*;
/**
 * Solution
 * UVa 673
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=614
 * @author Joe Hernandez
 */

public class ParenthesesBalance{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		char valor2 = '[';
		char valor3 = '(';

		char cvalor2 = ']';
		char cvalor3 = ')';
		int n = Integer.parseInt(sc.nextLine());
		while (n-->0) {
			String input=sc.nextLine();
			if (!input.isEmpty()) {
				Stack<Character> pila = new Stack<>();
				Stack<Character> pila2 = new Stack<>();
				boolean rst = true;
				
				for (int i = 0; i < input.length() && rst; i++) {
					char temp = input.charAt(i);
					if (temp == valor2 || temp == valor3) 
						pila.add(temp);
					else {
						char temp2 = ' ';
						if (temp == cvalor2 || temp == cvalor3) 
							pila2.add(temp);
						if (!pila.isEmpty()) {
							if (temp == cvalor2) {
								temp2 = pila.pop();
								pila2.pop();
								if (temp2 != valor2) 
									rst = false;
							}
							else if (temp == cvalor3) {
								temp2 = pila.pop();
								pila2.pop();
								if (temp2 != valor3) 
									rst = false;
							}
						}
						else {
							if (!pila2.isEmpty()) 
								rst = false;
						}
					}
				}
				if (!pila.isEmpty()) {
					System.out.println("No");
				}
				else {
					System.out.println((rst)?"Yes":"No");
				}
			}
			else 
				System.out.println("Yes");
		}
		sc.close();
	}
}