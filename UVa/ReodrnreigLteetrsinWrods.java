import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * UVa 12641
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=4389
 * @author Joe Hernandez
 */

public class ReodrnreigLteetrsinWrods {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();
		
		int n = Integer.parseInt(bReader.readLine());
		
		while(n-->0) {
			String[] line1 = bReader.readLine().split(" ");
			String[] line2 = bReader.readLine().split(" ");
			
			for (int i = 0; i < line2.length; i++) {
				String cadena = line2[i];
				int cont = 0;
				for (int j = 0; j < line1.length; j++) {
					if (checkWord(cadena, line1[j])) {
						if (line2.length-1==i) 
							sBuilder.append(line1[j]);
						else 
							sBuilder.append(line1[j]+" ");
						cont++;
						break;
					}
				}
				
				if (cont==0) {
					if (line2.length-1==i) 
						sBuilder.append(line2[i]);
					else 
						sBuilder.append(line2[i]+" ");
				}
			}
			sBuilder.append("\n");
		}
		System.out.print(sBuilder.toString());

	}
	
	public static boolean checkWord(String original, String second) {
		int contador = 2;
		
		if (second.length()!=original.length()) 
			return false;
		if (original.charAt(0)!=second.charAt(0)) 
			return false;
		if (original.charAt(original.length()-1)!=second.charAt(second.length()-1)) 
			return false;
		else {
			for (int i = 1; i < second.length()-1; i++) {
				if (second.contains(original.charAt(i)+"")) 
					contador++;
				else 
					break;
			}
		}

		if (contador==original.length()) 
			return true;
		else 
			return false;
	}

}