/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rtucker
 */
public class StaffListTest {
    private StaffList list;
    private StaffList emptyList;
    private String[] forenames;
    private String[] surnames;
    private String[] fullNames;
    private int noOfStaff;
    
    public StaffListTest() {
        noOfStaff = 5;
        forenames = new String[]
                {"Angela", "Bernard", "Chris", "Damon", "Ellie"};
        surnames = new String[]
                {"Andrews", "Brown", "Cross", "Davison", "Edwards"};
        
        fullNames = new String[noOfStaff];
        for (int ct = 0; ct < noOfStaff; ct++) 
            fullNames[ct] = surnames[ct] + ", " + forenames[ct];
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        emptyList = new StaffList();
        list = new StaffList();
        for (int ct = 0; ct < noOfStaff; ct ++) 
            list.addStaff(new StaffMember(forenames[ct], surnames[ct], "IT"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStaff method, of class StaffList.
     */
    @Test
    public void testAddStaff() {
        System.out.println("Test add staff");
        emptyList.addStaff(new StaffMember());
        assertEquals(1, emptyList.size());
    }

    /**
     * Test of removeStaffAt method, of class StaffList.
     */
    @Test
    public void testRemoveStaffAt() {
        System.out.println("Test remove staff");
        
        // Invalid index
        assertNull(list.removeStaffAt(noOfStaff));
        assertNull(list.removeStaffAt(-1));
        
        // Valid index
        assertNotNull(list.removeStaffAt(noOfStaff - 1));
        assertNotNull(list.removeStaffAt(0));
        assertNotNull(list.removeStaffAt(2));
    }

    /**
     * Test of getAllNames method, of class StaffList.
     */
    @Test
    public void testGetAllNames() {
        System.out.println("Test get all names");
        assertArrayEquals(fullNames, list.getAllNames());
    }

    /**
     * Test of getStaffAt method, of class StaffList.
     */
    @Test
    public void testGetStaffAt() {
        System.out.println("Test get staff at");
        assertEquals(fullNames[0], list.getStaffAt(0).getFullName());
        assertEquals(fullNames[3], list.getStaffAt(3).getFullName());
        assertEquals(fullNames[noOfStaff - 1], 
                list.getStaffAt(noOfStaff - 1).getFullName());
    }

    /**
     * Test of size method, of class StaffList.
     */
    @Test
    public void testSize() {
        System.out.println("Test size");
        assertEquals(0, emptyList.size());
        assertEquals(noOfStaff, list.size());
    }
}