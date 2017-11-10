package a1_6046002;
/**
 * @author Kirti Joyejob
 * Student ID: 6046002
 * COMP 346 Operating Systems Assignment 1
 * Due 23 July 2014 at 00:00
 */

//Importing the library
import java.util.*;

public class Main {

	//Generating random numbers
	public static int RandomInteger (int dataRange) {

		Random rand = new Random();
		int randomNum = rand.nextInt(dataRange);
		return randomNum;
	}

	//Those add/find actions being random
	public static int AddFindAction() {

		Random rand = new Random();
		int randomAction = rand.nextInt(2);
		return randomAction;
	}
	//Creating the binary tree
	public static TreeSet<Integer> addtree;
	public static void binaryTree(int dataSize, int dataRange){
		addtree = new TreeSet<Integer>();
		int temp = 0;

		//Adding numbers to tree
		for(int i=0;i<dataSize;i++)
		{
			temp = RandomInteger(dataRange);
			addtree.add(temp);
			System.out.println("Added to tree "+ i); 
		}

		//Adjusting the pointers
		Iterator<Integer> iterator;
		iterator = addtree.iterator();

		//Outputting the initial database
		System.out.println("Initial Database: ");     
		while (iterator.hasNext()){
			System.out.println(iterator.next() + " ");
		}	
	}

	public static int dataSize=0,dataRange=0,taskCount=0,threadCount=0;
	public static Integer[][] arrayOfTask;
	public static LinkedList<Integer> listOfTask = new LinkedList<Integer>();

	//90% searches, 10% adds math
	public static void initTaskCount(int dataSize,int dataRange,int taskCount,int threadCount){
		int taskAddCount=0;
		arrayOfTask= new Integer[taskCount][2];

		for(int i = 0; i < taskCount; i++) {
			listOfTask.add(i);
			arrayOfTask[i][0]=AddFindAction();
			if(arrayOfTask[i][0]==0)
				taskAddCount++;
			if(taskAddCount>(taskCount/10))
			{
				arrayOfTask[i][0]=1;
			}

			arrayOfTask[i][1]=RandomInteger(dataRange);

		}

		//Iterating through the list of task
		Iterator<Integer> iterator;
		iterator = listOfTask.iterator();

		//Displaying the list of tasks - DOESNT WORK - GOTTA FIX
		System.out.println("Tasks: "); 
		int taskNumber = 0;
		while (iterator.hasNext()){
			taskNumber = iterator.next();
			System.out.print("Task "+ taskNumber + ": ");
			if(arrayOfTask[taskNumber][0]==0)
				System.out.println("add "+arrayOfTask[taskNumber][taskNumber] + " ");
			if(arrayOfTask[taskNumber][0]==1)
				System.out.println("find "+arrayOfTask[taskNumber][taskNumber] + " ");
		}	   

		//The thread counts
		threadCounts(threadCount,listOfTask,arrayOfTask,dataRange,taskCount);

	}
	public static int next = 0, nextIt = 0;
	public static Iterator<Integer> it;

	//synchronizing the list
	synchronized public static int getTask(LinkedList<Integer> listThread)
	{

		it = listOfTask.iterator();
		nextIt = listOfTask.listIterator().next();
		return nextIt;
	}
	//starting the thread
	public static void threadCounts(int threadCount,LinkedList<Integer> listOfTask,Integer[][] arrayOfTask,int dataRange,int taskCount){
		System.out.println(" ");

		Threading[] threadd = new Threading[threadCount];
		int next=0;
		for(int i=0; i< threadd.length ;i++)
		{
			threadd[i]= new Threading(next,taskCount,listOfTask,arrayOfTask);

		}

		for(int i=0; i< threadd.length ;i++)
		{

			threadd[i].start();
		}



		try {
			for(int i=0; i< threadd.length ;i++)
				threadd[i].join();}
		catch (InterruptedException e){} System.out.println(" ");
	}


	public static void main(String[] args) {
		int dataSize = 12;
		int dataRange = 20;
		int threadCount = 3;
		int taskCount = 20;


		//initialize(dataSize, dataRange);
		binaryTree(dataSize,dataRange);
		initTaskCount(dataSize,dataRange,taskCount,threadCount);

	}

}
