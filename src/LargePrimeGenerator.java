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
    Map<BigInteger,BigInteger> primeMultipleMax = new HashMap<BigInteger,BigInteger>();

    BigInteger lower = BigInteger.valueOf(2);
    BigInteger upper = BigInteger.valueOf(100);

    for ( ; lower.compareTo(limit) < 0 ; lower = upper)
    {
      upper = lower.add(BigInteger.valueOf(1000));
      if (upper.compareTo(limit) >= 0)
      {
        upper = limit;
      }

      if (primeMap.keySet().size() > 100)
        break;

      Iterator<BigInteger> primesIterator = primeMap.keySet().iterator();
      while (primesIterator.hasNext())
      {
        BigInteger prime = primesIterator.next();
        BigInteger lowerPrime = prime;
        BigInteger multiple = BigInteger.valueOf(1);

        //System.out.println("prime");
        //System.out.println(prime);

        for ( ; lowerPrime.compareTo(upper) < 0 ; )
        {
          lowerPrime = lowerPrime.add(prime);
          multiple = multiple.add(BigInteger.valueOf(1));
          if (notPrimeMap.get(lowerPrime) == null)
          {
            notPrimeMap.put(lowerPrime, (multiple + "," + lowerPrime));
          }
        }
      }

      int current_digit = Integer.parseInt(lower.toString().substring(lower.toString().length() - 1));
      current_digit--;
      BigInteger current = lower.subtract(BigInteger.valueOf(1));
      if (current.equals(BigInteger.valueOf(1)))
      {
        current_digit = 2;
        current = BigInteger.valueOf(2);
      }

      for( ; current.compareTo(upper) < 0 ; )
      {
        if (current_digit == 1 || current_digit == 3 || current_digit == 7 || current_digit == 9)
        {
          if (notPrimeMap.get(current) == null)
          {
            primeMap.put(current,current);
            System.out.println(current);
          }

          if (current_digit == 9)
          {
            current_digit = 1;
            current = current.add(BigInteger.valueOf(2));
          }
          else if (current_digit == 3)
          {
            current_digit = 7;
            current = current.add(BigInteger.valueOf(4));
          }
          else if (current_digit == 2 || current_digit == 5)
          {
            current_digit = 3;
            current = current.add(BigInteger.valueOf(1));
          }
          else if (current_digit == 5)
          {
            current_digit = 7;
            current = current.add(BigInteger.valueOf(2));
          }
          else
          {
            current_digit += 2;
            current = current.add(BigInteger.valueOf(2));
          }
        }
        else
        {
          if (current_digit == 2 && current.equals(BigInteger.valueOf(2)))
          {
            if (notPrimeMap.get(current) == null)
            {
              primeMap.put(current,current);
              primeMap.put(current.add(BigInteger.valueOf(1)),current.add(BigInteger.valueOf(1)));
              primeMap.put(current.add(BigInteger.valueOf(2)),current.add(BigInteger.valueOf(2)));
              System.out.println(current);
              System.out.println(3);
              System.out.println(5);
            }
            current_digit = 3;
            current = BigInteger.valueOf(3);
          }
          if (current_digit == 5 && current.equals(BigInteger.valueOf(5)))
          {
            System.out.println("We are in 5!!");
            if (notPrimeMap.get(current) == null)
            {
              primeMap.put(current,current);
              System.out.println(current);
            }
            current_digit = 7;
            current = BigInteger.valueOf(7);
          }
        }
      }
    }
  }
}
