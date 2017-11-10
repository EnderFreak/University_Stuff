//IMPORTING NECESSARY LIBRARIES
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CellListdemo {
    
    public static void main(String [] arg)throws IOException{
        
        CellList empt1 = new CellList();
        CellList empt2 = new CellList();
        Scanner file = null;
        Scanner key1 =new Scanner (System.in);
        int created=0;
        
        try{
            file = new Scanner(new FileInputStream("Cell_Info.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Terminating program.");
            System.exit(0);
        }
        
        
        while (file.hasNextLine()) {
            long serial = 0;
            String brand = null;
            int year = 0; 
            boolean duplicate=false;
            double price = 0;
    

            try {
            serial = file.nextLong();
            brand = file.next();
            price = file.nextDouble();
            year = file.nextInt();
            Cellphone y = new Cellphone(serial, brand, price, year);
            duplicate=empt1.finduplicate(y.Getserialnum());
            if(duplicate!=true)
            {
            	empt1.addToStart(y);
            	created++;
            }

            //IF CAN'T DO
            } catch (InputMismatchException e) {
            file.close();
            
            System.out.print("The input file is malformed.");
            System.exit(0);
            }
  
    }
        //MSGS DISPLAY
        System.out.println("The current size of the list "+empt1.getSize()+". Here are the contentsof the list");
        empt1.showContents();
        System.out.println("Please enter the serial number you would like to search: enter a letter to quit");
        boolean except=false;
        while(except==false){
        try{
            Long Search=key1.nextLong();
           empt1.find(Search);
           System.out.println("Please enter the serial number you would like to search: enter a letter to quit");
        }catch (InputMismatchException e){
       System.out.println("quitting" );
       except=true;
        }
        }

        Cellphone o = new Cellphone(11194321, "SonyEricsson", 347.94, 2009);
        empt1.insertAtIndex( o, 3);
        empt1.addToStart(o);
        empt1.contains(11194321);
        empt1.deleteFromIndex(3);
        empt1.deleteFromStart();
        empt1.showContents();
   
    }

}
