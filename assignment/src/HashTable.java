import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HashTable{

	
	public static void main(String[] args)throws IOException {
		Scanner kb = new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		// Create an empty list
		CellHash h = new CellHash();
		
		 try{
	            kb = new Scanner(new FileInputStream("Cell_Info.txt"));
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("File not found. Terminating program.");
	            System.exit(0);
	        }

	        while (kb.hasNextLine()) {
	            long serial = 0;
	            String brand = null;
	            int year = 0; 
	            boolean duplicate=false;
	            double price = 0;
	    

	            try {
	            serial = kb.nextLong();
	            brand = kb.next();
	            price = kb.nextDouble();
	            year = kb.nextInt();
	            Cellphone y = new Cellphone(serial, brand, price, year);
	            h.addToHash(y);
	            } catch (InputMismatchException e) 
	            {
	            kb.close();
	            
	            System.out.print("The input file is malformed.");
	            System.exit(0);
	            }
	  
	    }

		h.showHashTableContents();
		System.out.println("Please enter the serial number to search for and enter 1 to quit");
		long serai=s.nextLong();
		while(serai!=1){
		h.findCell(serai);
		System.out.println("Please enter the serial number to search for and enter 1 to quit");
		serai=s.nextLong();
		}
		
		System.out.println("\nThanks for using our Hash Table. Goodbye.");
	}

	
}
 
