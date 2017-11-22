/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 15/3/2016
 * Filename: BinarySearchTree.java
 * Details: CSC115 Assignment 4
 */
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}

	public void insert(E item) {
        if((search(root, item)) == null){
            this.root = insertHelper(root, item);
        }
        else{
            //Else does nothing
        }
    }

    /**
     * Private helper method which adds a TreeNode item to another TreeNode
     * @param newNode The node to be added to
     * @param item The item to be added to it
     * @return The Node to which item was added
     */

    private TreeNode<E> insertHelper(TreeNode<E> newNode, E item){
        if(newNode == null){
            newNode = new TreeNode<E>(item);
            return newNode;
        }
        else if(item.compareTo(newNode.item) < 0){
            newNode.left = insertHelper(newNode.left, item);
        }
        else if(item.compareTo(newNode.item) > 0){
            newNode.right = insertHelper(newNode.right, item);
        }
        else{
            newNode.item = item;
        }
        return newNode;
    }

    public E retrieve(E key){
        if(key == null){
            throw new RuntimeException("Invalid Key");
        }
        else{
            return search(root, key);
        }
    }

    /**
     * Private helper method which returns E if an item is in the tree
     * or not
     * @param item The item to be searched for
     * @return E if the item is present and null if it isn't
     */
    private E search(TreeNode<E> newNode, E item) {
        E result = null;
        if (newNode == null) {
            result = null;
        } else if (item.compareTo(newNode.item) < 0) {
            search(newNode.left, item);
        } else if (item.compareTo(newNode.item) > 0) {
            search(newNode.right, item);
        } else if (item.equals(newNode.item)) {
            result = item;
            // Base Case)
        }
        return result;
    }

    public void delete(E key){
        if(key == null){
            throw new RuntimeException("Tree is empty.");
        }
        else{
            root = deleteNode(root,key);
        }
    }
    private TreeNode<E> deleteNode(TreeNode<E> oldNode, E key){
        int compare = key.compareTo(oldNode.item);
        if(compare < 0){
            oldNode.left = deleteNode(oldNode.left, key);
        }
        else if(compare > 0){
            oldNode.right = deleteNode(oldNode.right, key);
        }
        else{
            if(oldNode.left == null){
                return oldNode.right;
            }
            if (oldNode.right == null) {
                return oldNode.left;
            }
            TreeNode<E> bufferNode = oldNode;
            oldNode =  minNode(bufferNode.right);
            oldNode.right = deleteMin(bufferNode.right);
            oldNode.left = bufferNode.left;
        }
        return oldNode;
    }

    private TreeNode<E> deleteMin(TreeNode<E> rootNode){
        if(rootNode.left == null){
            return rootNode.right;
        }
        rootNode.left = deleteMin(rootNode.left);
        return rootNode;
    }

    private TreeNode<E> minNode(TreeNode<E> rootNode){
            if(rootNode.left == null){
                return rootNode;
            }
            else return minNode(rootNode.left);
    }

 	/**
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 */
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}
    private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
        if(node == null){
            }
        else{
            collectInOrder(list, node.left);
            list.add(node.item);
            collectInOrder(list, node.right);
        }
    }

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		PatientLocation p1 = new PatientLocation("Duck", "Donald", 338);
		PatientLocation p2 = new PatientLocation("Mouse", "Minnie",116);
		PatientLocation p3 = new PatientLocation("Dog", "Goofy",422);
		PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		tree.insert(p1);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
        System.out.println(tree.height());
        System.out.println(tree.isEmpty());
        System.out.println(tree.retrieve(p1));
        //tree.delete(p1);
        //tree.delete(p4);
        //tree.delete(p2);
        //tree.makeEmpty();
        ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		//draw the tree in its current state:
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();
    }
}
