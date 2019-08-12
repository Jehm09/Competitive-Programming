import java.io.*;

/**
 * Solution
 * @author Joe
 *	UVa 458
 *	https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=399 
 */

public class TheDecoder {

	public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(System.out);
        int s;
        while ((s = in.read()) != -1) {
            if (s == 10) {
                out.writeByte(10);
            } else {
                out.writeByte(s - 7);
            }
            out.flush();
        }
        in.close();
        out.close();
	}

}