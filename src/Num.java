
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
		for(int x = 0; x < stringLength; x++)
		{
			Integer ab = Integer.parseInt(String.valueOf(value.charAt(x)));
			Integer bc = Integer.parseInt(String.valueOf(addend.charAt(x)));
//			System.out.println("ab: " + ab + " bc: " + bc);
			if (ab + bc > 8 && hasCarryOver)
			{
				System.out.println("HIT: 1");
				sum = ab + bc + 1;
				System.out.println("	Val Before: " + val());
				System.out.println("1" + val());
				setValue("1" + val());
				System.out.println("	Val After: " + val());
				hasCarryOver = true;
			}
			else if (ab + bc > 9 && !hasCarryOver)
			{
				System.out.println("HIT: 2");
				sum = ab + bc;
				hasCarryOver = true;
			}
			else if (hasCarryOver)
			{
				System.out.println("HIT: 3");
				sum = ab + bc + 1;
				System.out.println("	Val Before: " + val());
				System.out.println("1" + val());
				setValue("1" + val());
				System.out.println("	Val After: " + val());
				hasCarryOver = false;
			}
			else
			{
				System.out.println("HIT: 4");
				sum = ab + bc;
				hasCarryOver = false;
			}
			System.out.println("Value before: " + val());
			System.out.println("sum is: " + sum);
			StringBuilder test = new StringBuilder(value);
			System.out.println("Value: " + test);
			test.setCharAt(x, sum.toString().charAt(sum.toString().length() - 1));
			setValue(test.toString());
		}
		if (hasCarryOver)
		{
		//	setValue("1" + val());
		}
		System.out.println("newValue: " + val());
	}
	
	public void add(Num add)
	{
		add(add.val());
	}
	
}
