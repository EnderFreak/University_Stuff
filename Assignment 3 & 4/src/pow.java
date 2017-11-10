
public class pow 
{

	
	public static void main(String[] args) 
	{
		System.out.println(pow(0,2));
	}
	static int tot = 0;

	public static int pow(int x, int y)
	{
		if ( x == 0)
		{
			return 0;
		}
		if (y == 0)
		{
			tot = 1;
			return tot;
			
		}
		else
		{
			tot = x * pow(x, y - 1);
				return tot;
		}
	}
}
