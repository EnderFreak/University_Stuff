package project_6046002;

import java.util.*;

class TestThread extends Thread
{
	private String name;
	private Random r;
	private int burstTime;

	public TestThread(String id, int burstTime){
		name = id;
		r = new Random();
		this.burstTime = burstTime;
	}

	public String toString (){
		return name;
	}

	public void run(){
		//Do something part in critical section - thread does something
		while (true){
			for (int i = 0; i < burstTime; i++)
				try{
					Thread.sleep(10);
				} 
			catch (InterruptedException e) {}
		}
	}
}
