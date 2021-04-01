/* The assignment4 is to create a CourseDBElement class which implements Comparable Interface
 * The class has five attributes which are courseID, crn, credits, roomNumber and name. The
 * CourseDBStruture class implements CourseDBStructure interface. It contains a hashTable which 
 * can add and get the elements from the CourseDBElement class. The CourseDBManager class contains
 * a readFile method which can read the input text file.
 * 
 * Date: 03/31/2021
 * Programmer: Jie Pan
 */

public class CourseDBElement implements Comparable {

	private String courseID;
	private int crn;
	private int credits;
	private String roomNumber;
	private String name;
	
	public CourseDBElement() {
		courseID = null;
		crn = 0;
		credits = 0;
		roomNumber = null;
		name = null;
	}
	
	public CourseDBElement(String courseID, int crn, int credits, String roomNumber, String name) {
		this.courseID = courseID;
		this.crn = crn;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.name = name;
	}
	
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	public int getCRN() {
		return crn;
	}

	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public void setNumOfCredits(int credits) {
		this.credits = credits;
	}
	
	public int getNumOfCredits() {
		return credits;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
    
	@Override
	public int compareTo(CourseDBElement element) {
		return this.crn - element.crn;
	}
	

	public int hashCode() {
		return ("" + crn).hashCode();
	}
	

	public String toString() {
		String str = "Course: " + courseID + " CRN: " + crn + " Credit: " + credits + " Instructor: " + name + " Room: " + roomNumber;
		return str;
	}

}	
