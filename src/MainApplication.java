import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainApplication {

	public static void main(String [] args)
	{		
		long initialTime = System.currentTimeMillis();
		System.out.println("Integer max: " + Integer.MAX_VALUE);
	
		
		
		SmallPrimeGenerator spg = new SmallPrimeGenerator();
		/*
		Num two = new Num("3");
		Num number1 = new Num(two);
		System.out.println(number1.val()+" + " + two.val());
		number1.add(two);
		
		System.out.println("biggest prime: " + getStartingPrime());
		
		System.out.println(number1.val());
		*/
	//	spg.generate(1000);
		System.out.println("It tooks " + ((System.currentTimeMillis() - initialTime) / 1000) + " seconds.");
		
	}

	public static int getStartingPrime()
	{
		ArrayList<String> lines = new ArrayList<String>();		
		try {
            URL getLargestPrime = new URL("http://westleybonack.com/projects/primes/db/getLargestPrime.php");
            BufferedReader in = new BufferedReader(new InputStreamReader(getLargestPrime.openStream()));
            String inputLine; 
 
            while ((inputLine = in.readLine()) != null) {
                // Process each line.
                System.out.println(inputLine);
								lines.add(inputLine);
            }
            in.close(); 

						return Integer.parseInt(lines.get(0));
						
 
        } catch (MalformedURLException me) {
            System.out.println(me); 
 
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
		return -1;
	}

}



