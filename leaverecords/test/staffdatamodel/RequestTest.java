/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.util.Date;
import java.util.GregorianCalendar;
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
public class RequestTest {
    
    private Date start1;
    private Date start2;
    private Date start3;
    
    private String strStart1;
    private String strStart2;
    private String strStart3;
    
    private String specialReason;
    
    private Request sickLeave;
    private Request specialLeave;
    private Request annualLeave;
    
    private Request annualStatusCheck;
    
    public RequestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        start1 = (new GregorianCalendar(2012, 10, 30)).getTime();
        start2 = (new GregorianCalendar(2012, 8, 1)).getTime();
        start3 = (new GregorianCalendar(2013, 1, 20)).getTime();
        
        strStart1 = "30/11/2012";
        strStart2 = "01/09/2012";
        strStart3 = "20/02/2013";
        
        specialReason = "Family funeral";
        
        sickLeave = new Request(LeaveType.SICK, start1, 5);
        specialLeave = new Request(start2, 10, specialReason);
        annualLeave = new Request(LeaveType.ANNUAL, start3, 15);
        
        annualStatusCheck = new Request(LeaveType.ANNUAL, start1, 5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of approve method, of class Request.
     */
    @Test
    public void testApprove() {
        System.out.println("Testing approved leave");
        annualStatusCheck.approve();
        assertEquals(LeaveStatusType.APPROVED, annualStatusCheck.getStatus());
        annualStatusCheck.reset();
    }

    /**
     * Test of decline method, of class Request.
     */
    @Test
    public void testDecline() {
        System.out.println("Testing declined leave");
        annualStatusCheck.decline();
        assertEquals(LeaveStatusType.DECLINED, annualStatusCheck.getStatus());
        annualStatusCheck.reset();
    }

    /**
     * Test of reset method, of class Request.
     */
    @Test
    public void testReset() {
        System.out.println("Testing reset leave");
        annualStatusCheck.decline();
        assertEquals(LeaveStatusType.DECLINED, annualStatusCheck.getStatus());
        annualStatusCheck.reset();
        assertEquals(LeaveStatusType.PENDING, annualStatusCheck.getStatus());
    }

    /**
     * Test of getDateAsString method, of class Request.
     */
    @Test
    public void testGetDateAsString() {
        System.out.println("Testing date as string");
        assertEquals(strStart1, sickLeave.getDateAsString());
        assertEquals(strStart2, specialLeave.getDateAsString());
        assertEquals(strStart3, annualLeave.getDateAsString());
    }

    /**
     * Test of getLeaveType method, of class Request.
     */
    @Test
    public void testGetLeaveType() {
        System .out.println("Testing get leave type");
        assertEquals(LeaveType.SICK, sickLeave.getLeaveType());
        assertEquals(LeaveType.SPECIAL, specialLeave.getLeaveType());
        assertEquals(LeaveType.ANNUAL, annualLeave.getLeaveType());
    }

    /**
     * Test of setLeaveType method, of class Request.
     */
//    @Test
//    public void testSetLeaveType() {
//        System.out.println("setLeaveType");
//        LeaveType leaveType = null;
//        Request instance = new Request();
//        instance.setLeaveType(leaveType);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStartDate method, of class Request.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("Testing get start date");
        assertEquals(start1, sickLeave.getStartDate());
        assertEquals(start2, specialLeave.getStartDate());
        assertEquals(start3, annualLeave.getStartDate());
    }

    /**
     * Test of setStartDate method, of class Request.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("Testing set start date");
        annualLeave.setStartDate(start1);
        assertEquals(start1, annualLeave.getStartDate());
        annualLeave.setStartDate(start3);
    }

    /**
     * Test of getDuration method, of class Request.
     */
    @Test
    public void testGetDuration() {
        System.out.println("Testing get duration");
        assertEquals(5, sickLeave.getDuration());
        assertEquals(10, specialLeave.getDuration());
        assertEquals(15, annualLeave.getDuration());
    }

    /**
     * Test of setDuration method, of class Request.
     */
    @Test
    public void testSetDuration() {
        System.out.println("Testing set duration");
        sickLeave.setDuration(25);
        assertEquals(25, sickLeave.getDuration());
        sickLeave.setDuration(5);
    }

    /**
     * Test of getStatus method, of class Request.
     */
    @Test
    public void testGetStatus() {
        System.out.println("Testing get status");
        annualStatusCheck.approve();
        assertEquals(LeaveStatusType.APPROVED, annualStatusCheck.getStatus());
        annualStatusCheck.decline();
        assertEquals(LeaveStatusType.DECLINED, annualStatusCheck.getStatus());
        annualStatusCheck.reset();
        assertEquals(LeaveStatusType.PENDING, annualStatusCheck.getStatus());
    }

    /**
     * Test of setStatus method, of class Request.
     */
//    @Test
//    public void testSetStatus() {
//        System.out.println("setStatus");
//        LeaveStatusType status = null;
//        Request instance = new Request();
//        instance.setStatus(status);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSpecialReason method, of class Request.
     */
    @Test
    public void testGetSpecialReason() {
        System.out.println("Testing get special reason");
        assertEquals(specialReason, specialLeave.getSpecialReason());
    }

    /**
     * Test of setSpecialReason method, of class Request.
     */
//    @Test
//    public void testSetSpecialReason() {
//        System.out.println("setSpecialReason");
//        String specialReason = "";
//        Request instance = new Request();
//        instance.setSpecialReason(specialReason);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}