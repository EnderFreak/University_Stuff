// Elem.java
// Elem interface. This is just an Object with support for a key field.
interface Elem 
{ // Interface for generic element type
	public abstract int getkey(); // Key used for search and ordering
} // interface Elem
// IElem.java
// Sample implementation for Elem interface: a record w/ just an int field

public class IElem implements Elem 
{

	private int value;
	
	public IElem(int v) 
	{ 
		value = v;
	}
	public IElem()
	{
		value = 0;
	}
	public int getkey() 
	{ 
		return value; 
	}
	public void setkey(int v)
	{ 
		value = v; 
	}
	public String toString() 
	{ // Override Object.toString
		return Integer.toString(value);
	}
}