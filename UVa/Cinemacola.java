import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 12516
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3961
public class Cinemacola {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] lin = bReader.readLine().split(" ");
		
		
		int f = Integer.parseInt(lin[0]);
		int c = Integer.parseInt(lin[1]);
		
		boolean[][] matriz;
		
		while(f!=0 && c!=0) {
			matriz = new boolean[f][c+1];
			int po = Integer.parseInt(bReader.readLine());
			
			for (int i = 0; i < po; i++) {
				String[] line = bReader.readLine().split(" ");
				int f1 = line[0].charAt(0)-'A';
				String number = "";
				for (int j = 1; j < line[0].length(); j++) 
					number += line[0].charAt(j);
				int c1 = Integer.parseInt(number);
				
				boolean tipo = line[1].equals("-");
				
				if (tipo) {
					matriz[f1][c1-1] = true;
				}
				else {
					matriz[f1][c1] = true;
				}
			}
			
			int personas = Integer.parseInt(bReader.readLine());
		
			ArrayList<celda> lista = new ArrayList<>();
			
			
			for (int i = 0; i < personas; i++) {
				String x = bReader.readLine();
				char c1 = x.split("")[0].charAt(0);
				String number1 = "";
				
				for (int j = 1; j < x.length(); j++) 
					number1 += x.charAt(j);
				
				int number = Integer.parseInt(number1);
				
				lista.add(new celda(c1, number));
			}
			
			Collections.sort(lista);
			
			boolean accepted = true;
			
			for (int i = 0; i < lista.size()&&accepted; i++) {
				int f1 = lista.get(i).letra-'A';
				int c1 = lista.get(i).number;
				
				int pos1 = c1-1;
				int pos2 = c1;
				
				
				if (i+1<lista.size()) {
					int f2 = lista.get(i+1).letra-'A';
					int c2 = lista.get(i+1).number;
					
					if (c1+1 == c2 && f1==f2) {
						boolean st = matriz[f1][pos1];
						if (!st) 
							matriz[f1][pos1] = true;
						else {
							st = matriz[f1][pos2];
							if (!st) 
								matriz[f1][pos2] = true;
							else 
								accepted = false;
						}
					}
					else {
						boolean st = matriz[f1][pos1];
						if (!st) 
							matriz[f1][pos1] = true;
						else {
							st = matriz[f1][pos2];
							if (!st) 
								matriz[f1][pos2] = true;
							else 
								accepted = false;
						}
					}
				}
				else {
					boolean st = matriz[f1][pos1];
					if (!st) 
						matriz[f1][pos1] = true;
					else {
						st = matriz[f1][pos2];
						if (!st) 
							matriz[f1][pos2] = true;
						else 
							accepted = false;
					}
				}
				
				
			}
			
			if (accepted) 
				System.out.println("YES");
			else 
				System.out.println("NO");
			
			lin = bReader.readLine().split(" ");
			 
			f = Integer.parseInt(lin[0]);
			c = Integer.parseInt(lin[1]);
		}
		
		
	}

	static class celda implements Comparable<celda>{
		char letra;
		int number;
		
		public celda(char letra, int number) {
			this.letra = letra;
			this.number = number;
		}
		public int compareTo(celda o) {
			int k = 0;
			k = letra-o.letra;
			if ( k == 0 ) {
				k = number-o.number;
			}
			return k;
		}
		@Override
		public String toString() {
			return "celda [letra=" + letra + ", number=" + number + "]";
		}
		
	}
	
}
