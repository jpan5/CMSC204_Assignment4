/* The assignment4 is to create a CourseDBElement class which implements Comparable Interface
 * The class has five attributes which are courseID, crn, credits, roomNumber and name. The
 * CourseDBStruture class implements CourseDBStructure interface. It contains a hashTable which 
 * can add and get the elements from the CourseDBElement class. The CourseDBManager class contains
 * a readFile method which can read the input text file.
 * 
 * Date: 03/31/2021
 * Programmer: Jie Pan
 */

import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {

	protected int size;
	protected LinkedList<CourseDBElement>[] hashTable;
	
	public CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	public CourseDBStructure(String str, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}

	@Override
	public int getTableSize() {
		return size;
	}

	@Override
	public void add(CourseDBElement element) {
		int index = element.hashCode() % size;
		
        if(hashTable[index] == null) {
        	
                hashTable[index] = new LinkedList<CourseDBElement>();
        }
        
        hashTable[index].add(element);
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String str = crn + "";
		int index = str.hashCode() % size;
		
		if(hashTable[index] == null) { 
			throw new IOException("The list is empty");
		}
		else {
			for(int i = 0; i < size; i++) {
				CourseDBElement temp = hashTable[index].get(i);
				
				if(temp.getCRN() == crn) {
					return temp;
				}
			}
		}
		return null;
	}

}
