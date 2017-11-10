public class main
{

	public static void main(String[] args)
	{
			System.out.println("Testing");
			dequeue dq = new dequeue(30);
			
			//test when queue is empty
				dq.removeFirst();
				//removelast() when q is empty
				dq.removeLast();
				
			
			//addFirst error testing
				dq.addFirst(new element(6));
				System.out.println(dq); //output q

				
				System.out.println("\nDouble Expansion:\n\tBefore:");
				dq.addFirst(new element(99));
				System.out.println(dq);
				
					System.out.println("\n\tsize: " + dq.size()); 
					System.out.println("\thead: " + dq.head);
					System.out.println("\ttail: " + dq.tail);
				
//adding element will result in automatic expansion
					System.out.println("\n\tAfter:");
					dq.addFirst(new element(22));
					System.out.println(dq);
					
					/*
					//For debugging purposes
						System.out.println("\n\tsize: " + dq.size()); 
						System.out.println("\thead: " + dq.head);
						System.out.println("\ttail: " + dq.tail);
					*/	
				
			//Testing addLast
				System.out.println("\nAdding elements (addLast()):");
				dq.addLast(new element(17));
				System.out.println(dq);
			
			//array expansion test
				dq.setExpansionRule('c');
				
				System.out.println("\nConstant Expansion:\n\tBefore:");
				dq.addLast(new element(10));
				dq.addLast(new element(9));
				dq.addLast(new element(8));
				System.out.println(dq);
				
				//Adding an element that will cause an automatic expansion
					System.out.println("\n\tAfter:");
					dq.addLast(new element(48));
					System.out.println(dq);
			
			//peekFirst() and peekLast() Test
				System.out.println("\nPeeking:\n\tpeekFirst: " + dq.peekFirst().value);
				System.out.println("\tpeekLast: " + dq.peekLast().value);
			
			
			//removeFirst() Test
				System.out.println("\nRemoving elements (removeFirst()):");
				System.out.println("\telement removed: " + dq.removeFirst().value);
				System.out.println(dq);
				System.out.println("\telement removed: " + dq.removeFirst().value);
				System.out.println(dq);
			
			//removeLast() Test
				System.out.println("\nRemoving elements (removeLast()):");
				System.out.println("\telement removed: " + dq.removeLast().value);
				System.out.println(dq);
				System.out.println("\n\telement removed: " + dq.removeLast().value);
				System.out.println(dq);
			
			//truncate() Test
				System.out.println("\nTruncating the array: ");
				dq.truncate();
				System.out.println(dq);
				
				//For debugging purposes
					System.out.println("\n\tsize: " + dq.size());
					System.out.println("\thead: " + dq.head);
					System.out.println("\ttail: " + dq.tail);
				
		//Stack Implementation
			System.out.println("\n\nStack Testing:");
			dequeue stk = new dequeue();
			
			//Adding to Stack
				System.out.println("Adding:\n\tValues added were pushed to the top of the stack");
				stk.addFirst(new element(19));
				stk.addFirst(new element(18));
				stk.addFirst(new element(17));
				stk.addFirst(new element(16));
				stk.addFirst(new element(15));
				stk.addFirst(new element(14));
				stk.addFirst(new element(13));
				stk.addFirst(new element(12));
				System.out.println(stk);
			
			//Deleting from Stack
				System.out.println("\nDeleting:\n\tValues popped were the values at the top of the stack");
				stk.removeFirst();
				stk.removeFirst();
				stk.removeFirst();
				stk.removeFirst();
				System.out.println(stk);
			
				
				stk.setExpansionRule('d'); // flag is set to d for doubling the size
				
				System.out.println("\nDouble Expansion:\n\tBefore:");
				stk.addFirst(new element(9));
				stk.addFirst(new element(10));
				stk.addFirst(new element(11));
				stk.addFirst(new element(12));
				stk.addFirst(new element(13));
				System.out.println(stk + "\n\n\tAfter:");
				
				//Time Double Expansion (1st)
				stk.addFirst(new element(60));
				System.out.println(stk);
				
				stk.addFirst(new element(15));
				stk.addFirst(new element(16));
				stk.addFirst(new element(17));
				stk.addFirst(new element(18));
				stk.addFirst(new element(19));
				stk.addFirst(new element(20));
				stk.addFirst(new element(21));
				stk.addFirst(new element(22));
				stk.addFirst(new element(23));
				
				//Time Double Expansion (2nd)
				stk.addFirst(new element(24));
				System.out.println(stk);
				
				//Adding 10 Values
				stk.addFirst(new element(25));
				stk.addFirst(new element(26));
				stk.addFirst(new element(27));
				stk.addFirst(new element(28));
				stk.addFirst(new element(29));
				stk.addFirst(new element(30));
				stk.addFirst(new element(31));
				stk.addFirst(new element(32));
				stk.addFirst(new element(33));
				
			//Truncate
				System.out.println("\nTruncate array:");
				stk.truncate();
				System.out.println(stk);
			
	
		//Queue Implementation
			System.out.println("\n\nQueue Testing:");
			dequeue q = new dequeue();
			
			//Adding to Queue
			System.out.println("Adding:\n\tValues added were put in a queue");
			q.addFirst(new element(1));
			q.addFirst(new element(2));
			q.addFirst(new element(3));
			q.addFirst(new element(4));
			q.addFirst(new element(5));
			q.addFirst(new element(6));
			q.addFirst(new element(7));
			q.addFirst(new element(8));
			System.out.println(q);
		
		//Deleting from Stack
			System.out.println("\nDeleting:\n\tValues deleted were the values at first in the queue");
			q.removeLast();
			q.removeLast();
			q.removeLast();
			q.removeLast();
			System.out.println(q);
		
		//Constant Expansion
			q.setExpansionRule('c');
			
			System.out.println("\nConstant Expansion:\n\tBefore:");
			q.addFirst(new element(9));
			q.addFirst(new element(10));
			q.addFirst(new element(11));
			q.addFirst(new element(12));
			q.addFirst(new element(13));
			System.out.println(q + "\n\n\tAfter:");
			
			//Time Constant Expansion (1st)
			q.addFirst(new element(14));
			System.out.println(q);
			
			q.addFirst(new element(15));
			q.addFirst(new element(16));
			q.addFirst(new element(17));
			q.addFirst(new element(18));
			q.addFirst(new element(19));
			q.addFirst(new element(20));
			q.addFirst(new element(21));
			q.addFirst(new element(22));
			q.addFirst(new element(23));
			
			
			//Time Constant Expansion (2nd)
			q.addFirst(new element(50));
			System.out.println(q);
			
			q.addFirst(new element(25));
			q.addFirst(new element(61));
			q.addFirst(new element(22));
			q.addFirst(new element(288));
			q.addFirst(new element(229));
			q.addFirst(new element(123));
			q.addFirst(new element(631));
			q.addFirst(new element(921));
			q.addFirst(new element(444));
			
			//Time Constant Expansion (3rd)
			q.addFirst(new element(39));
			System.out.println(q);
			
		//Truncate
			System.out.println("\nTruncate the array:");
			q.truncate();
			System.out.println(q);
			
			
		


		}
}
