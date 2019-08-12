
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

/**
 * Solution
 * UVa 10815
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1756
 * @author Joe
 */
public class AndysFirstDictionary {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = "";

		TreeSet<String> treeSet = new TreeSet<>();

		while ((line = in.readLine()) != null) {

			String aux = "";
			for (int i = 0; i < line.length(); i++) {
				if (Character.isLetter(line.charAt(i))) 
					aux += line.charAt(i);
				else {
					aux = aux.toLowerCase();
					if (aux.length() > 0) 
						treeSet.add(aux);
					aux = "";
				}
			}
			if (aux.length()> 0){
				aux = aux.toLowerCase();
				treeSet.add(aux);
			}

		}

		for (String string : treeSet)
			out.write(string + "\n");

		in.close();
		out.close();
	}

}
