package project_6046002;

//Importing libraries
import java.util.*;


public class VirtualMachine {

    public static void main(String args[]) {
    	//Getting information from the user
    	Scanner input = new Scanner(System.in);
    	
    	int quantumSize = input.nextInt();
    	int process1ArraySize = input.nextInt();
    	int process1SearchValue = input.nextInt();
    	int process2SquareValue = input.nextInt();
    	int process3SummationInteger = input.nextInt();
    	
    	//Display message
    	System.out.println("** COMP 346 Virtual Machine Scheduling Test ** \n"
    			+ "---------------------------------------------\n"
    			+ "Quantum Size: " + quantumSize
    			+"Size of Process 1 array: " + process1ArraySize
    			+"Value for Process 1 search: " + process1SearchValue
    			+"Value to square in Process 2: " + process2SquareValue
    			+"Max integer in Process 3 summation: " + process3SummationInteger
    			+"\n Contents of process 1 array:");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//Max priority so as to create the schedulers
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Scheduler CPUScheduler = new Scheduler();

        //Running thread 1
        TestThread t1 = new TestThread("Thread 1", 200);
        t1.start();
        CPUScheduler.addThread(t1);
        System.out.println("Thread1 is executing thread 1");

        //Running thread 2
        TestThread t2 = new TestThread("Thread 2", 80);
        t2.start();
        CPUScheduler.addThread(t2);

        //Running thread 3
        TestThread t3 = new TestThread("Thread 3", 150);
        t3.start();
        CPUScheduler.addThread(t3);

        //Start the thread
        CPUScheduler.start();

    }
}