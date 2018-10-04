import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 1361
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1361
public class ListofConquests {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bReader.readLine());
		
		TreeMap<String, Integer> map = new TreeMap<>();
		
		while (t-->0) {
			String line = bReader.readLine().trim().split(" ")[0];
			
			if (map.containsKey(line)) 
				map.put(line, map.get(line)+1);
			else 
				map.put(line, 1);
		
			
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+" "+map.get(key));
		}
	}
}
