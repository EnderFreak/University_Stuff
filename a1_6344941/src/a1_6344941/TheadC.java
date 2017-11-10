package a1_6344941;
import java.lang.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Random;
import java.util.LinkedList;

public class TheadC extends Thread{

	public static int next;
	public int taskCount;
	public static LinkedList<Integer> listThread;
	public Integer[][] taskArrayThread;
	public TreeSet<Integer> treeaddThread;
	public Iterator<Integer> iter;

	public TheadC(int tid, int taskCount,LinkedList<Integer> listThread,Integer[][] taskArrayThread)
	{  
		this.next = tid; 
		this.taskCount =taskCount;
		this.listThread= listThread;
		this.taskArrayThread =taskArrayThread;
		this.treeaddThread=Database.treeadd ;
		this.iter = listThread.iterator();

	}




	public void run()
	{
		System.out.println(Thread.currentThread().getName() +
				" added to the Thread Pool...");


		int l,s=listThread.size();
		while(s>0)
		{
			l= Database.getTask(listThread);
			//System.out.println("l: getTask:: " + l);
			Iterator<Integer> n;

			n=listThread.iterator();



			if(taskArrayThread[l][0]==0)
			{

				this.treeaddThread.add(taskArrayThread[l][1]);
				System.out.println("[Task "+ l +"] " +Thread.currentThread().getName() +
						" added "+taskArrayThread[l][1]+" to the data set");

				Database.taskList.remove(Database.taskList.indexOf(l));

				s--;



			}
			if(taskArrayThread[l][0]==1)
			{

				if(this.treeaddThread.contains(taskArrayThread[l][1]))
					System.out.println("[Task "+ l +"] " +Thread.currentThread().getName() +
							" found "+taskArrayThread[l][1]+" in the data set");
				else
				{
					System.out.println("[Task "+ l +"] " +Thread.currentThread().getName() +
							" did not find "+taskArrayThread[l][1]+" in the data set");
				}

				Database.taskList.remove(Database.taskList.indexOf(l));
				s--;

			}

		}

		System.out.println(Thread.currentThread().getName() + " is terminating");
	}
}