
public class Num {
	private String value;
	
	public Num()
	{
		value = "0";
	}
	
	public Num(String newValue)
	{
		value = newValue;
	}
	
	public Num(Num num)
	{
		value = num.val();
	}
	
	public String val()
	{
		return value;
	}
	
	public void setValue(String newValue)
	{
		value = newValue;
	}
	
	public void add(String addend)
	{
	  int stringLength = value.length();
		boolean hasCarryOver = false;
		Integer sum = 0;
//		System.out.println("String length is: " + stringLength);
		StringBuilder test = new StringBuilder(value);
		
		for(int charCounter = 0; charCounter < stringLength; charCounter++)
		{
		  if ((value.length() - 1 - charCounter) >  (addend.length() - 1 - charCounter))
      {
        addend = "0" + addend;
      }
//		  System.out.println("value position: " + (value.length() - 1 - charCounter) +
//		      "\naddend position: " + (addend.length() - 1 - charCounter));
			Integer ab = Integer.parseInt(String.valueOf(value.charAt(value.length() - 1 - charCounter)));
			Integer bc = Integer.parseInt(String.valueOf(addend.charAt(addend.length() - 1 - charCounter)));
			//	System.out.println("First integer: " + ab + " Second integer: " + bc);
			if (ab + bc > 8 && hasCarryOver)
			{
//			  System.out.println("Hit 1st condition");
				sum = ab + bc + 1;
				//		System.out.println("	Val Before: " + val());
  			//	System.out.println("1" + val());
  			setValue("1" + val());
  			//	System.out.println("	Val After: " + val());
				hasCarryOver = true;
			}
			else if (ab + bc > 9 && !hasCarryOver)
			{
//			  System.out.println("Hit: 2");
				sum = ab + bc;
				hasCarryOver = true;
			}
			else if (hasCarryOver)
			{
			//  System.out.println("Hit 3rd condition");
				sum = ab + bc + 1;
				//	System.out.println("	Val Before: " + val());
				//	System.out.println("1" + val());
				setValue("1" + val());
				//	System.out.println("	Val After: " + val());
				hasCarryOver = false;
			}
			else
			{
//			  System.out.println("Hit 4th condition");
				sum = ab + bc;
				hasCarryOver = false;
			}
			// System.out.println("Value before: " + val());
//			System.out.println("sum.toString().charAt(sum.toString().length() - 1: " + (sum.toString().charAt(sum.toString().length() - 1)));
			test.setCharAt(test.length() - 1 - charCounter, sum.toString().charAt(sum.toString().length() - 1));
			setValue(test.toString());
			if (hasCarryOver)
			{ 
			  StringBuilder newTest = new StringBuilder("1" + test);
			  test = newTest;
			}
			setValue(test.toString());
			System.out.println("value is: " + value);
		}
	}
	
	public void add(Num add)
	{
		add(add.val());
	}
	
}
