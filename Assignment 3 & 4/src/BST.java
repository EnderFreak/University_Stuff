public class BST 
{ // BST implementation
	private BinNode root; // The root of the tree
	public BST() 
	{ root = null; 
	} // Initialize root
	public void clear() 
	{ root = null; 
	}
	public boolean isEmpty() 
	{ return root == null; 
	}
	public void print() 
	{
		if (root == null) 
			System.err.println("The BST is empty!");
		else 
		{
			printhelp(root, 0);
			System.out.println();
		}
	}
	private void printhelp(BinNode rt, int level) 
	{
		// In-Order visit
		if (rt == null) return;
		printhelp(rt.left(), level+1);
		for (int i = 0; i < level; i++) // Indent based on level
			System.err.print(" ");
		System.err.println(rt.element()); // Print node value
		printhelp(rt.right(), level+1);
	}

	public Elem find(int key)
	{
		return findhelp(root, key); 
	}

	private Elem findhelp(BinNode rt, int key) 
	{
		if (rt == null) return null;
		Elem it = (Elem)rt.element();
		if (key < it.getkey())
			return findhelp(rt.left(), key);
		else if (it.getkey() == key)
			return it;
		else
			return findhelp(rt.right(), key);
	}
	public void insert(Elem val)
	{ 
		root = inserthelp(root, val); 
	}
	// The method returns a subtree identical to the old one except
	// that it has been modified to contain the new node being inserted
	// Convention: Insert duplicates in the right subtree.
	// First find where the key “val” would have been if it were in
	// the tree:
	// 1) a leaf node or
	// 2) an internal node with one child
	// Then add a new node with key “val”.
	private BinNode inserthelp(BinNode rt, Elem val)
	{
		if (rt == null) 
			return new BinNodePtr(val);
		Elem it = (Elem) rt.element();
		
		if (val.getkey() < it.getkey()) 
		{
			BinNode toLeft = inserthelp(rt.left(), val);
			rt.setLeft(toLeft);
		}
		else 
		{
			BinNode toRight = inserthelp(rt.right(), val);
			rt.setRight(toRight);
		}
		return rt;
		// Only the parent of the added node will have
		// its child pointer modified
	}
}