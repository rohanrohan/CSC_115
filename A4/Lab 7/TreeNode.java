class TreeNode <E>{ //very useful to make a generic tree
	E item;
	TreeNode<E> left;
	TreeNode<E> right;
	
	//constructors
	public TreeNode(E item, TreeNode<E> left, TreeNode<E> right){
		this.item = item;
		this.left = left;
		this.right = right;
	}
	public TreeNode(E item){
		this(item, null, null);
	}	
}