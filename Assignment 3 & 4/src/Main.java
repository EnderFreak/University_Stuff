// Main.java
public class Main 
{
	public static void main(String[] args)
	{
		//Create a new Binary Tree
		BST bst = new BST();
		//Create some elements of type Integer
		IElem val = new IElem(22);
		IElem val2 = new IElem(2);
		IElem val3 = new IElem(10);
		IElem val4 = new IElem(4);
		IElem val5 = new IElem(11);
		
		//Add elements to the tree
		bst.insert(val);
		bst.insert(val2);
		bst.insert(val3);
		bst.insert(val4);
		bst.insert(val5);
		//Print the tree
		
		bst.print();
		 
		
		
	}
	public static void visit(BinNode rt) 
	{
		System.err.println(":"+ rt.element());
	}
	public static void preorder(BinNode rt) // rt is root of subtree
	{
		if (rt == null) return; // Empty subtree
		visit(rt);
		preorder(rt.left());
		preorder(rt.right());
	}
	public static void postorder(BinNode rt) // rt is root of subtree
	{
		if (rt == null) return; // Empty subtree
		postorder(rt.left());
		postorder(rt.right());
		visit(rt);
	}
	public static void inorder(BinNode rt) // rt is root of subtree
	{
		if (rt == null) return; // Empty subtree
		inorder(rt.left());
		visit(rt);
		inorder(rt.right());
	}
}