package project_6046002;

import java.util.*;

public class CircularList 
{
	private Vector List;
	private int index;
	//Creating the circular linked list
	public CircularList(){
		List = new Vector(10);
		index = 0;
	}

	//Next elem in the list
	public Object getNext(){
		Object nextElement = null;
		//int lastElement; //List/Array should be static or dynamic?

		//Of course if list is empty
		if (!List.isEmpty() ){
			if (index == List.size()) //Circular linked list, so index goes back to 0
				index = 0;
			nextElement = List.elementAt(index);
			++index;
		}
		//Else return next element
		return nextElement;
	}

	//If list/queue is empty
	public boolean isEmpty(){
		return List.isEmpty();
	}

	//Adds item to list
	public void addItem(Object t){
		List.addElement(t);      
	}

}
