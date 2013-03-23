import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MainApplication {

	public static void main(String [] args)
	{
		long initialTime = System.currentTimeMillis();
		SmallPrimeGenerator spg = new SmallPrimeGenerator();
		Num number1 = new Num("2");
		number1.add(number1);
		number1.add(number1);
		number1.add(number1);
		number1.add(number1);
		System.out.println(number1.val());
//		spg.generate(5);
		System.out.println("It tooks " + (System.currentTimeMillis() - initialTime) / 1000 + " seconds.");
		
	}
}



