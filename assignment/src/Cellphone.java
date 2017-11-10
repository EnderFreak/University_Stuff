//IMPORTING NECESSARY LIBRARY
import java.util.Scanner;

//CLONE METHOD
public class Cellphone implements Cloneable{
//VARIABLES THAT WILL BE USED
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	private Scanner key=new Scanner(System.in);
	
	//CONSTRUCTORS
	public Cellphone(long serialN,String br,double pri, int ye ){
		serialNum=serialN;
		brand=br;
		year=ye;
		price=pri;	
	}
	
	//COPY CONSTRUCTOR METHOD
	public Cellphone(Cellphone c,long serial){
		serialNum=serial;
		brand=c.brand;
		year=c.year;
		price=c.price;
	}
	
	//MUTATORS
	public long Getserialnum(){
		return serialNum;
	}
	
	public String Getbrand(){
		return brand;
	}
	
	public int Getyear(){
		return year;
	}
	
	public double Getprice(){
		return price;
	}
	
	//ACCESSORS
	public void Setserialnum(long ser){
		serialNum=ser;
	}
	
	public void setbrand(String b){
		brand=b;
	}
	
	public void setyear(int y){
		year=y;
	}
	
	public void setprice(double p){
		price=p;
	}
	
	//CLONE METHOD
	public Object clone(){
		try {
			System.out.println("Please enter the new Serial number");
			long a=key.nextLong();
			Cellphone copy=(Cellphone)super.clone();
			copy.Setserialnum(a);
			return copy;
			//CATCH
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	//TOSTRING METHOD
	public String toString(){
		return serialNum+" "+brand+" "+price+" "+year;
			
	}
	
	//TWO MOBILES CAN'T HAVE SOME SIMILAR ATTRIBUTES
	public boolean equals(Cellphone otherObject){
		boolean answ=false;
		if(this.getClass()!=otherObject.getClass())
			answ =false;
		else 
			if(this.brand.equals(otherObject.brand)
				&&this.price==otherObject.price&&this.year==otherObject.year)
			answ= true;
		else
			answ=false;
	
		return answ;
							
	}
}
