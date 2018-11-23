import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Countdown {
    
    static char[] op = {'+', '-', '*', '/'};
    static HashMap<Long, String> bestAprox;
    static HashSet<String> map;
    static long bestApr = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(in.readLine());
        
//      long t2 = System.nanoTime();
        while (t-->0) {
            bestAprox = new HashMap<>();
            map = new HashSet<>();
            bestApr = 0;
            
            
            String arr[] = in.readLine().split(" ");
            long values[] = new long[arr.length-1];
            int target = Integer.parseInt(arr[6]);
            
            for (int i = 0; i < values.length; i++) 
                values[i] = Integer.parseInt(arr[i]);
            
            dp(values, target, "");
            
            out.write("Target: "+target+"\n");
            out.write((bestAprox.containsKey(bestApr))?bestAprox.get(bestApr):"");
            out.write("Best approx: "+bestApr+"\n\n");
            
//            for (Long l : bestAprox.keySet()) {
//				System.out.println(l);
//			}
            
        }
//      long t1 = System.nanoTime();
//      System.out.println(t1-t2);
        
        in.close();
        out.close();
    }
    
    static void dp(long arr[], int t, String cad) {
    	long ba = bestAp(arr, t);
    	
        if ((Math.abs(bestApr-t)==Math.abs(ba-t))) 
            bestApr = (bestApr>ba)?ba:bestApr;
        else 
            bestApr = ((Math.abs(bestApr-t)>Math.abs(ba-t)))?ba:bestApr;
        
        if (bestApr != t) {
            if (!map.contains(sArr(arr))) {
                for (int k = 0; k < op.length; k++) {
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = i+1; j < arr.length; j++) {
                        	String sA = sArr(arr);
                        	long num = ope(k, arr[i], arr[j]);
                            
                            if (num>=0) {
                                map.add(sA);
                                String cadTemp ="";
                                
                                if(num != arr[i] && num!= arr[j])
                                    cadTemp = arr[i]+" "+op[k]+" "+arr[j]+" = "+num+"\n";
                                
                                dp(newArr(i,  j, arr, num), t, cad+cadTemp);
                                
                                if (!bestAprox.containsKey(num)) 
                                    bestAprox.put(num, cad+cadTemp);
//                              else {
//                                  bestAprox.replace(bestApr, cad+cadTemp);
//                              }
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    static String sArr(long arr[]) {
        StringBuffer sb = new StringBuffer();
        long copArr[] = new long[arr.length];
        
        for (int i = 0; i < copArr.length; i++) 
			copArr[i] = arr[i]; 
        
        Arrays.sort(copArr);
        
        for (int i = 0; i < copArr.length; i++) 
            sb.append(copArr[i]+",");
        
        return sb.toString();
    }
    
    static long bestAp(long arr[], int t) {
    	long bestAp = Long.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) 
            if (Math.abs(bestAp-t)>(Math.abs(arr[i]-t))) 
                bestAp = arr[i];
        
        return bestAp;
    }
    
    
    static long ope(int k, long a, long b) {
        char c = op[k];
        
        if (c=='+') {
            return a+b;
        }
        else if (c=='-') {
            return a-b;
        }
        else if (c=='*') {
            return a*b;
        }
        else {
            if (b==0 || a%b!=0) 
                return -1;
            else
                return a/b;
        }
    }
    
    static long[] newArr(int i, int j, long arr[], long c) {
    	long rstArr[] = new long[arr.length-1];
        rstArr[0] = c;
        int k1 = 1;
        for (int k = 0; k1 < rstArr.length; k++) 
            if (!(i==k||j==k)) 
                rstArr[k1++] = arr[k];
        
        return rstArr;
    }
    
}