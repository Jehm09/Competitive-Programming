import java.util.Scanner;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 10130
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1071
public class SuperSale {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sBuilder = new StringBuilder();
		
		int t = scanner.nextInt();
		while (t-->0) {
			int o = scanner.nextInt();
			int arrV[] = new int[o];
			int arrW[] = new int[o];
			
			
			for (int i = 0; i < arrW.length; i++) {
				arrV[i] = scanner.nextInt();
				arrW[i] = scanner.nextInt();
			}
			
			int p = scanner.nextInt(), total = 0;
			
			while (p-->0) {
				int w = scanner.nextInt();
				total += bottomUpDP(arrV, arrW, w);
			}
			
			
			sBuilder.append(total+"\n");
			
		}
		System.out.print(sBuilder.toString());
		scanner.close();

	}
	
    public static int bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }

}