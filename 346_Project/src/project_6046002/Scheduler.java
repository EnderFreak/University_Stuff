package project_6046002;

//dont know if should include, here, just in case
//import java.util.*;

public class Scheduler extends Thread{

	private CircularList queue;
	private int timeSlice;
	private static final int DEFAULT_TIME_SLICE = 1000; //1 second

	public Scheduler(){
		timeSlice = DEFAULT_TIME_SLICE;
		queue = new CircularList();
	}
	//Time quantum saved in linked list
	public Scheduler(int quantum){
		timeSlice = quantum;
		queue = new CircularList();
	}

	//Adding a thread to the queue
	public void addThread(Thread t){
		queue.addItem(t);   
	}

	//Puts the scheduler to sleep for a time slice
	private void schedulerSleep(){
		try{ //Try work()
			Thread.sleep(timeSlice);
		} catch (InterruptedException e) {};
	}

	public void run(){
		TestThread current;

		//Set the priority of the scheduler to the highest priority
		this.setPriority(6);

		while (!queue.isEmpty()){
			try {
				current = (TestThread)queue.getNext();

				if ( (current != null) && (current.isAlive()) ){
					System.out.println(" dispatching " + current);
					current.setPriority(4);

					schedulerSleep();

					System.out.print("* * * Context Switch * * * ");
					System.out.println(" preempting " + current);

					current.setPriority(2);
				}

			} catch (NullPointerException e3) {} ;
		}
	}
}

