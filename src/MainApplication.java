import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MainApplication {

	public static void main(String [] args)
	{
		long initialTime = System.currentTimeMillis();
		System.out.println("Integer max: " + Integer.MAX_VALUE);
		SmallPrimeGenerator spg = new SmallPrimeGenerator();
		Num two = new Num("3");
		Num number1 = new Num(two);
		for (int counter = 0; counter < 1000000; counter++)
		{
			System.out.println(number1.val()+" + " + two.val());
			number1.add(two);
		}
		System.out.println(number1.val());
//		spg.generate(5);
		System.out.println("It tooks " + (System.currentTimeMillis() - initialTime) / 1000 + " seconds.");
		
	}
}



