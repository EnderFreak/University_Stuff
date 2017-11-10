//importing libraries to be used
import java.util.*; 


/**
 * THAT THING FROM THE WEBSITE SHH
 * @author Cookie
 *
 */

public class Main {

/*	//GENERATING A RANDOM ACTION ADD/FIND
	public static Integer[][] taskArray;
	public static LinkedList<Integer> taskList = new LinkedList<Integer>();
	

	public static int AddFindRandom() {

		Random rand1 = new Random();
		int randomAction = rand1.nextInt(2);

		return randomAction;
	}
	//used for generating randomint
	public static int randInt(int dataRange) {

		Random rand = new Random();
		int randomNum = rand.nextInt(dataRange);

		return randomNum;
	}

	public static void initTaskCount(){

		int addCount=0;
		taskArray= new Integer[10][2];

		for(int i = 0; i < 10 ; i++) {
			taskList.add(i);
			taskArray[i][0]=AddFindRandom();
			if(taskArray[i][0]==0)
				addCount++;
			if(addCount>(10/10))
			{
				taskArray[i][0]=1;
			}
			taskArray[i][1]=randInt(100);
		}

		//Adjusting pointers
		Iterator<Integer> iterator;
		iterator = taskList.iterator();

		//Displaying the tasks list
		System.out.println("Tasks: "); 
		int l = 0;
		while (iterator.hasNext()){
			l = iterator.next();
			System.out.print("Task " + l + ": ");
			if(taskArray[l][0]==0)
				System.out.println("add "+taskArray[l][1] + " ");
			if(taskArray[l][0]==1)
				System.out.println("find "+taskArray[l][1] + " ");
		}	
	//}
	public static void main(String[] args){



		//Creating linked list for storing the numbers
		LinkedList num = new LinkedList();
		//Creating a new binary tree
		BinaryTree bst = new BinaryTree();
		for (int i = 0; i<15; i++){
			int elem = (int)(Math.random()*100)+1;
			bst.insert(elem);
			num.add(elem); //adding the number to the linked list
			//TEST System.out.println(num);
		}

		
		//Adjusting pointers
		Iterator<Integer> iterator;
		iterator = taskList.iterator();
		
		//Displaying the tasks list
		System.out.println("Tasks: "); 
		int l = 0;
		while (iterator.hasNext()){
			l = iterator.next();

			System.out.print("Task " + l + ": ");
			if(taskArray[l][0]==0)
				System.out.println("add "+taskArray[l][1] + " ");
			if(taskArray[l][0]==1)
				System.out.println("find "+taskArray[l][1] + " ");
		}	

		//Creating linked list for storing numbers in tasks
		LinkedList tasks = new LinkedList();
		for (int i = 0; i <=15; i++){
			int tasknum = (int)(Math.random()*100)+1;
			tasks.add(tasknum);//adding the number to linked list
			System.out.println("Task " + i + ": " + taskArray[l][l]+ tasknum);
		}

*/




		//Outputting the debug output stuff
		//*******THE "" BELOW SHOULD BE REMOVED-SERIOUS,SHOULD BE IN PROGRAM*******
		//System.out.println("Application parameters: \n dataSize: " + num.size() + "\n dataRange: 100 \n "
		//+ "threadCount: not yet \n taskCount: " + tasks.size());
		//Displaying the initial database
		System.out.println("Initial Database:");
		bst.printInorder();
	}
}
