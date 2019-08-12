import java.io.*;
import java.util.Stack;

/**
 * Solution
 * UVa 11111
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2052
 * @author Joe
 */

public class GeneralizedMatrioshkas {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = "";
		
		while ((line=in.readLine())!=null) {
			Stack<Matrioshkas> stack = new Stack<>();
			String arr[] = line.trim().split("\\s+");
			String rString = ":-) Matrioshka!";
			
			for (String string : arr) {
				int val = Integer.parseInt(string);
				
				if (val<0) 
					stack.push(new Matrioshkas(-val));
				else {
					if (stack.isEmpty()) {
						rString = ":-( Try again.";
						break;
					}
					if (stack.pop().val != val) {
						rString = ":-( Try again.";
						break;
					}
					if (!stack.isEmpty() && stack.peek().check(val)) {
						rString = ":-( Try again.";
						break;
					}
				}
			}
			
			out.write((stack.isEmpty())?rString+"\n":":-( Try again.\n");
		}
		
		in.close();
		out.close();
	}
	
	public static class Matrioshkas{
		int val;
		int cont;
		
		public Matrioshkas(int val) {
			this.val = val;
			cont = 0;
		}
		
		public boolean check(int x) {
			cont += x;
			return (cont>=val)?true:false;
		}
		
	}

}
