import java.util.*;
import java.io.*;
import java.text.*;
/**
 * Solution
 * @author Joe Hernandez
 */

//Uva 10226
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1167
public class HardwoodSpecies{
	
	public static void main(String[] args) throws IOException {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("#0.0000", simbolos);
		
		Iterator<String> it;
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		
		while(n-->0){
			int conta = 0;
			Map<String, Integer> treeMap = new TreeMap<String, Integer>();
			
			String line = "";
			while((line = br.readLine())!=null && !line.isEmpty()){
				conta++;
				
				if(treeMap.containsKey(line))
					treeMap.put(line, treeMap.get(line)+1);
				else
					treeMap.put(line, 1);
			}
			
			it = treeMap.keySet().iterator();
			
			while(it.hasNext()){
				String key = it.next();
				double valor = ((double)(100)/(double)(conta))*(double)(treeMap.get(key));
				sb.append(key + " "+ formateador.format(valor)+"\n");
			}
			if(n>0)
				sb.append("\n");
		} 
		
		wr.write(sb.toString()+"");
		
		br.close();
		wr.close();
	}
}