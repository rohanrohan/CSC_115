/**
 * Name: Rohan Sharma
 * ID:
 * Date: 24/1/2016
 * Filename: Lesson.java
 * Details: CSC115 Assignment 1
 */

/**
 * Class Lesson is a Ski lesson for a certain level of skiers.
 * It may be empty or contain a number of ski students.
 * In this version of the class, there is no limit to the number of students in the lesson.
 */
public class Lesson {

	/*
	 * Programmer note:
	 * the following static final array is a nice lookup array to
	 * match the level numbers to the level names.
	 * Note that the index of a name in the array is exactly the
	 * the level number for that name.
	 * Because this particular lookup array is immutable and
	 * there only needs to be one copy for any number of Lesson objects,
	 * we use the 'final' and 'static'.
	 */
	private static final String[] levelNames = 
		{"Beginner", "Novice", "Snowplower", "Intermediate", "Advanced"};
	// Programmer note: Do not alter the following instance variables.
	private int lessonLevel; // level of the Lesson, not necessarily all the skiers
	private String lessonName; // One of the names in levelNames array above.
	private SkierList students; // The list of skiers registered for this lesson.

/*
 * Programmer note: Each of the methods below are not complete and
 * need to be implemented by you.
 * Make sure you provide method header comments and provide
 * the implementation code.
 * Make sure you test regularly for compilation and errors.
 * It is recommended that you reference teh completed main method,
 * where each of your methods is tested;
 * follow that ordering so you can monitor your progress.
 */

    /**
     * Creates a lesson for a given level.
     * @param level The level of the students who will take this lesson.
     *              If the level is out of range (0 ... 4),
     *              then the level is defaulted to 0.
     */
	public Lesson(int level) {
        if ((level >= 0)&&(level <= 4)) {
            this.lessonLevel = level;
        }
        else {
            this.lessonLevel = 0;
        }
		this.students = new SkierList();
	}

    /**
     * Creates a lesson for the given level, and populates the lesson with Skiers.
     * @param level The level of the students who will take this lesson.
     *              If the level is out of range (0 ... 4), then the level is defaulted to 0.
     * @param students The SkierList. Note that all skiers in the list are assumed to be in the correct level.
     *                 No checking is done for skiers who are in the wrong level in this version of the class.
     */
	public Lesson(int level, SkierList students) {
		this.lessonLevel = level;
		this.students = students;
	}

    /**
     * Sets the lesson name based on the level of the students.
     * The level names associated with the level numbers are as follows:
     * Beginner
     * Novice
     * Snowplower
     * Intermediate
     * Advanced
     * If the level is out of range (0 ... 4), then the level remains unchanged.
     * This method does not reset the levels of the individual skiers in the lesson.
     * @param level the new level
     */
	public void setLessonLevel(int level) {
			 if ((level >= 0) && (level <=4)) {
			 lessonLevel = level;
			 lessonName = levelNames[level];
		}
	}

    /**
     * @return
     * The group name of the lesson. The name is one of the following that is based on the level number:
     * Beginner
     * Novice
     * Snowplower
     * Intermediate
     * Advanced
     */
	public String getName() {
			 if (lessonLevel == 0) return levelNames[0];
		else if (lessonLevel == 1) return levelNames[1];
		else if (lessonLevel == 2) return levelNames[2];
		else if (lessonLevel == 3) return levelNames[3];
		else if (lessonLevel == 4) return levelNames[4];
		else return "";
	}

    /**
     * @return The number of skiing students in the lesson.
     */
	public int numStudents() {
		return this.students.size();
	}

    /**
     * Adds a new skier to the list. Before adding the skier to the lesson,
     * the skier's level is updated to fit the level of the lesson.
     * @param skier The skier to add to the class.
     *              If the skier is already present, then nothing is added.
     */
	public void addSkier(Skier skier) {
		int result = this.students.findSkier(skier);
        if(result == -1) {
            skier.setLevel(this.lessonLevel);
            this.students.add(skier);
        }
        else {

        }

    }//if the skier isn't found in the SkierList students then it's level is updated and it is added

    /**
     * Removes a skier from the lesson.
     * If the skier is not in the lesson, then nothing is removed.
     * @param skier The skier to remove.
     */
	public void removeSkier(Skier skier) {
		int position = 0;
		position = this.students.findSkier(skier);
		
		if(position == -1) {

        }//do nothing
		else if (position >= 0){
				this.students.remove(position);
			
		} 
	}

    /**
     * Determines whether a particular skier is registered for this Lesson.
     * @param skier The skier in question.
     * @return true if the skier is registered for the lesson, false if not.
     */
	public boolean isRegistered(Skier skier) {
		if(students.findSkier(skier) != -1){
            return true;
        }
        else{
            return false;
        }
	}

    /**
     * Prints a list of the students. The list is presented in the following format:
     * <lessonName> group:
     * <string representation of skier object>
     * <string representation of skier object>
     * <...>
     * For the <string representation of skier object> see the Skier.toString method.
     * Note that the lesson name and each student is on a separate line.
     * Note also that the list of skiers is in no particular order
     * @return The string containing the information in the above format.
     */
	public String toString() {
		StringBuilder s = new StringBuilder(200);
		s.append(lessonName+" group");
		int k;
		for(k = 0; k < this.numStudents() ; k++){
			s.append(" "+students.get(k).getName()+" (level "+students.get(k).getLevel()+")");
		}return s.toString();
	}

	/**
	 * Used as a test harness for the class.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		System.out.println("Testing the Lesson class.");
		Lesson lesson = null;
		String[] group = {"Daffy Duck", "Bugs Bunny", "Betty Boop",
			"Roger Rabbit", "Han Solo", "Chewbacca"};
		try {
			lesson = new Lesson(2);
		} catch (Exception e) {
			System.out.println("Failed to construct a Lesson object.");
			e.printStackTrace();
			return;
		}
		if (!lesson.getName().equals("Snowplower")) {
			System.out.println("Failed at test one.");
			return;
		}
		if (lesson.numStudents() != 0) {
			System.out.println("Failed at test two.");
			return;
		}
		lesson.setLessonLevel(3);
		if (!lesson.getName().equals("Intermediate")) {
			System.out.println("Failed at test three.");
			return;
		}
		for (int i=0; i<group.length; i++) {
			lesson.addSkier(new Skier(group[i]));
		}
		if (lesson.numStudents() != 6) {
			System.out.println("Failed at test four.");
			return;
		}
		System.out.print("Checking the toString: Should see a list of ");
		System.out.println("6 skiers, all with level 3");
		System.out.println(lesson);
		
		System.out.println("Checking constructor that takes a list.");
		int[] levels = {0,3,2};
		int levelIndex = 0;
		SkierList list = new SkierList();
		for (int i=0; i<group.length; i++) {
			list.add(new Skier(group[i],levels[levelIndex]));
			levelIndex = (levelIndex+1)%levels.length;
		}
		try {
			lesson = new Lesson(4,list);
		} catch (Exception e) {
			System.out.println("Constructor not working.");
			e.printStackTrace();
			return;
		}
		if (lesson.numStudents() != 6) {
			System.out.println("Failed at test five.");
			return;
		}
		for (int i=0; i<list.size(); i++) {
			if (!lesson.isRegistered(list.get(i))) {
				System.out.println("Failed at test six.");
				return;
			}
		}
		Skier removed = list.get(3);
		lesson.removeSkier(removed);
		if (lesson.isRegistered(removed)) {
			System.out.println("Failed at test seven.");
			return;
		}
		if (lesson.numStudents() != 5) {
			System.out.println("Failed at test eight.");
			return;
		}
		System.out.print("The following printout should consist of 5 ");
		System.out.println("skiers with varying levels:");
		System.out.println(lesson);
		System.out.println("Testing completed.");
	}
}
