
import java.io.*;
/**
 * Solution
 * UVa 10344
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1285
 * @author Joe
 */
public class outof {

	public static boolean pos = false;
	public static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = "";

		while (!(line = in.readLine()).equals("0 0 0 0 0")) {
			pos = false;
			vis = new boolean[5];

			String arr[] = line.split(" ");
			long values[] = new long[arr.length];

			for (int i = 0; i < values.length; i++)
				values[i] = Integer.parseInt(arr[i]);

			for (int i = 0; i < values.length; i++) {
				vis[i] = true;
				dp(values, values[i], 1);
				vis[i] = false;
			}

//			out.write((bestAprox.containsKey(bestApr)) ? bestAprox.get(bestApr) : "");
			out.write((pos ? "Possible" : "Impossible") + "\n");
		}

		in.close();
		out.close();
	}

	public static void dp(long arr[], long val, int conta) {
		if (conta == 5 && val == 23)
			pos = true;
		else {
			for (int i = 0; i < arr.length; i++) {
				if (!vis[i]) {
					vis[i] = true;
					dp(arr, val + arr[i], conta + 1);
					dp(arr, val * arr[i], conta + 1);
					dp(arr, val - arr[i], conta + 1);
					vis[i] = false;
				}
			}
		}

	}
}
