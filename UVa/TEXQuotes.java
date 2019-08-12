import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution
 * UVa 272
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=208
 * @author Joe
 *
 */

public class TEXQuotes {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String txt = "";
		boolean second = false;
		while ((txt = bReader.readLine()) != null) {
			for (int i = 0; i < txt.length(); i++) {
				if (txt.charAt(i) == '"') {
					if (!second)
						System.out.print("``");
					else
						System.out.print("''");

					second = !second;
				} else
					System.out.print(txt.charAt(i));
			}
			System.out.println();

		}
		bReader.close();
	}

}