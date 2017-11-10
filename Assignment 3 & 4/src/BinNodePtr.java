// BinNodePtr.java – we do not optimize the code using two different
// implementations of the BinNode interface for internal and leaf nodes
// (leafs do not need to waste space for storing any child pointer).
public class BinNodePtr implements BinNode
{
	private Object elem;
	private BinNode left;
	private BinNode right;
	public BinNodePtr() // Constructor 1
	{ 
		left = right = null; 
	}
	public BinNodePtr(Object val) // Constructor 2
	{ 
		left = right = null; elem = val; 
	}
	public BinNodePtr(Object val, BinNode l, BinNode r) // Constructor 3
	{ 
		left = l; right = r; elem = val;
	}
	public Object element() 
	{ 
		return elem;
	}
	public Object setElement(Object v)
	{ 
		return elem = v;
	}
	public BinNode left() 
	{ 
		return left; 
	}
	public BinNode setLeft(BinNode p) 
	{ 
		return left = p; 
	}
	public BinNode right()
	{ 
		return right; 
	}
	public BinNode setRight(BinNode p) 
	{
		return right = p; 
	}
	public boolean isLeaf() 
	{ 
		return (left == null)&&(right == null); 
	}
}