import java.util.ArrayList;

public class SmallPrimeGenerator {
	void generate(int ceiling)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int topNumber = ceiling;
		int initialNumberMax = topNumber / 2;
		for (int y = 2; y < initialNumberMax ; y++)
		{
			int x = y;
			while (x <= topNumber)
			{
				x = x + y;
				if (!numbers.contains(x) && x <= topNumber)
				{
					numbers.add(x);
				}
			}
			x++;
		}
		Iterator itr = numbers.iterator();
		PriorityQueue q = new PriorityQueue();
		PriorityQueue q2 = new PriorityQueue();;
		while (itr.hasNext())
		{
			Object toAdd = itr.next();
			q.add(toAdd);
			q2.add(toAdd);
		}
		
		// For visibility purposes
		System.out.println();
		
		int primeCounter = 0, localCounter = 1;
		// Sanity Check
		for (int primeCheck = 2; primeCheck <= topNumber; primeCheck++)
		{
			if ( !q2.contains(primeCheck) )
			{
				System.out.print(primeCheck + " ");
				
				primeCounter++;
				localCounter++;
			}
			
			if (localCounter % 40 == 0)
			{
				System.out.println();
				localCounter++;
			}
			
		}
		System.out.println();
		System.out.println("There are " + primeCounter + " primes in the first " + topNumber + " numbers.");		
	}
}
