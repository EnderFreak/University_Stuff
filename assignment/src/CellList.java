//IMPORT LIBRARY
import java.util.NoSuchElementException;


class CellList
{
    
     class CellNode{
        private Cellphone phone;
        private CellNode next;
        
        public CellNode(){
            phone = null;
            next = null;
            
        }
        //PARAMETRISED CONSTRUCTOR
        public CellNode(Cellphone phone1, CellNode node){
            phone = phone1;
            next = node;
            
        }
        
        public void setCellPhone(Cellphone p){
            phone = p;
        }
        
        public void setNext(CellNode nod){
            next = nod;
        }
        
        public Cellphone getCellPhone(){
            return phone;
        }
        
        public CellNode getCellNode(){
            return next;
        }
        
        //COPY CONSTRUCTOR
        public CellNode newInstance(CellNode ph, CellNode no){
            if(no == null) throw new NullPointerException();
            if(ph == null) throw new NullPointerException();
            return new CellNode(ph.getCellPhone(), no.getCellNode());
            
        }
        
        public Object clone(){
            try {
                CellNode copy = (CellNode)super.clone();
                return copy;
            } catch (CloneNotSupportedException e) {
                
                e.printStackTrace();
            return null;
            }                        
        }
        public String toString(){
    		return phone.Getserialnum()+" "+phone.Getbrand()+""+phone.Getprice()+""+phone.Getyear();		
    	}
    	
    }
  
    
    private CellNode head;
    private int size;
    
    public CellList(){
        head = null;
    }
    
    //COPY CONSTRUCTOR
    public CellList(CellList l){
        if(l == null) throw new NullPointerException();
        if (l.head == null)
            head = null;
        else
        {
            head = null;
            CellNode temp, temp2, temp3;
            temp = l.head;
            temp2 = null;
            temp3 = null;
            
            
            while(temp != null)
            {
                if (temp2 == null)    
                {
                    temp2 = new CellNode(temp.getCellPhone(), null);
                    head = temp2;
                }
                else
                {
                    temp3 = new CellNode(temp.getCellPhone(), null);
                    temp2.setNext(temp3);
                    temp2 = temp3;
                }
                
                temp = temp.getCellNode();
            }
            //INITIALISATION
            temp = temp2 = temp3 = null;
        }
    }

    public void addToStart(Cellphone phone){
        head = new CellNode(phone, head);
        size++;
    }
    
    public void insertAtIndex(Cellphone ph, int index){
        try{
            if(index < 0 && index > (size-1))
            throw new NoSuchElementException();}
        catch(NoSuchElementException e){
            System.exit(0);
        }
        
        int i = 0;
        CellNode temp = head;
                
        if (index == 0)
        {
            CellNode newNode = new CellNode(ph, head);//was head before
            head = newNode;
            newNode = null;
            return;
        }
        else
        {
        	while(i != index-1)
            {
                temp = temp.next;
                i++;
            }
         
            CellNode newNode = new CellNode(ph, temp.next); 
            temp.next = newNode;
            newNode=null;
        }
        size++;
    }
    
    public void deleteFromIndex(int index){
        
        try{
        	if( index > size-1 )
            throw new NoSuchElementException();            
        }catch(NoSuchElementException e){
            System.out.println("Index out of range. end of  program.");
        System.exit(0);
        }
    int n = 0;
    CellNode temp = head;
    if (index == 0)
	{
		head = temp.next;
		size--;
		return;
	}
    
    if(index ==1){
        head.next =temp.next.next;
        size--;
        return;
        }
   	
    else 
		{
    	while(n != index-1){
            temp = temp.next;
            n++;
        }
        temp.next = temp.next.next;
        temp = temp.next;
    }
        size--;
    
    }   
    public void deleteFromStart(){
        if (head != null)
        {
            head = head.getCellNode();        
        }
                
    }
    
    public void replaceAtIndex(Cellphone p, int index){
        if(index < 0 && index > (size-1) )
            return;
        int m = 0;
        CellNode temp = head;
        while(m != index)
        {
            temp = temp.getCellNode();
            m++;
        }
        
        temp.setCellPhone(p);
    }
    
    public void  find(long serial)
    {
    	boolean found=false;
        CellNode position = head;
        Long search;
        int count = 0;
        while (position != null)
        {
            search = position.phone.Getserialnum();
            count++;
            if (search.equals(serial)){
                System.out.println("the serial was found after "+ count+" search and the information is "+ position);
                found=true;
            }
            position = position.next;
        }
        if (found==false)
        System.out.println("no input with that serial number");//target was not found
    }
   public boolean contains(long serial){
    CellNode position = head;
    Long search;
    while(position != null){
        search = position.phone.Getserialnum();
        if (search.equals(serial))            
            return true;
        position = position.next;
    }
    return false;
}
    public void showContents(){
            CellNode temp = head;
            if (temp == null)
                System.out.println("There is nothing to display; list is empty." );
            else
                System.out.println("Here are the contents of the list." );
            while(temp != null)
            {
                System.out.println("["+ temp.phone + "] ---> ");
                temp = temp.next;        
            }
            System.out.println("X");    

    }
   
    public int getSize()
    {
        return size;
    }
 
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            CellList otherList = (CellList)otherObject;
            if (getSize( ) != otherList.getSize( ))
                return false;
            CellNode position = head;
            CellNode otherPosition = otherList.head;
            while (position != null)
            {
                if ( (!(position.phone.equals(otherPosition.phone))))
                   return false;
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true; //MATCH FOUND
        }
    }
    public boolean finduplicate(long serial){
        CellNode position = head;
        Long search;
        while(position != null){
            search = position.phone.Getserialnum();
            if (search.equals(serial))            
                return true;
            position = position.next;
        }
        return false;
    }
}
