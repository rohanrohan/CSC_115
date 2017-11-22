/*
 * The shell of the class, to be completed as part of CSC115 Assignment 4 : Patient Location.
 */

import java.util.ArrayList;

/*
 * NOTE TO STUDENT:
 * Complete this class as per the BinarySearchTree.html specification document.
 * Fill in any of the parts that have the comment:
 *	/******* COMPLETE *******/
 * Do not change method headers or code that has been supplied.
 * Write as many methods as you need to make the code simple and easy to understand.
 * All methods must be properly commented.
 * Delete all messages to you, including this one, before submitting.
 */

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}


 	/******* COMPLETE MISSING METHODS HERE *******/


	/**
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 */
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}
	//may not be solution of A4 only for lab
	/* public void add(E Obj){
		root = add(root, obj);		
	}
	private TreeNode<E> add(TreeNode<E>, node, E obj){
		if (node == null){
			return new TreeNode<E> (obj);
		}
		int compareResult = obj.compareTo(node.item);
		if(compareResult < 0){
			node.left = add(node.left, obj);
		}
		else if (compareResult > 0){
			node.right = add(node.right, obj);
		}
		return node;
	}
	
	*/
/*
 * NOTE TO STUDENT.
 * This recursive method is the one that does the work
 * of traversing the tree in order and placing items
 * into the list.
 * /
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
 		/******* COMPLETE *******/
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
/*
 * NOTE TO STUDENT:
 * Something to get you started...
 * Uncomment as you go, then continue testing.
 */

/*
		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		PatientLocation p1 = new PatientLocation("Duck", "Donald", 338);
		PatientLocation p2 = new PatientLocation("Mouse", "Minnie",116);
		PatientLocation p3 = new PatientLocation("Dog", "Goofie",422);
		PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		tree.insert(p1);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();
*/
	}

}
