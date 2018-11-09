import java.io.*;
import java.util.*;

/**
 * @author Joe
 *	Uva 11286
 *	https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2261
 */
public class Conformity {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = "";
		
		while (!(line=in.readLine()).equals("0")) {
			LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
			int t = Integer.parseInt(line);
			
			while (t-->0) {
				String arrI[] = in.readLine().split(" ");
				Arrays.sort(arrI);
				String u = uniKey(arrI);
				map.put(u, (map.containsKey(u))?map.get(u)+1:1);
			}
			
			int max = 0;
			for (int i : map.values()) 
				max = Math.max(i, max);
			
			int conta = 0;
			for (int i : map.values()) 
				conta += (i==max)?i:0;
			
			out.write(conta+"\n");
		}
		
		in.close();
		out.close();
	}

	public static String uniKey(String arr[]) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < arr.length; i++) 
			sBuffer.append(arr[i]);
		
		return sBuffer.toString();
	}

}
