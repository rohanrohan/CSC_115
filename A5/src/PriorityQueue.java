/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 4/4/2016
 * Filename: PriorityQueue.java
 * Details: CSC115 Assignment 5
 */
import java.util.NoSuchElementException;

public class PriorityQueue {
	private Heap heap;

    /**
     * Creates an empty priority queue.
     */
	public PriorityQueue() {
 		this.heap = new Heap();
	}

    /**
     * Inserts an item into the queue.
     * @param item The item to be inserted
     */
 	public void enqueue(Comparable item){
		this.heap.insert(item);
	}

    /**
     * Removes the highest priority item from the queue.
     * @return The item.
     * @throws java.util.NoSuchElementException - if the queue is empty.
     */
    public Comparable dequeue(){
        if(this.isEmpty()){
            throw new NoSuchElementException("The Priority Queue is empty.");
        }
        else {
            return this.heap.removeRootItem();
        }
    }

    /**
     * Retrieves, but does not remove the next item out of the queue.
     * @return The item with the highest priority in the queue.
     * @throws java.util.NoSuchElementException - if the queue is empty.
     */
    public Comparable peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException("The Priority Queue is empty.");
        }
        else {
            return this.heap.getRootItem();
        }
    }

    /**
     * Check if the queue is empty or not
     * @return True if the queue is empty, false if it is not.
     */
    public boolean isEmpty(){
        return this.heap.isEmpty();
    }

    public static void main(String[] args) {
        PriorityQueue patients = new PriorityQueue();
        ER_Patient p1 = new ER_Patient("01:00:00",1, "Life-threatening");
        ER_Patient p2 = new ER_Patient("01:00:01",2, "Walk-in");
        ER_Patient p3 = new ER_Patient("01:00:02",3, "Walk-in");
        ER_Patient p4 = new ER_Patient("01:00:03",4, "Major fracture");
        ER_Patient p5 = new ER_Patient("01:00:04",5, "Major fracture");
        ER_Patient p6 = new ER_Patient("01:00:05",6, "Chronic");

        //INTERNAL TESTING


        patients.enqueue(p1);
        patients.enqueue(p2);
        patients.enqueue(p3);
        patients.enqueue(p4);
        patients.enqueue(p5);
        patients.enqueue(p6);
        System.out.println(patients.dequeue());
        System.out.println(patients.dequeue());
        System.out.println(patients.dequeue());
        System.out.println(patients.dequeue());
        System.out.println(patients.dequeue());
        //System.out.println(patients.dequeue());

        System.out.println(patients.isEmpty());
        System.out.println(patients.peek());
     }

}

