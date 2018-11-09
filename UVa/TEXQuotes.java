import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Uva 272
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=208
public class TEXQuotes {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String txt = "";
		while((txt = bReader.readLine())!=null) {
			String line2 = bReader.readLine();
			StringBuilder sBuilder  = new StringBuilder();
			if (line2 == null) 
				sBuilder.append(txt);
			else
				sBuilder.append(txt+"\n"+line2);
				
			char arrS[] = sBuilder.toString().toCharArray();
			System.out.println(formatWord(arrS));
			
		}
		bReader.close();
	}
	
	public static StringBuilder formatWord(char arr[]) {
		StringBuilder sBuilder = new StringBuilder();
		char arr2[] = new char[arr.length*2];
		boolean second = false;
		for (int i = 0, j = 0; i < arr.length; i++, j++) {
			if (arr[i] == '"' && !second) {
				second = true;
				arr2[j] = '`';
				arr2[j+1] = '`';
				j += 1;
			}
			else if (arr[i] == '"' && second) {
				second = false;
				arr2[j] = 39;
				arr2[j+1] = 39;
				j += 1;
			}
			else 
				arr2[j]= arr[i];
		}
		int i = 0;
		while (arr2[i] != 0) {
			sBuilder.append(arr2[i]);
			i++;
		}
		return sBuilder;
	}
}