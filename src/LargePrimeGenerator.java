import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

class LargePrimeGenerator
{

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

  public LargePrimeGenerator()
  {
    BigInteger limit = BigInteger.valueOf(110000000);
    System.out.println("Integer Long: " + Integer.MAX_VALUE);
    Map<BigInteger,String> notPrimeMap = new HashMap<BigInteger,String>();
    Map<BigInteger,BigInteger> primeMap = new HashMap<BigInteger,BigInteger>();

    BigInteger lower = BigInteger.valueOf(2);
    BigInteger upper = BigInteger.valueOf(10000);

    // Only do iterations of 10000 for clarity
    for ( ; lower.compareTo(limit) < 0 ; lower = lower.multiply(BigInteger.valueOf(2)) )
    {
      upper = lower.multiply(BigInteger.valueOf(2));
      if (upper.compareTo(limit) >= 0)
      {
        upper = limit;
      }

      System.out.println("lower");
      System.out.println(lower);

      System.out.println("upper");
      System.out.println(upper);

      Iterator<BigInteger> primesIterator = primeMap.keySet().iterator();
      while (primesIterator.hasNext())
      {
        BigInteger prime = primesIterator.next();
        System.out.println("prime");
        System.out.println(prime);
        BigInteger lowerPrime = prime;
        for ( BigInteger multiple = BigInteger.valueOf(1) ; lowerPrime.compareTo(upper) < 0 ; multiple = multiple.add(BigInteger.valueOf(1)) )
        {
          System.out.println(lowerPrime);
          lowerPrime = lowerPrime.add(prime);
          if (multiple.compareTo(BigInteger.valueOf(1)) > 0)
            notPrimeMap.put(lowerPrime, (multiple + "," + lowerPrime));
        }
      }

      int current_digit = 3;
      for( BigInteger current = BigInteger.valueOf(3) ; current.compareTo(upper) < 0 ; )
      {
        if (current_digit == 1 || current_digit == 3 || current_digit == 7 || current_digit == 9)
        {
          notPrimeMap.get(current);

          if (current_digit == 9)
          {
            current_digit = 1;
            current = current.add(BigInteger.valueOf(2));
          }
          else if (current_digit == 3)
          {
            current_digit = 1;
            current = current.add(BigInteger.valueOf(4));
          }
          else
          {
            current_digit += 2;
            current = current.add(BigInteger.valueOf(2));
          }
        }
        else
        {

          System.out.println("Something is fucked up.");
        }
      }
    }
  }
}
