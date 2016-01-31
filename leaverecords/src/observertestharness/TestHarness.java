/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observertestharness;

import java.util.Date;
import java.util.GregorianCalendar;
import staffdatamodel.LeaveRecord;
import staffdatamodel.LeaveStatusType;
import staffdatamodel.LeaveType;
import staffdatamodel.Request;
import staffdatamodel.StaffList;
import staffdatamodel.StaffMember;

/**
 * IObserver test harness; used to ensure that every method in every class
 * that should return a state change, does. 
 * State change refers to an instance where a value has been changed; called by the AnObserver class.
 * 
 * @author AStevenson
 */
public class TestHarness {

    private Request[] requests; 
    private int noOfRequests;
    private Request addedRequest;
    private StaffList list;
    private LeaveRecord record;
    
    /**
     * Tests for the class "Request"; each method is tested using two request objects
     * Methods: setters
     */
    public void executeRequestTests()
    {
        Date requestStart;
        requestStart = (new GregorianCalendar(2012, 10, 30)).getTime();
        
        System.out.println("Testing IObserver for class : Requests\nUsing:\nTwo request objects");
        Request objRequest1 = new Request();
        Request objRequest2 = new Request(LeaveType.SICK, requestStart, 2 );
        System.out.println("\nRequests made!");
        
        System.out.println("Creating an observer and registering the requests...");
        IObserver observer = new AnObserver();
        objRequest1.registerObserver(observer);
        objRequest2.registerObserver(observer);
        System.out.println("Observer created and registered with each request...");
        
        // SETTER Tests
        System.out.println("SETTING the duration of the first request...");
        objRequest1.setDuration(23);
        System.out.println("SETTING the status for the first request...");
        objRequest1.setStatus(LeaveStatusType.PENDING);
        System.out.println("SETTING the duration for the second request...");
        objRequest2.setDuration(12);
        System.out.println("SETTING the start date for the second request...");
        objRequest2.setStartDate(requestStart);
        System.out.println("SETTING the special reason for the second request...");
        objRequest2.setSpecialReason("No Special Reason");
        System.out.println("---------------------");
    }
    
    /**
     * Tests for the class "StaffMember"; each method is tested using Seven Request objects,
     * and two StaffMember objects
     * Methods: addRequest, approveRequest, declineRequest, clearAllLeave and setters
     */ 
   public void executeStaffMemberTests()
    {
        
        noOfRequests = 6;
        requests = new Request[noOfRequests];
        requests[0] = new Request(LeaveType.ANNUAL, (new Date()), 1);
        requests[1] = new Request(LeaveType.ANNUAL, (new Date()), 2);
        requests[2] = new Request(LeaveType.SICK, (new Date()), 3);
        requests[3] = new Request(LeaveType.SICK, (new Date()), 4);
        requests[4] = new Request((new Date()), 5, "Special request 1");
        requests[5] = new Request((new Date()), 6, "Special request 2");
        addedRequest = new Request(LeaveType.ANNUAL, (new Date()), 10);
        
        System.out.println("Testing IObserver for class: StaffMember\nUsing:\nSeven request objects\nTwo StaffMember objects");
        StaffMember objStaffMember = new StaffMember();
        StaffMember objStaffMember2 = new StaffMember("Adam", "Stevenson", "HR");
        
        System.out.println("\nStaffMembers made!");
        System.out.println("Creating an observer and registering the StaffMembers...");
        IObserver observer = new AnObserver();
        objStaffMember.registerObserver(observer);
        objStaffMember2.registerObserver(observer);
        System.out.println("Observer created and registered with each StaffMember...");
        
        //Testing addrequest method in StaffMember Class
        System.out.println("ADDING LeaveRecord Requests (testing addRequest)");
        objStaffMember.addRequest(requests[0]);
        objStaffMember.addRequest(requests[1]);
        objStaffMember.addRequest(requests[2]);
        objStaffMember2.addRequest(requests[3]);
        objStaffMember2.addRequest(requests[4]);
        objStaffMember2.addRequest(requests[5]);
        objStaffMember2.addRequest(addedRequest);
        
        //Testing approverequest method in StaffMember Class
        System.out.println("APPROVING LeaveRecord Requests (testing approveRequest)");
        objStaffMember.approveRequest(0);
        objStaffMember.approveRequest(1);
        objStaffMember.approveRequest(2);
        objStaffMember2.approveRequest(0);
        objStaffMember2.approveRequest(1);
        objStaffMember2.approveRequest(2);
        objStaffMember2.approveRequest(3); // addedRequest
        
        //Testing declinerequest method in StaffMember Class
        System.out.println("DECLINING LeaveRecord Requests (testing declineRequest)");
        objStaffMember.declineRequest(0);
        objStaffMember.declineRequest(1);
        objStaffMember.declineRequest(2);
        objStaffMember2.declineRequest(0);
        objStaffMember2.declineRequest(1);
        objStaffMember2.declineRequest(2);
        objStaffMember2.declineRequest(3); // addedRequest
        
        //Testing clearAllLeave
        System.out.println("CLEARING all leave (testing clearAllLeave)");
        objStaffMember.clearAllLeave();
        objStaffMember2.clearAllLeave();
        
        //Testing StaffMember Class setters (only dept)
        System.out.println("SETTING the department of the second StaffMember...");
        objStaffMember2.setDept("HR");
        System.out.println("---------------------");  
    }
    
    /**
     * Tests for the class "Person"; each method is tested using Two StaffMember objects,
     * and two StaffMember objects
     * Methods: setters
     */ 
    public void executePersonTests()
    {
        System.out.println("Testing IObserver for class: Person\nUsing:\nTwo StaffMember objects");
        StaffMember objStaffMember = new StaffMember();
        StaffMember objStaffMember2 = new StaffMember("Adam", "Stevenson", "HR");
        
        System.out.println("\nStaffMembers made!");
        System.out.println("Creating an observer and registering the StaffMembers...");
        IObserver observer = new AnObserver();
        objStaffMember.registerObserver(observer);
        objStaffMember2.registerObserver(observer);
        System.out.println("Observer created and registered with each StaffMember...");
        
        //SETTER Tests - Extending to the Person Class
        System.out.println("SETTING the surname of the first StaffMember...");
        objStaffMember.setSurname("Edgecombe");
        System.out.println("SETTING the first name of the second StaffMember...");
        objStaffMember2.setForename("Brian");
        System.out.println("---------------------");
    }
    
    /**
     * Tests for the class "StaffList"; each method is tested using one StaffList ArrayList, and two StaffMember objects,
     * and two StaffMember objects
     * Methods: addStaff, removeStaffAt
     */ 
    public void executeStaffListTests()
    {
        // Initialise StaffList Members
        
        System.out.println("Testing IObserver for class: StaffList\nUsing:\nOne StaffList ArrayList\nTwo StaffMembers");
        
        System.out.println("Creating an observer and registering the StaffList ArrayList...");
        IObserver observer = new AnObserver();
        list = new StaffList();
        list.registerObserver(observer);
        System.out.println("Observer created and registered with the StaffList ArrayList...");
        
        //Testing addStaff method
        System.out.println("\nADDING Stafflist Members to the ArrayList (testing addStaff)");
        list.addStaff(new StaffMember());
        list.addStaff(new StaffMember("Sam","Lusby","IT"));
        
        //Testing removeStaffAt method
        System.out.println("REMOVING Stafflist Members from the ArrayList (testing removeStaffAt)");
        list.removeStaffAt(1);
        list.removeStaffAt(0);
        
        System.out.println("---------------------");
    }
    
    /**
     * Tests for the class "LeaveRecord"; each method is tested using one LeaveRecord ArrayList, and seven Request objects,
     * and two StaffMember objects
     * Methods: setters
     */ 
    public void executeLeaveRecordTests()
    {
        
        noOfRequests = 6;
        requests = new Request[noOfRequests];
        requests[0] = new Request(LeaveType.ANNUAL, (new Date()), 1);
        requests[1] = new Request(LeaveType.ANNUAL, (new Date()), 2);
        requests[2] = new Request(LeaveType.SICK, (new Date()), 3);
        requests[3] = new Request(LeaveType.SICK, (new Date()), 4);
        requests[4] = new Request((new Date()), 5, "Special request 1");
        requests[5] = new Request((new Date()), 6, "Special request 2");
        addedRequest = new Request(LeaveType.ANNUAL, (new Date()), 10);
        
        
        System.out.println("Testing IObserver for class: LeaveRecord\nUsing:\nOne LeaveRecord ArrayList\nSeven Request Objects");
        System.out.println("Creating an observer and registering the LeaveRecord ArrayList...");
        IObserver observer = new AnObserver();
        record = new LeaveRecord();
        record.registerObserver(observer);
        System.out.println("Observer created and registered with the LeaveRecord ArrayList...");
        
        //Testing addRequest method
        System.out.println("\nADDING LeaveRecord requests (testing addRequest)");
        record.addRequest(requests[0]);
        record.addRequest(requests[1]);
        record.addRequest(requests[2]);
        record.addRequest(requests[3]);
        record.addRequest(requests[4]);
        record.addRequest(requests[5]);
        record.addRequest(addedRequest);
        
        //Testing approveRequest method - two state returns where leaveType is "annual"
        System.out.println("APPROVING LeaveRecord requests (testing approveRequest)");
        record.approveRequest(0);
        record.approveRequest(1); 
        record.approveRequest(2);
        record.approveRequest(3);
        record.approveRequest(4); 
        record.approveRequest(5); 
        record.approveRequest(6); 
        
        //Testing declineRequest method
        System.out.println("DECLINING LeaveRecord requests (testing approveRequest)");
        record.declineRequest(0);
        record.declineRequest(1); 
        record.declineRequest(2);
        record.declineRequest(3);
        record.declineRequest(4); 
        record.declineRequest(5); 
        record.declineRequest(6);
        
        System.out.println("---------------------");
    }
    
    /**
     * Method designed to override the update method located in IObserver; confirms state
     * changes within TestHarness methods
     */ 
     private class AnObserver implements IObserver
    {
        @Override
        public void update() {
            System.out.println("State Change was detected!");
        }
    }
}
