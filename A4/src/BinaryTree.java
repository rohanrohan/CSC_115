/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 15/3/2016
 * Filename: BinaryTree.java
 * Details: CSC115 Assignment 4
 */
public class BinaryTree<E> {

	/* The root is inherited by any subclass
	 * so it must be protected instead of private.
	 */
	protected TreeNode<E> root;

	/**
	 * Create an empty BinaryTree.
	 */
	public BinaryTree() {
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */
	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}

	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		return root;
	}

	/**
	 * Gives the height of the tree
	 * @return Height of the BinaryTree
     */
	public int height(){
        if(this.getRoot() == null){
            return 0;
        }
        else{
            return this.heightHelper(this.root);
        }
    }

    /**
     * Private helper method which gives the height of the tree from a node
     * @param newNode The node from which height is measured
     * @return The height from TreeNode<E> newNode
     */
    private int heightHelper(TreeNode<E> newNode){
        if(newNode == null){
            return 0;
        }
        else{
            return 1 + Math.max(heightHelper(newNode.left), heightHelper(newNode.right));
        }
    }

    /**
     * Boolean function which returns true if tree is empty
     * @return True if the tree is empty.
     */
    public boolean isEmpty(){
        return(this.root == null);
    }

    /**
     * Removes all the nodes from the tree, making it empty.
     */
    public void makeEmpty(){
        this.root = null;
    }
}


	
