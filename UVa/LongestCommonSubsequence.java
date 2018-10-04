import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 10405
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1346
public class LongestCommonSubsequence {
	
	//Longest Common Subsequence

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line1;
		
		while ((line1 = br.readLine())!=null) {
			String line2 = br.readLine();
			
			
			//Method Longest Common Subsequence
			
			int[][] matrix = new int[line1.length()+1][line2.length()+1];
			
			
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (line1.charAt(i-1) == line2.charAt(j-1)) 
						matrix[i][j] = matrix[i-1][j-1]+1;
					else 
						matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]); 
				}
			}
			System.out.println(matrix[matrix.length-1][matrix[0].length-1]);
		}
	}

}
