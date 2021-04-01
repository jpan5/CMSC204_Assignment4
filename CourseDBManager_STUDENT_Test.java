/* The CourseDBManager_STUDENT_Test class is to test the the CourseDBManager class
 * 
 * Date: 03/31/2021
 * Programmer: Jie Pan
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Jie Pan
 *
 */
public class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30578,4,"SC550","Jie Pan");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",30294,4,"SC350","Jay Yuan");
		dataMgr.add("CMSC201",30103,3,"SC250","Jess Li");
		dataMgr.add("CMSC204",30578,4, "SC550","Jie Pan");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"Course: CMSC201 CRN: 30103 Credit: 3 Instructor: Jess Li Room: SC250");
		assertEquals(list.get(1),"Course: CMSC203 CRN: 30294 Credit: 4 Instructor: Jay Yuan Room: SC350");
		assertEquals(list.get(2),"Course: CMSC204 CRN: 30578 Credit: 4 Instructor: Jie Pan Room: SC550");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30294 4 SC350 Jay Yuan");
			inFile.print("CMSC201 30103 3 SC250 Jess Li");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}