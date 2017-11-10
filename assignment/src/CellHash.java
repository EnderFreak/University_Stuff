
public class CellHash {
	private CellList[] hashArr;
	private static final int SIZE = 12;

	public CellHash( ){
		hashArr = new CellList[SIZE];
		for (int i=0; i < SIZE; i++)
		hashArr[i] = new CellList( );
	}
	
	private int computeHash(long  mn)
	{
		long hashValue = (mn/10000)+(mn%10000)/100+((mn%10000)%100);
		hashValue = hashValue % SIZE;
		return (int) hashValue;
	}
	
	public boolean contains(long nm)
	{
	
		int hashValue = computeHash(nm);
		
		CellList mlst = hashArr[hashValue];
		

	if(mlst.contains(nm))
		return true;
	return false;
}

	public void addToHash(Cellphone  nm)
	{
		long serial=nm.Getserialnum();
		int hashValue = computeHash(serial);
		CellList mlst = hashArr[hashValue];
		
		
		if(!mlst.contains(nm.Getserialnum()))
		{
			hashArr[hashValue].addToStart(nm);
		}
	}
	
	public void showHashTableContents()
	{
		//DISPLAYNG MSGS
		System.out.println("Here are the contents of the hash table: ");
		System.out.println("======================================== ");
		
		for (int i = 0; i < hashArr.length; i++)
		{
			System.out.println("\nList at index " + i + " has the following information: ");
			hashArr[i].showContents();
		}
		
	}
	
	public void findCell(long seri){
		// CALCULATING HAS VALUE
		int hashValue = computeHash(seri);
		//GET REQUIRED LOCATION
		CellList mlst = hashArr[hashValue];
		if(mlst.contains(seri)){
		System.out.println("The serial number is located at index " + hashValue);
		mlst.showContents();
		}
		else 
			System.out.println("this serial number is not included try another one");		
	}

}
