package a1_6344941;

import java.util.Scanner;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Random;
import java.util.LinkedList;
import java.lang.*;


public class Database {

	
	public static void initialize(int dataSize, int dataRange){
		Scanner input = new Scanner(System.in);
        
		System.out.println("What size the dataSize?: ");
		dataSize=input.nextInt();
		System.out.println(dataSize);
		
		System.out.println("What is the dataRange?: ");
		dataRange=input.nextInt();
		System.out.println(dataRange);
		
	
		
	}
	public static int randInt(int dataRange) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt(dataRange);

	    return randomNum;
	}
	public static int randAction() {

	    Random rand2 = new Random();
	    int randomAction = rand2.nextInt(2);

	    return randomAction;
	}
	public static TreeSet<Integer> treeadd;
	public static void bTree(int dataSize, int dataRange){
		treeadd = new TreeSet<Integer>();
	     int temp=0;
	      // adding in the tree set
		for(int i=0;i<dataSize;i++)
		{
			temp = randInt(dataRange);
	      treeadd.add(temp);
	      System.out.println("Added to tree "+ i); 
		}
	      // create ascending iterator
	      Iterator<Integer> iterator;
	      iterator = treeadd.iterator();
	     
	      // displaying the Tree set data
	      System.out.println("Initial Database: ");     
	      while (iterator.hasNext()){
	         System.out.println(iterator.next() + " ");
	      }	
	     
	}
	public static int dataSize=0,dataRange=0,taskCount=0,threadCount=0;
	public static Integer[][] taskArray;
	public static LinkedList<Integer> taskList = new LinkedList<Integer>();
	
	public static void initTaskCount(int dataSize,int dataRange,int taskCount,int threadCount){
		int addCount=0;
		taskArray= new Integer[taskCount][2];
		
		 for(int i = 0; i < taskCount; i++) {
			 taskList.add(i);
			 taskArray[i][0]=randAction();
			 if(taskArray[i][0]==0)
				 addCount++;
			 if(addCount>(taskCount/10))
			 {
			 taskArray[i][0]=1;
			 }
			     
		 taskArray[i][1]=randInt(dataRange);

		 }
		
		// create ascending iterator
	      Iterator<Integer> iterator;
	      iterator = taskList.iterator();
	     
	      // displaying the Tree set data
	      System.out.println("Tasks: "); 
	      int l=0;
	      while (iterator.hasNext()){
	    	  l=iterator.next();
	         System.out.print("Task "+l + ": ");
	         if(taskArray[l][0]==0)
	        	 System.out.println("add "+taskArray[l][1] + " ");
	         if(taskArray[l][0]==1)
	        	 System.out.println("find "+taskArray[l][1] + " ");
	      }	   
			  
//try for threads
	      threadCounts(threadCount,taskList,taskArray,dataRange,taskCount);

	}
	public static int next=0,ad=0;
	public static Iterator<Integer> it;
	synchronized public static int getTask(LinkedList<Integer> listThread)
	{
		
		it=taskList.iterator();
		ad=taskList.listIterator().next();
		
	
	
		return ad;
	}
	
	public static void threadCounts(int threadCount,LinkedList<Integer> taskList,Integer[][] taskArray,int dataRange,int taskCount){
		System.out.println(" ");
		
			TheadC[] threadC = new TheadC[threadCount];
			int next=0;
			for(int i=0; i< threadC.length ;i++)
			{
				threadC[i]= new TheadC(next,taskCount,taskList,taskArray);
				
			}
			
			for(int i=0; i< threadC.length ;i++)
			{
				
				threadC[i].start();
			}
			
			
				
				try {
					for(int i=0; i< threadC.length ;i++)
				threadC[i].join();}
				catch (InterruptedException e){} System.out.println(" ");
				 }
	

	public static void main(String[] args) {
		
Scanner input = new Scanner(System.in);
		System.out.println("Application parameters: ");
		System.out.println("dataSize: ");
		dataSize=input.nextInt();
		System.out.println(dataSize);
		
		System.out.println("dataRange: ");
		dataRange=input.nextInt();
		System.out.println(dataRange);
		
		System.out.println("threadCount: ");
		threadCount=input.nextInt();
		System.out.println(threadCount);
		
		System.out.println("taskCount: ");
		taskCount=input.nextInt();
		System.out.println(taskCount);
		
		
		//initialize(dataSize, dataRange);
		bTree(dataSize,dataRange);
		initTaskCount(dataSize,dataRange,taskCount,threadCount);
		
	}

}
