/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 28/2/2016
 * Filename: Node.java
 * Details: CSC115 Assignment 3
 */
public class Node {
    protected String s;
    protected Node next;

    /**
     * Node class constructors for all instances
     */
    Node(String string, Node next){
        this.s = string;
        this.next = next;
    }
    Node(String string){
        this.s = string;
        this.next = null;
    }
    Node(Node next){
        this.s = "";
        this.next = next;
    }
}
