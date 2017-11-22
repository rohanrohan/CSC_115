/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 4/4/2016
 * Filename: Heap.java
 * Details: CSC115 Assignment 5
 */
import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings({"unchecked"})


public class Heap {
    private Comparable[] heapArray;

    public Heap() {
        heapArray = new Comparable[2];

    }

    /**
     * @return True if the heap is empty, false if it is not.
     */
    public boolean isEmpty() {
        return (heapArray[1] == null);
    }

    /**
     *
     * @return The number of items in the heap.
     */
    public int size() {
        int counter = 0;
        for (int i = 1; i < heapArray.length; i++) {
            if (heapArray[i] != null) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    /**
     * Inserts an item into the heap.
     * @param item - The newly added item.
     */
    public void insert(Comparable item) {
        if (this.size() == heapArray.length - 1) {
            doubleAndCopy();
        }
        int pos = this.size() + 1;
        heapArray[pos] = item;
        this.bubbleUp();
    }

    /**
     * Private helper method which doubles the size of the existing array
     * and copies everything from the old array
     */
    private void doubleAndCopy() {
        Comparable[] newArray = new Comparable[heapArray.length * 2];
        for (int i = 1; i < this.size()+ 1; i++) {
            newArray[i] = heapArray[i];
        }
        heapArray = newArray;
    }

    /**
     * Private method for Bubbling up after insert method has added an
     * element to the Heap. "Heapifies" the given structure
     */
    private void bubbleUp(){
        int index = this.size();
        while(index > 1 && heapArray[index/2].compareTo(heapArray[index]) > 0){
            swap(index, index/2);
            //while they are out of order; swap them
            index = index/2;
        }
    }

    /**
     * Private helper method which swaps two elements in an array
     * @param index1 The item at index1 which is to be swapped with item at index2
     * @param index2 The item at index2 which is to be swapped with item at index1
     */
    private void swap(int index1, int index2) {
        Comparable temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    /**
     * Removes the item at the root node of the heap.
     * @return The item at the root of the heap.
     * @throws NoSuchElementException - if the heap is empty
     */
    public Comparable removeRootItem(){
        if(this.heapArray[1] != null){
            Comparable result = this.getRootItem();
            //what we want to return

            //getting rid of the root item by replacing it with last element in heap
            heapArray[1] = heapArray[this.size()];
            //making the last element null
            heapArray[this.size()] = null;

            this.bubbleDown();
            return result;
        }
        else {
            throw new NoSuchElementException("The Heap is empty");
        }

    }

    /**
     * Private helper method to "Heapify" the structure
     * after an item has been removed from the heap
     */
    private void bubbleDown(){
        int index = 1;

        while(hasALeftChild(index)){
            //finds out smaller child assume its the left child
            int smallerChildIndex = leftChildIndex(index);
            if(hasARightChild(index)
                    && heapArray[leftChildIndex(index)].compareTo(heapArray[rightChildIndex(index)]) > 0) {
                smallerChildIndex = rightChildIndex(index);
            }
                //compares between left and right child and if right child
                //is smaller than the smallerChildIndex is assigned to that

                if(heapArray[index].compareTo(heapArray[smallerChildIndex]) > 0){
                    swap(index, smallerChildIndex);
                    //if the smallerChild has higher priority it is swapped with the parent
                }
                else{
                    break;
            }
            index = smallerChildIndex;
        }
    }

    /**
     * Private helper method which returns index of the left child
     * @param index - index of the parent item
     * @return index of the left child
     */
    private int leftChildIndex(int index) {
        return index * 2;
    }

    /**
     * Private helper method which returns index of the right child
     * @param index - index of the parent item
     * @return index of the right child
     */
    private int rightChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * Checks if the parent item has a left child
     * @param i index of parent
     * @return True if it has a left child; false otherwise
     */
    private boolean hasALeftChild(int i) {
        return leftChildIndex(i) <= this.size();
    }

    /**
     * Checks if the parent item has a right child
     * @param i index of parent
     * @return True if it has a right child; false otherwise
     */
    private boolean hasARightChild(int i) {
        return rightChildIndex(i) <= this.size();
    }

    /**
     * Retrieves, without removing the item in the root.
     * @return The top item in the tree.
     * @throws NoSuchElementException if the heap is empty
     */
    public Comparable getRootItem() {
        if(this.heapArray[1] != null){
            return this.heapArray[1];
        }
        else {
            throw new NoSuchElementException("The Heap is empty");
        }
    }

    /**
     * Converts the data to a string to be printed out
     * @return the string that is returned
     */
    public String toString() {
        String out = "";
        for(int k = 1; k <= this.size(); k++) out += heapArray[k]+"\t";
        return out;
    }

    public static void main(String[] args) {
        Heap patients = new Heap();
        ER_Patient p1 = new ER_Patient("01:00:00",1, "Life-threatening");
        ER_Patient p2 = new ER_Patient("01:00:01",2, "Walk-in");
        ER_Patient p3 = new ER_Patient("01:00:02",3, "Walk-in");
        ER_Patient p4 = new ER_Patient("01:00:03",4, "Major fracture");
        ER_Patient p5 = new ER_Patient("01:00:04",5, "Major fracture");
        ER_Patient p6 = new ER_Patient("01:00:05",6, "Chronic");

        //INTERNAL TESTING


        patients.insert(p1);
        patients.insert(p2);
        patients.insert(p3);
        patients.insert(p4);
        patients.insert(p5);
        patients.insert(p6);


        /*
        patients.removeRootItem();
        patients.removeRootItem();
        patients.removeRootItem();
        patients.removeRootItem();
        patients.removeRootItem();
        patients.removeRootItem();
         */

        //System.out.println(patients.isEmpty());
        //System.out.println(patients.getRootItem());
        //System.out.println(patients.size());
        //System.out.println(patients);

    }

}