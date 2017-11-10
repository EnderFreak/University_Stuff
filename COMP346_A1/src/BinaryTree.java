public class BinaryTree {
	public Node root;

	//The node class
	public class Node<T> {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	//Inserting the value in the tree as a node
	public void insert(int value){
		Node node = new Node<>(value);
		//If the tree is empty
		if ( root == null ) {
			root = node;
			return;
		}

		insertRec(root, node);
	}

	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ",");
		printInOrderRec(currRoot.right);
	}
	
	private void insertRec(Node latestRoot, Node node){

		if ( latestRoot.value > node.value){

			if ( latestRoot.left == null ){
				latestRoot.left = node;
				return;
			}
			else{
				insertRec(latestRoot.left, node);
			}
		}
		else{
			if (latestRoot.right == null){
				latestRoot.right = node;
				return;
			}
			else{
				insertRec(latestRoot.right, node);
			}
		}
	}
}
