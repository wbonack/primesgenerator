import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LargePrimeGenerator
{

  public class RedisPrimes
  {
    String classType;
    public RedisPrimes(String type)
    {
      classType = type;
    }
    public void put(BigInteger key, String value)
    {
      try {
        String result = LargePrimeGenerator.execCmd("redis-cli set " + classType + ":" + key  + " " + value);
      }
      catch (Exception e)
      {

        //System.out.println(e);
      }
    }

    public void put(BigInteger key, BigInteger value)
    {
      try {
        String result = LargePrimeGenerator.execCmd("redis-cli set " + classType + ":" + key  + " " + value);

        if (result == "OK")
        {
          System.out.println("Ran successfully");
        }
      }
      catch (Exception e)
      {

        //System.out.println(e);
      }
    }

    public String get(BigInteger key)
    {
      String result;
      try {
         result = LargePrimeGenerator.execCmd("redis-cli get " + classType + ":" + key);
         System.out.println(result);
      }
      catch (Exception e)
      {

        return "There was an error";

      }
      if (result == "null" || result == null)
      {
        return null;
      }
      else
      {
        return result;
      }
    }
  }

  public LargePrimeGenerator()
  {
    BigInteger limit = BigInteger.valueOf(110000000);
    System.out.println("Integer Long: " + Integer.MAX_VALUE);
    //Map<BigInteger,String> notPrimeMap = new HashMap<BigInteger,String>();
    Map<BigInteger,BigInteger> primeMap = new HashMap<BigInteger,BigInteger>();
    RedisPrimes notPrimeMap = new RedisPrimes("composite");
    RedisPrimes redisPrimeMap = new RedisPrimes("prime");

    BigInteger lower = BigInteger.valueOf(2);
    BigInteger upper = BigInteger.valueOf(100);

    for ( ; lower.compareTo(limit) < 0 ; lower = upper)
    {
      upper = lower.multiply(BigInteger.valueOf(2));
      if (upper.compareTo(limit) >= 0)
      {
        upper = limit;
      }

      Iterator<BigInteger> primesIterator = primeMap.keySet().iterator();
      while (primesIterator.hasNext())
      {
        BigInteger prime = primesIterator.next();
        BigInteger lowerPrime = prime;
        BigInteger multiple = BigInteger.valueOf(1);

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
        if (current_digit == 1 || (current_digit == 3 && !current.equals(BigInteger.valueOf(3))) || current_digit == 7 || current_digit == 9)
        {
          System.out.println("notPrimeMap");
          System.out.println(notPrimeMap.get(current));
          System.out.println("redisPrimeMap");
          System.out.println(redisPrimeMap.get(current) );

          if (notPrimeMap.get(current) == null || redisPrimeMap.get(current) == null )
          {
            primeMap.put(current,current);
            redisPrimeMap.put(current, current);
            //System.out.println(current);
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
          else if (current_digit == 7)
          {
            current_digit = 9;
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
            if (notPrimeMap.get(current) == null && redisPrimeMap.get(current) == null )
            {
              primeMap.put(current,current);
              redisPrimeMap.put(current, current);
              //System.out.println(current);
            }
            current_digit = 3;
            current = BigInteger.valueOf(3);
          }
          if (current_digit == 3 && current.equals(BigInteger.valueOf(3)))
          {
            if (notPrimeMap.get(current) == null && redisPrimeMap.get(current) == null )
            {
              primeMap.put(current,current);
              redisPrimeMap.put(current, current);
              //System.out.println(current);
            }
            current_digit = 5;
            current = BigInteger.valueOf(5);
          }
          if (current_digit == 5)
          {
            if (current.equals(BigInteger.valueOf(5)))
            {
              if (notPrimeMap.get(current) == null && redisPrimeMap.get(current) == null )
              {
                primeMap.put(current,current);
                redisPrimeMap.put(current, current);
                //System.out.println(current);
              }
              current_digit = 9;
              current = BigInteger.valueOf(9);
            }
            else
            {
              current_digit = 7;
              current = current.add(BigInteger.valueOf(2));
            }
          }
        }
      }
    }

  }

  public static String execCmd(String cmd) throws java.io.IOException {
    //java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
    //return s.hasNext() ? s.next() : "";
    Runtime rt = Runtime.getRuntime();
    String[] commands = {"system.exe","-get t"};
    //System.out.println(cmd);
    Process proc = rt.exec(cmd);
    try {
    proc.waitFor();
    }
    catch (Exception e)
    {

    }

    BufferedReader stdInput = new BufferedReader(new 
        InputStreamReader(proc.getInputStream()));

    BufferedReader stdError = new BufferedReader(new 
        InputStreamReader(proc.getErrorStream()));

    // read the output from the command
    //System.out.println("Here is the standard output of the command:\n");
    String s = null;
    while ((s = stdInput.readLine()) != null) {
      //System.out.println(s);
    }

    // read any errors from the attempted command
    //System.out.println("Here is the standard error of the command (if any):\n");
    while ((s = stdError.readLine()) != null) {
      //System.out.println(s);
    }
    return s;
  }
}
