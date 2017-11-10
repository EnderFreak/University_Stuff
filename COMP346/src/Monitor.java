
//importing necessary libraries
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca 
 */
public class Monitor 
{
	final Lock lock = new ReentrantLock();
	final Condition okToSpeak = lock.newCondition();
	final Condition okToEat = lock.newCondition();
	boolean speaking = false;
	int numPhilosophers;
	int tryingToSpeak = 0;
	int tryingToEat = 0;
	
	//is chopstick in use?
	boolean[] chopsticks;
	
	//priority if each philosopher
	int[] priority;

	int[] eatingCounter;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		chopsticks = new boolean[piNumberOfPhilosophers];
		priority = new int[piNumberOfPhilosophers];
		eatingCounter = new int[piNumberOfPhilosophers];
		for (int i = 0; i < piNumberOfPhilosophers; i++)
		{
			chopsticks[i] = false; //because no chopstics are being used
			priority[i] = 0; //because philosopher has lowers priority
			eatingCounter[i] = 0; //none has eaten yet
		}
		
		numPhilosophers = piNumberOfPhilosophers;	
		
		// TODO: set appropriate number of chopsticks based on the # of philosophers
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID)
	{
		lock.lock(); //philosopher is allowed to take chopsticks
		int leftNeighbour = (piTID - 2) % (numPhilosophers);
		leftNeighbour = (leftNeighbour < 0)? leftNeighbour + numPhilosophers:leftNeighbour;
		
		while((chopsticks[piTID - 1] 
				|| chopsticks[(piTID) % numPhilosophers]) 
				&& (priority [leftNeighbour] > priority[piTID -1]
				||priority[piTID % (numPhilosophers)] > priority [piTID -1]))
				
				{
					priority[piTID - 1] ++;
					
					tryingToEat++;
					try
					{
						okToEat.await();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					tryingToEat--; //one less philosopher waiting to eat
				}
		//picking up chopsticks
				chopsticks[piTID - 1] = true;
				chopsticks[(piTID) % numPhilosophers] = true;
				
				priority[piTID - 1] ++;
				System.out.println("Philosohpher " + piTID + " has eaten" + eatingCounter[piTID-1] + " times");
				lock.unlock();
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		lock.lock();
		
		//gives chopsticks
		chopsticks[piTID -1] = false;
		chopsticks[(piTID) % numPhilosophers] = false;
		
		if (tryingToEat>0)
		{
			okToEat.signalAll();
		}
		lock.unlock();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{
		lock.lock();
		tryingToSpeak++;
		
		while (speaking)
		{
			try
			{
				okToSpeak.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		tryingToSpeak--; //philosopher is no longer waiting to speak
		lock.unlock();
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		lock.lock();
		speaking = false; //none's speaking
		
		if(tryingToSpeak > 0)
		{
			okToSpeak.signalAll();
		}
		lock.unlock();
	}
}

// EOF
