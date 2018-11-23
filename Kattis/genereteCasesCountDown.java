import java.util.ArrayList;
import java.util.Collections;

public class genereteCasesCountDown {
	public static void main(String[] args) {
		ArrayList<Integer> val = new ArrayList<>();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);
		val.add(9);
		val.add(10);
		val.add(25);
		val.add(50);
		val.add(75);
		val.add(100);
		
		for (int i = 0; i < 50; i++) {
			int target = (int) (Math.random()*1000);
			Collections.shuffle(val);
			
			for (int j = 0; j < 6; j++) 
				System.out.print(val.get(j)+" ");
			
			System.out.println(target);
		}
	}
}
