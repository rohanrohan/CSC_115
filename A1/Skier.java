/**
 * Name: Rohan Sharma	
 * ID: 
 * Date: 24/1/2016
 * Filename: Skier.java
 * Details: CSC115 Assignment 1
 */

/**
 * Class Skier consists of the name of a skier and the current level of expertise,
 * for the purposes of a Ski school that holds courses for different levels.
 * In this version, the name of the skier is used as the unique identifier; in other words,
 * we assume that no two skiers have the same name. 
 * The possible levels and their descriptions follow:
 * 0.Never skied before
 * 1.Cautious novice: able to snow-plow,stop and make round turns on easy trails
 * 2.Cautious, yet confident skiers who can link turns at moderate speeds
 * 3.Confident skiers who can ski mostly parallel but may use wedging to turn or stop on steep or icy trails.
 * 4.Confident skiers who can make parallel turns but do not ski advanced trails.
 */
public class Skier {

	// Programmer note: Do not alter the following instance variables.
	private String name; // the unique name of the skier
	private int level; // level of skill

/*
 * Programmer note:  Each of the methods below are not complete and
 * need to be implemented by you.
 * Make sure you provide method header comments and provide
 * the implementation code. 
 * Make sure you test regularly for compilation and errors,
 * It is recommended that you reference the completed main method,
 * where each of your methods is tested;
 * follow that ordering so lyou can monitor your progress.
 */

	/**
     * Creates a level 0 Skier
     * @param name name of the skier.
	 */
	public Skier(String name){
		this.name = name;
	}

    /**
     * Creates a Skier at the given level
     * @param name The name of the skier
     * @param level The level of the skier. If value isn't between 0 and 4 inclusive
     *              then Skier level is set to zero
     */
	public Skier(String name, int level) {
		this.name = name;
        if ((level >= 0)&&(level <= 4)) {
            this.level = level;
        }
        else {
            this.level = 0;
        }
	}

    /**
     * Updates the name of the skier to the given name.
     * @param name The updated name.
     */
	public void setName(String name) {
		this.name  = name;
	}

    /**
     * @return The skiers name
     */
	public String getName() {
		return name;
	}

    /**
     * Sets the level for the skier
     * @param level The new level. If level isn't between 0 and 4 inclusive then
     *              the level remains unchanged.
     */
	public void setLevel(int level) {
		if ((level >= 0)&&(level <= 4)) {
            this.level = level;
        }//Checks condition and sets this.level to level
		else{

        }//if condition isn't satisfied, it does nothing
		
	}

    /**
     * @return The current level of the skier
     */
	public int getLevel() {
		return level;
	}

    /**
     * Determines if two skier objects are equivalent.
     * For our purposes, they are equal if they have the same name.
     * @param other The skier to compare to this skier
     * @return True if the other has the same name as this skier does
     */
	public boolean equals(Skier other) {
		if (name.equals(other.getName())) {
            return true;
        }//if the name of the skier is equal to the other skiers name return true
        else{
            return false;
        }//otherwise it returns false
	}

    /**
     * a String representation of the skier.
     * The format is a single line. For example, if the skier's name is Jane Doe
     * and she is at level 0, then the returned string is:
     * Jane Doe (level 0)
     *
     */
	public String toString() {
		StringBuilder s = new StringBuilder(20);
		s.append(""+name+" (level  "+level+")");
		return s.toString();
	}

	public static void main(String[] args) {
		System.out.println("Testing the Skier class.");
		Skier s1 = null;
		try {
			s1 = new Skier("Howie SnowSkier", 4);
		} catch(Exception e) {
			System.out.println("Constructor not working.");
			e.printStackTrace();
			return;
		}
		if (!s1.getName().equals("Howie SnowSkier")) {
			System.out.println("Failed at test one.");
			return;
		}
		if (s1.getLevel() != 4) {
			System.out.println("Failed at test two.");
			return;
		}
		Skier s2 = new Skier("Baby Skier");
		if (!s2.getName().equals("Baby Skier")) {
			System.out.println("Failed at test three.");
			return;
		}
		if (s2.getLevel() != 0) {
			System.out.println("Failed at test four.");
			return;
		}
		s2.setName("Better Skier");
		s2.setLevel(1);
		if (!s2.getName().equals("Better Skier") || s2.getLevel() != 1) {
			System.out.println("Failed at test five.");
			return;
		}
		if (s1.equals(s2)) {
			System.out.println("Failed at test six.");
			return;
		}
		if (!s1.equals(new Skier("Howie SnowSkier",4))) {
			System.out.println("Failed at test seven.");
			return;
		}
		if (s1.toString().equals("Howie SnowSkier (level 0)")) {
			System.out.println("Failed at test eight.");
			System.out.println("Expected: Howie SnowSkier (level 0)");
			System.out.println("Got:      "+s1.toString());
			return;
		}
		System.out.println("All tests passed.");
	}
}
	
