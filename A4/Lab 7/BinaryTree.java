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