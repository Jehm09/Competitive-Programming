import java.util.Scanner;

public class secretmessage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		while (n-->0) {
			String line = scanner.next();
			int l = line.length();
			int k = (int) Math.sqrt(l);
			k = (int) Math.sqrt(((int)Math.pow(k, 2) >= l)? (int)Math.pow(k, 2):(int)Math.pow((k+1), 2));
			
			char[][] matrix = new char[k][k];
			
			int conta = 0;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (conta<l) 
						matrix[i][j] = line.charAt(conta); 
					else
						matrix[i][j] = '*'; 
						
					conta++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < matrix.length; j++) {
				for (int i = matrix.length-1; i > -1; i--) {
					if (matrix[i][j] != '*') 
						sb.append(matrix[i][j]+"");
				}
			}
			
			sb.append("\n");
			System.out.print(sb.toString());
		}
		scanner.close();
	}
}
