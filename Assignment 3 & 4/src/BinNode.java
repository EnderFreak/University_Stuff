interface BinNode 
{ // ADT for binary tree nodes
	// Return and set the element value
	public Object element();
	public Object setElement(Object v);
	// Return and set the left child
	public BinNode left();
	public BinNode setLeft(BinNode p);
	// Return and set the right child
	public BinNode right();
	public BinNode setRight(BinNode p);
	// Return true if this is a leaf node
	public boolean isLeaf();
}

