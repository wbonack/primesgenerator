import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class BigPrimeGenerator {

	public class BigPrime
	{
		public BigInteger value;
		public ArrayList<BigInteger> factors;
		public BigPrime(BigInteger value, BigInteger factor)
		{
			this.value = value;
			factors = new ArrayList<BigInteger>();
			factors.add(factor);
		}

		public void addFactor(BigInteger factor)
		{
			factors.add(factor);
		}
	}
	public void generatePrimes()
	{
		BigInteger limit = BigInteger.valueOf(11000000);
		System.out.println("Integer Long: " + Integer.MAX_VALUE);
		Map<BigInteger,BigPrime> notPrimeMap = new HashMap<BigInteger,BigPrime>();
		Map<BigInteger,BigInteger> primeMap = new HashMap<BigInteger,BigInteger>();
		BigInteger counter = BigInteger.valueOf(2);
		BigInteger multiple = counter;


		long initialTime = System.currentTimeMillis();
		int otherCounter = 0;

		BigInteger checkPoint = limit.divide(BigInteger.valueOf(100)); 
		for (BigInteger x = BigInteger.valueOf(0);  x.compareTo(limit) <= 0; x = x.add(BigInteger.valueOf(1)))
		{
			counter = multiple;
			if (!notPrimeMap.containsKey(counter))
			{
				primeMap.put(counter, counter);
				for (BigInteger y = counter; y.compareTo(limit) <= 0; 
					y = y.add(multiple) )
				{
				//System.out.println(y);
					if (!notPrimeMap.containsKey(y))
					{
						notPrimeMap.put(y, new BigPrime(y,multiple));
					}
					else
					{
						notPrimeMap.get(y).factors.add(multiple);
					}
				}
			}
			


			multiple = multiple.add(BigInteger.ONE);
			if (++otherCounter == 1000)
			{
				otherCounter = 0;
				System.out.println("Progress: " + x.divide(checkPoint));
			}
		}

		//System.out.println("Primes:");
		int primeCounter = 0;
		int largestPrime = 0;
		for (BigInteger x = BigInteger.valueOf(2); x.compareTo(limit) <= 0; x = x.add(BigInteger.ONE) )
		{
			if (primeMap.containsKey(x))
			{
				//System.out.println("Prime: " + x);
				largestPrime = x.intValue();
				primeCounter++;
			}
			else
			{
				//System.out.println(x);
				//for(BigInteger factor : notPrimeMap.get(x).factors)
				{
				//	System.out.print(factor + ",");
				}
				//System.out.println();
			}
		}

		System.out.println("Largest prime: " + largestPrime);
		System.out.println("PrimeCounter: " + primeCounter);
		
		System.out.println("It tooks " + ((System.currentTimeMillis() - initialTime) / 1000) + " seconds.");
		
	}

}
