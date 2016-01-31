/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.util.Date;
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
public class StaffMemberTest {
    
    private StaffMember staff;
    private StaffMember emptyStaff;
    
    private Request[] requests; 
    private int noOfRequests;
    private Request addedRequest;
    
    public StaffMemberTest() {
        noOfRequests = 6;
        requests = new Request[noOfRequests];
        requests[0] = new Request(LeaveType.ANNUAL, (new Date()), 1);
        requests[1] = new Request(LeaveType.ANNUAL, (new Date()), 2);
        requests[2] = new Request(LeaveType.SICK, (new Date()), 3);
        requests[3] = new Request(LeaveType.SICK, (new Date()), 4);
        requests[4] = new Request((new Date()), 5, "Special request 1");
        requests[5] = new Request((new Date()), 6, "Special request 2");
        
        addedRequest = new Request(LeaveType.ANNUAL, (new Date()), 10);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Create 'emptyStaff' with basic data but no requests and 'Staff'
        // with the six requests from the array
        emptyStaff = new StaffMember("Alison", "Smith", "HR");
        staff = new StaffMember("John", "Smith", "IT");
        for (int ct = 0; ct < noOfRequests; ct ++)
            staff.addRequest(requests[ct]);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addRequest method, of class StaffMember.
     */
    @Test
    public void testAddRequest() {
        System.out.println("Test add request");
        emptyStaff.addRequest(addedRequest);
        assertEquals(addedRequest, emptyStaff.getRequestAt(0));
    }

    /**
     * Test of getRequestAt method, of class StaffMember.
     */
    @Test
    public void testGetRequestAt() {
        System.out.println("Test get request");
        assertEquals(requests[4], staff.getRequestAt(4));
        assertNull(staff.getRequestAt(noOfRequests + 1));
    }

    /**
     * Test of approveRequest method, of class StaffMember.
     */
    @Test
    public void testApproveRequest() {
        System.out.println("Test approve request");
        staff.approveRequest(1);
        assertEquals((25 - requests[1].getDuration()), staff.getDaysLeft());
        assertEquals(LeaveStatusType.APPROVED, staff.getRequestAt(1).getStatus());
    }

    /**
     * Test of declineRequest method, of class StaffMember.
     */
    @Test
    public void testDeclineRequest() {
        System.out.println("Test decline request");
        staff.declineRequest(5);
        assertEquals(LeaveStatusType.DECLINED, staff.getRequestAt(5).getStatus());
    }

    /**
     * Test of getDaysLeft method, of class StaffMember.
     */
    @Test
    public void testGetDaysLeft() {
        System.out.println("Test get days left");
        assertEquals(25, emptyStaff.getDaysLeft());
    }

    /**
     * Test of clearAllLeave method, of class StaffMember.
     */
    @Test
    public void testClearAllLeave() {
        System.out.println("Test clear all leave");
        staff.clearAllLeave();
        assertEquals(0, staff.getNoOfRequests());
        assertEquals(25, staff.getDaysLeft());
    }

    /**
     * Test of getNoOfRequests method, of class StaffMember.
     */
    @Test
    public void testGetNoOfRequests() {
        System.out.println("Test get number of requests");
        assertEquals(0, emptyStaff.getNoOfRequests());
        assertEquals(this.noOfRequests, staff.getNoOfRequests());
    }

    /**
     * Test of getDept method, of class StaffMember.
     */
    @Test
    public void testGetDept() {
        System.out.println("Test get dept ");
        assertEquals("IT", staff.getDept());
    }

    /**
     * Test of setDept method, of class StaffMember.
     */
    @Test
    public void testSetDept() {
        System.out.println("Test set dept");
        staff.setDept("Accounts");
        assertEquals("Accounts", staff.getDept());
    }
}