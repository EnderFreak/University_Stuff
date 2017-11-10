import java.util.ArrayList;


public class HeapTest
{
	public static void main(String[] args)
	{
		ArrayList<Character> AL = new ArrayList<Character>();
		AL.add(0, 'a');
		AL.add(1, 'b');
		AL.add(2, 'a');
		
		for (Character e : AL)
		{
			System.out.println(e.charValue());
		}
		
	}
}
