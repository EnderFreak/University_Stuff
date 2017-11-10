import java.util.*;
// A bunch of utility functions.
public class DSutil
{
	// Swap two objects in an array
	public static void swap(Object[] array, int p1, int p2) 
	{
		Object temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	// Randomly permute the Objects in an array
	static void permute(Object[] A) 
	{
		for (int i = A.length; i > 0; i--) // for each i
			swap(A, i-1, DSutil.random(i)); // swap A[i-1] with
	} // a random element
	// Create a random number function to return values
	// uniformly distributed within the range 0 to n-1.
	static private Random value = new Random();// Random class object
	static int random(int n) 
	{ // My own function
		return Math.abs(value.nextInt()) % n;
	}
}
