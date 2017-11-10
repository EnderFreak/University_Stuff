import java.lang.Object;
public class MaxHeap
{
	private Elem[] Heap; // Pointer to heap array
	private int maxsize; // Maximum size of the heap
	private int size; // Number of elements in heap
	public MaxHeap(Elem[] h) // heapify an input array
	{
		Heap = h;
		size = maxsize = Heap.length;
		buildheap(); // see next
	}
	public int heapSize() // Return size of heap
	{
		return size;
	}
	public int heapSizeLimit() // Return size of heap
	{
		return maxsize;
	}
	public boolean isLeaf(int pos) // true if pos is leaf
	{
		return (pos >= size/2) && (pos < size); 
	}
	public int parent(int pos) 
	{ // Return pos for parent
		return (pos-1)/2;
	}
	// Return position for left child of pos
	public int leftchild(int pos)
	{
		return 2*pos + 1;
	}
	// Return position for right child of pos
	public int rightchild(int pos) 
	{
		return 2*pos + 2;
	}
	// Continue on the next page...
	public void insert(Elem val) 
	{
		if (size < maxsize) 
		{
			int curr = size++;
			Heap[curr] = val; // Start at the end of the Heap
			// Sift-up until curr’s parent’s key < curr’s key
			while (curr!=0 && Heap[curr].getkey() > Heap[parent(curr)].getkey()) 
			{
				DSutil.swap(Heap, curr, parent(curr));
				curr = parent(curr);
			}
		}
	}

	public void removeMax() 
	{
		if (size > 0) 
		{
			DSutil.swap(Heap,0,--size); // Swap max with the last value
			if (size!=0) // not the last element
				siftdown(0); // put a new heap root value in the correct place
		}
	}
	private void siftdown(int pos)
	{ // Put in place

		if (pos >= 0 && pos < size)
		{
			System.out.println("Illegal heap Position!");
		}
		while (!isLeaf(pos)) {
			// Assign to an int j the position of the
			// child with the maximum key value.
			// The Heap is a CBT, thus an internal node always have a left
			// child, however such a child may not have a sibling...
			// see next..the condition j < size-1...
			int j = leftchild(pos); // rightchild(pos) == j+1 holds
			if ( j < size-1 && Heap[j].getkey() < Heap[j+1].getkey() )
				j++;
			if ( Heap[pos].getkey() >= Heap[j].getkey() )
				return;
			else {
				DSutil.swap(Heap, pos, j);
				pos = j; // Move down
			}
		}
	}

	public void buildheap() // Heapify contents of Heap
	{
		// it is assumed to be invoked only by the constructor;
		// the size has been initialized with the length of the array
		for (int i=size/2-1; i>=0; i--)
			siftdown(i);
	}

	public Elem remove(int pos) 
	{
		if (pos >=0 && pos < size)
		{
			DSutil.swap(Heap, pos, --size); // Swap with last value
			// sift up
			while (pos != 0 && Heap[pos].getkey() > Heap[parent(pos)].getkey())
			{
				DSutil.swap(Heap, pos, parent(pos));
				pos = parent(pos);
			}
			if (size != 0) 
			{
				siftdown(pos); // push down
			}
			

		}
		return Heap[size];
	}
}