import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution
 * Arbol N ario
 * UVa 233
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=233
 * @author Joe Hernandez
 */

public class Quadtrees {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bReader.readLine());
		while (t-->0) {
			String line1 = bReader.readLine();
			String line2 = bReader.readLine();
			
			char l1 = line1.charAt(0);
			char l2 = line2.charAt(0);
			
			line1 = line1.substring(1);
			line2 = line2.substring(1);
			
			quadTreesClass q1 = new quadTreesClass(32, l1);
			q1.createQuadTrees(line1);
			
			quadTreesClass q2 = new quadTreesClass(32, l2);
			q2.createQuadTrees(line2);
			
			quadTreesClass q3 = null;
			q3 = merge(q1, q2);
			
			System.out.println("There are "+q3.countPixels()+" black pixels.");
		}
		
	}
	
	public static quadTreesClass merge(quadTreesClass q1, quadTreesClass q2) {
		quadTreesClass temp = new quadTreesClass(32, 'p');
		if (q1.tip=='f'||q2.tip=='f') 
			temp.tip = 'f';
		else if (q1.tip=='p'&&q2.tip=='p') {
			for (int i = 0; i < q1.subQuadTrees.length; i++) {
				if (q1.subQuadTrees[i].tip=='f'||q2.subQuadTrees[i].tip=='f') 
					temp.subQuadTrees[i] = (q1.subQuadTrees[i].tip=='f')?q1.subQuadTrees[i]:q2.subQuadTrees[i];
				else if (q1.subQuadTrees[i].tip=='p'&&q2.subQuadTrees[i].tip!='p') 
					temp.subQuadTrees[i] = q1.subQuadTrees[i];
				else if (q1.subQuadTrees[i].tip!='p'&&q2.subQuadTrees[i].tip=='p') 
					temp.subQuadTrees[i] = q2.subQuadTrees[i];
				else if (q1.subQuadTrees[i].tip=='p'&&q2.subQuadTrees[i].tip=='p') 
					temp.subQuadTrees[i] = merge(q1.subQuadTrees[i], q2.subQuadTrees[i]);
				else 
					temp.subQuadTrees[i] = q1.subQuadTrees[i];
				
			}
		}
		else if (q1.tip=='p'&&q2.tip=='e') 
			temp = q1;
		else 
			temp = q2;
		
		return temp;
	}
	
}
class quadTreesClass{
	static char tip1 = 'p';
	static char tip2 = 'f';
	static char tip3 = 'e';
	
	int pix = 0;
	quadTreesClass subQuadTrees[];
	char tip = 0;
	public quadTreesClass(int pix, char tip) {
		super();
		this.pix = pix;
		this.subQuadTrees = new quadTreesClass[4];
		this.tip = tip;
	}
	
	public void createQuadTrees(String cadena) {
		createQuadTreesS(cadena);
	}
	private String createQuadTreesS(String cadena) {
		int conta = 0;
		while (!cadena.isEmpty()&&conta<4) {
			char tempTi = cadena.charAt(0);
			boolean st = true;
			
			if (tempTi == tip1) {
				for (int i = 0; i < subQuadTrees.length && st; i++) {
					if (subQuadTrees[i]==null) {
						subQuadTrees[i] = new quadTreesClass(pix/2, tempTi); 
						cadena = subQuadTrees[i].createQuadTreesS(cadena.substring(1));
						st = false;
						conta++;
					}
				}
			}
			else if (tempTi == tip2) {
				for (int i = 0; i < subQuadTrees.length && st; i++) {
					if (subQuadTrees[i]==null) {
						subQuadTrees[i] = new quadTreesClass(pix/2, tempTi); 
						st = false;
						conta++;
						cadena = cadena.substring(1);
					}
				}
			}
			else {
				for (int i = 0; i < subQuadTrees.length && st; i++) {
					if (subQuadTrees[i]==null) {
						subQuadTrees[i] = new quadTreesClass(pix/2, tempTi); 
						st = false;
						conta++;
						cadena = cadena.substring(1);
					}
				}
			}
		}
		return cadena;
	}
	
	public int countPixels() {
		int i = 0;
		if (tip==tip2) {
			i += pix*pix;
		}
		else if (tip==tip1) {
			for (int j = 0; j < subQuadTrees.length; j++) 
				i += subQuadTrees[j].countPixels();
		}
		
		return i;
	}
}