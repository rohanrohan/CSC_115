/**
 * Name: Rohan Sharma
 * ID: 
 * Date: 24/1/2016
 * Filename: SkierList.java
 * Details: CSC115 Assignment 1
 */

/**
 * Class SkierList is a list of Skiers in no particular order.
 */
public class SkierList {
// Programmer note: Do not alter the following instance variables.
	private Skier[] skiers; // array storage for skiers
	private int count; // the number of skiers in the list
	// the following is the initial size of the empty skiers array.
	private static final int INITIAL_CAP = 3;

/*
 * Programmer note: Each of the methods below are not complete and
 * need to be implemented by you.
 * Make sure you provide method header comments and provide
 * the implementation code.
 * Make sure you test regularly for compilation and errors.
 * It is recommended that you reference the completed main method,
 * where each of your methods is tested;
 * follow that ordering so you can monitor your progress.
 */

    /**
     * Creates a SkierList that is empty.
     */
	public SkierList() {
		this.skiers = new Skier[INITIAL_CAP];
		this.count = 0; 
		// Programmer note: Initialize the skiers array to hold INITIAL_CAP Skier objects.
	}

    /**
     * @return The number of Skiers in the list.
     */
	public int size() {
		return count;
	}

    /**
     * Accesses the skier in the list by their position index.
     * If the index is out of range of the list, then null is returned.
     * @param index The index of the position.
     * @return The skier at that index (0...size - 1) of the list.
     */
	public Skier get(int index) {	
		if(index < skiers.length) {
            return skiers[index];
        }//if the index is within the size then it returns the skier at the index
        else {
            return null;
        }//otherwise it returns null
    }

    /**
     * Removes the skier at the index posiiton from the list.
     * If the index is out of range, then nothing is removed.
     * @param index
     */
	public void remove(int index) {
		if(index < count){
			int l; //loop variable
			for (l = index; l < count; l++ ){
			skiers[index] = skiers[index + 1];
			}//shifts all the values after the variable index to the left
			count--;//decreases the size of the list
		}
	}

    /**
     * Adds a skier to the list, in no particular position in the list.
     * @param skier The new skier to be added
     */
	public void add(Skier skier) {
	/*
	 * Programmer note: If the skiers array is full, it needs to be
	 * replaced with a larger array. It has been proven by algorithm efficiency
	 * experts that the best resize process is to double the size of the existing
	 * array.
	 * In this assignment, you do not need to similarly reduce the size of the array
	 * when skiers are removed.
	 */
	 if (count < skiers.length) {
		skiers[count] = skier;
		count++;
     }//if the count is within the size of the array then skier is added at index count

	 else if (count == skiers.length ){
		 Skier[] newArray = new Skier[skiers.length + skiers.length];
		 int i;
		 for(i = 0; i < count; i++){
			 
			 newArray[i] = skiers[i]; 
			 
		 }/* otherwise, if the count is equal to the size of the array
           * then a new array is made with size the double of the previous array
           * the old array is copied into the newArray, then it is referenced as skiers
           * on the following line
           */

		 skiers = newArray;
		 skiers[count] = skier;
		 count++;
	  } // the new skier is added to index count and then count is incremented as usual
	}

    /**
     * Determines if the skier is in the list. If they are in the list,
     * then the index location is returned. If they are not, then -1 is returned.
     * @param skier The skier to find
     * @return The index position of the skier or -1 if the skier isn't present
     */
	public int findSkier(Skier skier) {
		int j = 0, index = -1;
		for(j = 0; j < count; j++){
			if(skiers[j].equals(skier)) {
				index = j;
				break;
			}//loops through the SkierList to find the skier and sets index to j if successful
		} 
		return index;
	}

	/**
	 * Used primarily as a test harness for the class.
	 * @param args Not used.
 	 */
	public static void main(String[] args) {
		System.out.println("Testing the SkierList class.");
		SkierList list = null;
		try {
			list = new SkierList();
		} catch (Exception e) {
			System.out.println("Constructor not working.");
			e.printStackTrace();
			return;
		}
		// Add some skiers.
		Skier s1 = new Skier("Daffy Duck", 0);
		list.add(s1);
		if (list.size() != 1) {
			System.out.println("Failed at test one.");
			return;
		}
		if (!list.get(0).equals(s1)) {
			System.out.println("Failed at test two.");
			System.out.println("The first skier in the list needs to be in index position 0");
			return;
		}
		if (list.findSkier(s1) == -1) {
			System.out.println("Failed at test three.");
			return;
		}
		Skier s2 = new Skier("Bugs Bunny", 4);
		list.add(s2);
		if (s2.getLevel() != 4) {
			System.out.println("Failed at test four.");
			return;
		}
		if (list.size() != 2) {
			System.out.println("Failed at test five.");
			return;
		}
		Skier tmp1 = list.get(0);
		Skier remaining;
		if (tmp1.equals(s1)) {
			remaining = s2;
		} else {
			remaining = s1;
		}
		list.remove(0);
		if (list.findSkier(remaining) == -1) {
			System.out.println("Failed at test six.");
			return;
		}
		if (list.size() != 1) {
			System.out.println("Failed at test seven.");
			return;
		}
		if (!list.get(0).equals(remaining)) {
			System.out.println("Failed at test eight.");
			return;
		}
		list.remove(0);
		if (list.size() != 0) {
			System.out.println("Failed at test nine.");
			return;
		}
		System.out.println("Testing for expansion.");
		// note that the array has to expand in this test.
		// Creating an initial array with a length >= max is a failure.
		String prefix = "Skier";
		int max = 1000;
		try {
			for (int i=0; i<max; i++) {
				list.add(new Skier(prefix+i));
			}
		} catch (Exception e) {
			System.out.println("Failed at test 10.");
			e.printStackTrace();
			return;
		}
		for (int i=max-1; i>=0; i--) {
			if (list.findSkier(new Skier(prefix+i)) == -1) {
				System.out.println("Failed at test 11.");
				System.out.println("Unable to find skier: "+(prefix+i));
				return;
			}
		}
		System.out.println("All tests passed");
	}
}
