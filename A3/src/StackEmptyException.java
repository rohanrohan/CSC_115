/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 28/2/2016
 * Filename: StackEmptyException.java
 * Details: CSC115 Assignment 3
 */
public class StackEmptyException extends RuntimeException {
    /**
     * Creates an exception.
     * @param msg The message to the calling program.
     */
    public StackEmptyException(String msg) {
        super(msg);
    }
    /**
     * Creates an exception without a message.
     */
    public StackEmptyException() {
        super();
    }
}