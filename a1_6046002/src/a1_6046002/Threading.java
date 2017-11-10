package a1_6046002;

//Importing the libraries
import java.util.*;
//Threading part
public class Threading extends Thread{

	public static int next;
	public int taskCount;
	public static LinkedList<Integer> threadList;
	public Integer[][] ArrayOfTaskThread;
	public TreeSet<Integer> addTreeThread;
	public Iterator<Integer> iterate;

	public Threading(int tid, int taskCount,LinkedList<Integer> threadList,Integer[][] ArrayOfTaskThread)
	{  
		this.next = tid; 
		this.taskCount =taskCount;
		this.threadList= threadList;
		this.ArrayOfTaskThread =ArrayOfTaskThread;
		this.addTreeThread=Main.addtree ;
		this.iterate = threadList.iterator();

	}
	//Adding threads to the thread pool / running threads
	public void run()
	{
		System.out.println(Thread.currentThread().getName() +
				" added to the Thread Pool...");


		int a, s = threadList.size();
		while(s > 0)
		{
			a= Main.getTask(threadList);

			Iterator<Integer> n;
			n = threadList.iterator();

			if(ArrayOfTaskThread[a][0] == 0)
			{

				this.addTreeThread.add(ArrayOfTaskThread[a][a]);
				System.out.println("[Task "+ a +"] " +Thread.currentThread().getName() +
						" added "+ArrayOfTaskThread[a][a]+" to the data set");

				Main.listOfTask.remove(Main.listOfTask.indexOf(a));

				s--;
			}
			//If it's an add
			if(ArrayOfTaskThread[a][0]==1)
			{
				//If found
				if(this.addTreeThread.contains(ArrayOfTaskThread[a][a]))
					System.out.println("[Task "+ a +"] " +Thread.currentThread().getName() +
							" found "+ArrayOfTaskThread[a][a]+" in the data set");
				else //If not found
				{
					System.out.println("[Task "+ a +"] " +Thread.currentThread().getName() +
							" did not find "+ArrayOfTaskThread[a][a]+" in the data set");
				}

				Main.listOfTask.remove(Main.listOfTask.indexOf(a));
				s--;
			}
		}
		//Ending the thread
		System.out.println(Thread.currentThread().getName() + " is terminating");
	}
}