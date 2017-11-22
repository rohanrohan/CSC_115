/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 14/2/2016
 * Filename: MedListRefBased.java
 * Details: CSC115 Assignment 2
 */

public class MedListRefBased implements List<Medication> {
    private MedicationNode head;
    private MedicationNode tail;
    private int count;

    public MedListRefBased() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Private helper method to get the node at index i
     * @param index The index to be used for the item
     * @return The node at that index position
     */
    private MedicationNode getNode(int index) {
        MedicationNode curr = null;
        int k = 0;
        for (curr = head; curr != null && k < index; curr = curr.next) {
            k++;
            }return curr;
    }

    /**
     * Private helper method to add a node before a given one
     *
     * @param item The value of the item of the node to be added
     * @param temp The node before which the new node is to be added
     */
    private MedicationNode addBeforeNode(Medication item, MedicationNode temp) {
        MedicationNode curr = new MedicationNode(item);
        curr.prev = temp.prev;
        curr.next = temp;
        curr.next.prev = curr;
        curr.prev.next = curr;
        return curr;
    }

    /**
     * Inserts an item to into the list at postion index.
     * All items after the new item will have their index position increased by one.
     * For example, if <code>list</code> is a list of integers {1,2,3}, then
     * <code>list.add(9,0)</code> will alter the list to contain {9,1,2,3} in
     * that order.
     *
     * @param item  The object to add to the front of the list.
     * @param index The index position for the new item.
     *              Note that the index position may be equal to the number of items, meaning that
     *              the item will be placed at the end of the list.
     * @throws ListIndexOutOfBoundsException if the index is outside(0 &hellip; size).
     */
    public void add(Medication item, int index) {
        if (index == 0){
           MedicationNode newNode =  new MedicationNode(item);
           if(this.isEmpty()){
               tail = newNode;
           }else{
               head.prev = newNode;
           }
            newNode.next = head;
            head = newNode;

        }
        else if (index == count){
            MedicationNode newNode =  new MedicationNode(item);
            if(this.isEmpty()){
              tail = newNode;
            }else{
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;
        }
        else if (index < 0 || index > count - 1) {
            throw new ListIndexOutOfBoundsException("The index " + index + " is out of bounds.");
        }
        else addBeforeNode(item, getNode(index));
        count++;
    }

    /**
     * Private helper method that removes a given node in the list
     *
     * @param temp The node to be removed
     */
    private void removeBeforeNode(MedicationNode temp) {
        if(temp.prev == null){
            head = temp.next;
            if(head!= null){
                head.prev = null;
            }
        }
        else if (temp.next == null){
            tail = temp.prev;
            if(tail != null){
                tail.next = null;
            }
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    /**
     * Removes the item at the index position of the list.
     *
     * @param index The index number.
     * @throws ListIndexOutOfBoundsException if the index is outside (0 &hellip; size-1).
     */
    public void remove(int index) {
        if (index < 0 || index > count - 1) {
            throw new ListIndexOutOfBoundsException("The index " + index + " is out of bounds.");
        }
        removeBeforeNode(getNode(index));
        count--;
    }

    /**
     * Accesses the item by its position in the list.
     *
     * @param index The index of the position.
     * @return The item at that index position.
     * @throws ListIndexOutOfBoundsException if the index is outside (0 &hellip; size-1).
     */
    public Medication get(int index) {
        MedicationNode curr = head;
        int k = 0;
        if (index < 0 || index > count - 1) {
            throw new ListIndexOutOfBoundsException();
        } else if (head != null && head.next != null) {
            for (curr = head; curr != null && k < index; curr = curr.next) {
                k++;
            }
        }
        return curr.item;
    }

    /**
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (this.head == null);
    }

    /**
     * @return The number of items in the list.
     */
    public int size() {
        return this.count;
    }

    /**
     * Determines if the equivalent item is in the list.
     * If it is in the list, then the index location is returned.
     * If it is not, then -1 is returned.
     *
     * @param item The item that is equivalent to the item we are looking for.
     * @return The index position of the equivalent item or -1 if it is not in the list.
     */
    public int find(Medication item) {
        int k = 0;
        int index = -1;
        MedicationNode curr;
        for (curr = head; curr != null; curr = curr.next, k++) {
            if (curr.item.equals(item)) {
                index = k;
                break;
            }
        }
        return index;
    }

    /**
     * Removes all the items from the list, resulting in an empty list.
     */
    public void removeAll() {
        this.head = null;
        this.tail = null;
        count = 0;
    }

    /**
     * Removes all matching items from the list.
     * For example, if the list is made up of integers and contains {67,12,13,12},
     * then <code>remove(12)</code>
     * will alter the list to {67,13}.
     *
     * @param value The item that identies what to remove.
     *              Any item in the list that matches this item will be removed.
     *              Note that if no matching item can be found, then nothing is removed.
     */
    public void remove(Medication value) {
        MedicationNode curr;
        int j = 0;
        for (curr = head; curr != null && j < count; curr = curr.next) {
            if (curr.item.equals(value)) {
                remove(j);
                }
            else j++;
        }
    }

    public String toString() {
        if (count == 0) return "{}";
        StringBuilder s = new StringBuilder(count*10); // just an estimate of the size
        s.append("List: {\n");
        MedicationNode temp = null;
        for(temp = head; temp!= null; temp = temp.next){
            System.out.print(temp.item.toString()+" ");
            //s.append("\t"+temp.item.getName()+",\t");
            //s.append("\t"+temp.item.getDosage()+",\n");
            }
        s.append("}");
        return s.toString();
    }

    public static void main (String[] args){

        //Testing add() Method
        MedListRefBased list = new MedListRefBased();

        //testing isEmpty and size
        System.out.println("testing isEmpty: " + list.isEmpty());
        System.out.println("size: " + list.size());


        //System.out.println(list);

        //Testing

        list.add(new Medication("M1",25),0);
        list.add(new Medication("M2",75),0);
        list.add(new Medication("M3",100),0);

        //testing isEmpty and size
        System.out.println("testing isEmpty: " + list.isEmpty());
        System.out.println("size: " + list.size());


        list.add(new Medication("M4 ",150),3);
        list.add(new Medication("M4 ",150),1);
        System.out.println(list);
        Medication REM = new Medication("M4 ",150);
        list.remove(REM);
        System.out.println(list);
        //list.add(new Medication("M5",300),2);
        //list.remove();
        System.out.println("testing isEmpty: " + list.isEmpty());
        System.out.println("size: " + list.size());

        //Testing toString method.
        //System.out.println("The list should be {m3, m2 ,m5, m1, m4}");

    }
}
