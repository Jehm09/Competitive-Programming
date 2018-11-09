import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

//Uva 1062
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3503
public class Containers {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String line = "";
		
		int tC = 1;
		while (!((line = in.readLine()).equals("end"))) {
			ArrayList<Stack<Character>> arrayStack = new ArrayList<>(1000);
			char arr[] = line.toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				if (arrayStack.isEmpty()) {
					Stack<Character> sTemp = new Stack<>();
					sTemp.push(arr[i]);
					arrayStack.add(sTemp);
				}
				else {
					boolean st = true;
					for (int j = 0; j < arrayStack.size() && st; j++) {
						Stack<Character> sTemp = arrayStack.get(j);
						if (sTemp.peek()>=arr[i]) {
							sTemp.push(arr[i]);
							st = false;
						}
					}
					if (st) {
						Stack<Character> sTemp = new Stack<>();
						sTemp.push(arr[i]);
						arrayStack.add(sTemp);
					}
				}
			}
			sb.append("Case "+tC+": "+arrayStack.size()+"\n");
			tC++;
		}
		
		out.write(sb.toString());
		
		in.close();
		out.close();

	}
}
