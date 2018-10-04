import java.io.*;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 13258
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5181
public class RomeoandJulietSecrets {

	static int[] pre;
	static int[] suf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		while (n-->0) {
			String line1 = br.readLine();
			String line2 = br.readLine();
			String line1R = new StringBuffer(line1).reverse().toString();
			String line2R = new StringBuffer(line2).reverse().toString();
			int k = Integer.parseInt(br.readLine());
			
			pre = new int[line1.length()];
			suf = new int[line1.length()];
			
			search(line1, line2, pre);
//			searchR(line1, line2, suf);
			search(line1R, line2R, suf);
			
			int total = 0;
			for (int i = 0; i <= pre.length-line2.length(); i++) {
				int value = pre[i] + suf[(suf.length-1-i)-(line2.length()-1)];
				if (value>=line2.length()-k) 
					total++;
			}
			sBuilder.append(total+"\n");
		}
		System.out.print(sBuilder.toString());
		br.close();
	}
	
    public static void search(String text, String pattern, int[] arr) {
        String concat = pattern + "$" + text;
        int l = concat.length();
        int Z[] = new int[l];
        
        getZarr(concat, Z);
        for (int i = pattern.length()+1; i < Z.length; i++) 
			arr[i-(pattern.length()+1)]= Z[i]; 
    }
 
    // Fills Z array for given string str[]
    private static void getZarr(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0;
 
        for(int i = 1; i < n; ++i) {
            if(i > R){
                L = R = i;
                while(R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                 
                Z[i] = R - L;
                R--;
 
            }
            else{
                int k = i - L;
                if(Z[k] < R - i + 1)
                    Z[i] = Z[k];
                else{
                    L = i;
                    while(R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
