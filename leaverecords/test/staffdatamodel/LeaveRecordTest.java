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
public class LeaveRecordTest {
    
    private LeaveRecord emptyRecord;
    private LeaveRecord record;
    
    private Request[] requests; 
    private int noOfRequests;
    
    public LeaveRecordTest() {
        noOfRequests = 6;
        requests = new Request[noOfRequests];
        requests[0] = new Request(LeaveType.ANNUAL, (new Date()), 1);
        requests[1] = new Request(LeaveType.ANNUAL, (new Date()), 2);
        requests[2] = new Request(LeaveType.SICK, (new Date()), 3);
        requests[3] = new Request(LeaveType.SICK, (new Date()), 4);
        requests[4] = new Request((new Date()), 5, "Special request 1");
        requests[5] = new Request((new Date()), 6, "Special request 2");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        emptyRecord = new LeaveRecord();
                
        record = new LeaveRecord();
        for (int ct = 0; ct < requests.length; ct ++) 
            record.addRequest(requests[ct]);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addRequest method, of class LeaveRecord.
     */
    @Test
    public void testAddRequest() {
        System.out.println("Testing add request");
        emptyRecord.addRequest(requests[0]);
        assertEquals(1, emptyRecord.size());
    }

    /**
     * Test of getRequestAt method, of class LeaveRecord.
     */
    @Test
    public void testGetRequestAt() {
        System.out.println("Testing get request");
        
        // Check entries that do exist
        assertEquals(requests[0], record.getRequestAt(0));
        assertEquals(requests[3], record.getRequestAt(3));
        assertEquals(requests[noOfRequests - 1], 
                record.getRequestAt(noOfRequests - 1));
        
        // Check entries that don't exist
        assertNull(record.getRequestAt(-1));
        assertNull(record.getRequestAt(noOfRequests + 1));
    }

    /**
     * Test of approveRequest method, of class LeaveRecord.
     */
    @Test
    public void testApproveRequest() {
        System.out.println("Testing approve request");
        record.approveRequest(0);
        record.approveRequest(3);
        record.approveRequest(noOfRequests - 1);
        
        assertEquals(LeaveStatusType.APPROVED, 
                record.getRequestAt(0).getStatus());
        assertEquals(LeaveStatusType.APPROVED, 
                record.getRequestAt(3).getStatus());
        assertEquals(LeaveStatusType.APPROVED, 
                record.getRequestAt(noOfRequests - 1).getStatus());
    }

    /**
     * Test of declineRequest method, of class LeaveRecord.
     */
    @Test
    public void testDeclineRequest() {
        System.out.println("Testing decline request");
        record.declineRequest(0);
        record.declineRequest(3);
        record.declineRequest(noOfRequests - 1);
        
        assertEquals(LeaveStatusType.DECLINED, 
                record.getRequestAt(0).getStatus());
        assertEquals(LeaveStatusType.DECLINED, 
                record.getRequestAt(3).getStatus());
        assertEquals(LeaveStatusType.DECLINED, 
                record.getRequestAt(noOfRequests - 1).getStatus());
    }

    /**
     * Test of clearAll method, of class LeaveRecord.
     */
    @Test
    public void testClearAll() {
        System.out.println("Testing clear all");
        // Approve an annual leave request then check that the duration
        // has been subtracted from the no of days left. Then use clearAll()
        // and check that the number of days is back to 25 and there are
        // no requests
        record.approveRequest(0);
        assertEquals((25 - requests[0].getDuration()), record.getDaysLeft());
        record.clearAll();
        assertEquals(25, record.getDaysLeft());
        assertEquals(0, record.size());
    }

    /**
     * Test of size method, of class LeaveRecord.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size");
        assertEquals(noOfRequests, record.size());
    }

    /**
     * Test of getDaysLeft method, of class LeaveRecord.
     */
    @Test
    public void testGetDaysLeft() {
        System.out.println("Testing get days left");
        assertEquals(25, record.getDaysLeft());
        record.approveRequest(0);
        assertEquals((25 - requests[0].getDuration()), record.getDaysLeft());
    }
}