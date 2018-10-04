import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 12641
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=4389
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

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
////Uva 12641
////https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=4389
//public class ReodrnreigLteetrsinWrods {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sBuilder = new StringBuilder();
//		
//		int n = Integer.parseInt(bReader.readLine());
//		
//		while(n-->0) {
//			String[] line1 = bReader.readLine().split(" ");
//			String[] line2 = bReader.readLine().split(" ");
//			
//			for (int i = 0; i < line2.length; i++) {
//				String cadena = line2[i];
//				int cont = 0;
//				for (int j = 0; j < line1.length; j++) {
//					String[][] palabra = convertArray(line1[j]);
//					if (checkWord(palabra, cadena)) {
//						if (line2.length-1==i) 
//							sBuilder.append(line1[j]);
//						else 
//							sBuilder.append(line1[j]+" ");
//						cont++;
//						break;
//					}
//				}
//				
//				if (cont==0) {
//					if (line2.length-1==i) 
//						sBuilder.append(line2[i]);
//					else 
//						sBuilder.append(line2[i]+" ");
//				}
//			}
//			sBuilder.append("\n");
//		}
//		System.out.print(sBuilder.toString());
//
//	}
//	
//	public static String[][] convertArray(String word){
//		String[][] rStrings = new String[2][word.length()];
//		for (int i = 0; i < rStrings[0].length; i++) 
//			rStrings[0][i] = word.charAt(i)+""; 
//		
//		return rStrings;
//	}
//	
//	
//	public static boolean checkWord(String[][] test,String original) {
//		char originalC = original.charAt(0);
//		char originalC1 = original.charAt(original.length()-1);
//		char testC = test[0][0].charAt(0);
//		char testC1 = test[0][test[0].length-1].charAt(0);
//		int originalLength = original.length();
//		int testLength = test[0].length;
//		
//		if (testLength!=originalLength) 
//			return false;
//		if (originalC!=testC) 
//			return false;
//		if (originalC1!=testC1) 
//			return false;
//		else {
//			test[1][0] = "1";
//			test[1][test[1].length-1] = "1";
//			for (int i = 1; i < originalLength-1; i++) {
//				char temp = original.charAt(i);
//				for (int j = 1; j < test[0].length-1; j++) {
//					char temp2 = test[0][j].charAt(0);
//					//&& que no lo tenga
//					if (temp == temp2 && test[1][j]==null) {
//						test[1][j] = "1";
//						break;
//					}
//				}
//			}
//		}
//		int contador = 0;
//		for (int i = 0; i < test[0].length; i++) {
//			if (test[1][i]!=null&&test[1][i].equals("1")) 
//				contador++;
//		}
//
//		if (contador==originalLength) 
//			return true;
//		else 
//			return false;
//	}
//
//}
//
//
