public class BinaryTree<E>{
	protected TreeNode<E> root;
	//protected BinaryTree left;
	//protected BinaryTree right;
	public BinaryTree(){
		this.root = null;
	}
	public BinaryTree(E item){
		this.root = new TreeNode<E>(item);
	}
	public BinaryTree(E item, BinaryTree<E> lTree, BinaryTree<E> rTree ){
		TreeNode<E> left = null;
		TreeNode<E> right = null;
		if(lTree != null) left = lTree.root; // to deal with the case it being null i.e. when making a new BT f
		if(rTree != null) right = rTree.root;
		this.root = new TreeNode<E>(item, left, right);//read about this
	}
	protected TreeNode<E> getRoot(){
		return this.root;
	}
	
	public void printPostOrder(){
		printPostOrder(root);
		
		
	}
	private void printPostOrder(TreeNode<E> node){ // can only do if the node is null
		if(node != null){
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.item+" ");
			}		
	}
	/*
	add method to binary search tree 
	left <= root <= right
	what if added element is the same 
	then you pick a side and hence be consistent
	but logically patient can't have two locations, so check first.
	read the specification and then act accordingly 
	
	recursion is natural for a tree implementation
	*/
	// SHOULD ACTUALLY BE IN BST NOT BT
	public void add(E str){
		
	}
	
	private TreeNode<E> add(TreeNode<E> node, E object){
		//BASE CASE if the tree is null
		if (node == null){
			//create object and return that sub tree
			TreeNode<E> newNode = new TreeNode(E);
			return newNode;
			// return  new TreeNode<E>(obj);
			
		}
		// node isn't null
		/*
		compare node.item with object (decided that no duplicates exist)
		if object < node.item then add to left subtree
		return the modified left 
		do same for the right side
		*/
		
		// recall precondition E must implement Comparable
		// Chapter 11 look up 606
		int compareResult = obj.compareTo(node.item);
		if (compareResult > 0){
			node.right = obj;
		}
		else if (compareResult < 0){
			node.left = obj;
		}
		
		
		
	}
	public static void main(String[] args){
		BinaryTree <String> a = new BinaryTree <String>("A");
		BinaryTree <String> b = new BinaryTree <String>("B");
		BinaryTree <String> c = new BinaryTree <String>("C", a, b);
		BinaryTree <String> d = new BinaryTree <String>("D", c, b);
		BinaryTree <String> f = new BinaryTree <String>("F", d, null);
		
		
		System.out.println("The root node of the tree f contains " + f.getRoot().item);
		f.printPostOrder();
		DrawableBTree<String> t = new DrawableBTree <String>(f);
		t.showFrame();
	}
}