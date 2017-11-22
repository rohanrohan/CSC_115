/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 28/2/2016
 * Filename: StringStack.java
 * Details: CSC115 Assignment 3
 */
public class StringStack {
	private Node head;

    /**
     * Checks if the stack is empty
     * @return true or false, if the stack is empty or not
     */
	public boolean isEmpty() {
		return(head == null);
	}

    /**
     * Pops a single item off the stack and throws
     * StackEmptyException if the stack is empty
     * @return The item popped off the stack
     */
	public String pop() {
		if(this.isEmpty()){
			throw new StackEmptyException();
		}
		else{
			String s = head.s;
            head = head.next;
            return(s);
            }
    }

    /**
     * Checks the top of the stack without popping the stack
     * @return The top of the stack without removal from said stack
     */
	public String peek() {
        if(this.isEmpty()){
            throw new StackEmptyException();
        }
        else{
            return head.s;
        }
	}

    /**
     * Adds an item to the stack
     * @param item The item that is to be added
     */
	public void push(String item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
	}

    /**
     * Empties the stack, removes everything
     * Use with caution
     */
	public void popAll() {
        head = null;
	}
}
