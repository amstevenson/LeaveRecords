/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.io.Serializable;
import observertestharness.ISubject;

/**
 * This class describes an object representing one member of staff, obtaining 
 * some of its attributes and methods from its super-class.
 * 
 * @author AStevenson
 */
public class StaffMember extends Person implements ISubject, Serializable{
    
    private String dept;
    private LeaveRecord leaveRecord;
    
    /**
     * Constructor creates a staff member with the specified forename and surname
     * with an empty leave record with full entitlement to the annual leave allowance
     * @param forename - String being staff members forename
     * @param surname - String being staff members surname
     * @param dept - String being staff members dept 
     */
    public StaffMember(){
        super();
        this.leaveRecord = new LeaveRecord(); 
        this.leaveRecord.registerObserver(this);
    }
    
    /**
     * Initialises attributes from parameters where appropriate,
     * creates a new LeaveRecord object. 
     */    
    public StaffMember(String forename, String surname, String dept){
        super(forename, surname);
        this.dept = dept;
        this.leaveRecord = new LeaveRecord();
        this.leaveRecord.registerObserver(this);
    }
    
    /**
     * Adds the provided request to the leave records list of requests
     * @param newRequest - A Request object being the leave request to add 
     * to the list
     */ 
    public void addRequest(Request newRequest){
        this.leaveRecord.addRequest(newRequest);
        this.notifyObservers();
    }
    
    /**
     * Accessor to retrieve the leave request item specified by the index parameter
     * @param index - A zero based index value specifying the item required from the list
     * @return - The leave request at the specified index or NULL if no request
     * can be found.
     */
    public Request getRequestAt(int index){
        if (index <0 || index >= leaveRecord.size()){ 
            return null;
        }
        else{
            Request thisRequest = leaveRecord.getRequestAt(index);
            return thisRequest;
        }    
    }
    
    /**
     * Marks the leave request at the specified index as APPROVED by a manager
     * and if the request is for ANNUAL leave decrements the number of remaining
     * days of annual leave by the duration of the approved request.
     * The approval of an ANNUAL leave request will only succeed if sufficient
     * un-used annual leave allowance is available.
     * @param index - A zero based index value specifying the item to approve 
     * from the list
     */
    public void approveRequest (int index){
        this.leaveRecord.approveRequest(index);
    }

    /**
     * Marks the leave request at the specified index as DECLINED by a manager
     * and if the request is for ANNUAL leave AND HAD ALREADY BEEN APPROVED it 
     * increments the number of remaining days of annual leave by the duration 
     * of the approved request.
     * @param index - A zero based index value specifying the leave request to  
     * decline from the list
     */ 
    public void declineRequest(int index){
        this.leaveRecord.declineRequest(index);
    }
    
    /**
     * Retrieves the number of days left in the staff members leave request
     * @return Returns the number of days left.
     */ 
    public int getDaysLeft(){
        return this.leaveRecord.getDaysLeft(); 
    }
    
    /**
     * Removes all leave requests made so far and resets the number of available
     * annual leave days to the annual entitlement defined by the class
     * constant ALLOWANCE
     */
    public void clearAllLeave(){
        this.leaveRecord.clearAll();
    }
    
    /**
     * Accessor to retrieve the total number of leave requests that have been made
     * @return - An int being the total number of leave requests recorded on the 
     * Leave Record
     */
    public int getNoOfRequests(){
        return this.leaveRecord.size();
    }  
    
    /**
     * Accessor to retrieve the string defining the department in which this
     * staff member works.
     * @return - String being the name of the department in which this 
     * staff member works
     */
    public String getDept() {
        return dept;
    }

    
    /**
     * Accessor to set the string defining the department in which this
     * staff member works.
     * @param dept - String being the name of the department in which this 
     * staff member works
     */
    public void setDept(String dept) {
        this.dept = dept;
        this.notifyObservers();
    }

    @Override
    public void setForename(String forename) {
        super.setForename(forename);
        this.notifyObservers();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
        this.notifyObservers();
    }
    
   /*
    * Returns a string, that includes all the StaffMember details
    */
    @Override
    public String toString() {
        return "StaffMember{" + "dept=" + dept + ", leaveRecord=" + leaveRecord + '}';
    }
}
