/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;
import java.io.Serializable;
import java.util.ArrayList;
import observertestharness.IObserverFunctions;

/**
 * This class holds the details of all the requests made
 * by the member of staff with which it is associated. 
 * 
 * @author AStevenson
 */
public class LeaveRecord extends IObserverFunctions implements Serializable  {
    
    private int daysLeft;
    public static final int ALLOWANCE = 25; // constant; always 25
    private ArrayList<Request> requests = null;
    
    /**
     * Creates a new, empty ArrayList<Request> object and sets the days
     * left to the standard leave allocation (see the relevant class constant).
     */
    public LeaveRecord(){ 
        this.requests = new ArrayList<>();
        this.daysLeft = ALLOWANCE; 
    }
    
    /**
     * Adds the provided request to the leave records list of requests
     * @param newRequest - A Request object being the leave request to add 
     * to the list
     */
    public void addRequest(Request newRequest){
        if (newRequest !=null){
            this.requests.add(newRequest); 
            this.notifyObservers(); 
            newRequest.registerObserver(this);
        }  
    }
    
    /**
     * 
     * Accessor to retrieve the leave request item specified by the index parameter
     * @param index - A zero based index value specifying the item required from the list
     * @return - The leave request at the specified index or NULL if no request
     * can be found.
     */
    public Request getRequestAt(int index){
        Request result = null;
        if(index >= 0 && index < this.requests.size()){
            result = this.requests.get(index);
        }
        return result;
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
    public void approveRequest(int index){
       Request thisRequest = this.requests.get(index);
       thisRequest.setStatus(LeaveStatusType.APPROVED); 

       if (thisRequest.getLeaveType() == LeaveType.ANNUAL)
       {
            int leaveLeft = thisRequest.getDuration(); 
            this.daysLeft = daysLeft - leaveLeft; 
       }
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
       Request thisRequest = this.requests.get(index);
          
       if (thisRequest.getLeaveType() == LeaveType.ANNUAL &&
           thisRequest.getStatus() == LeaveStatusType.APPROVED)
       {
           int leaveLeft = thisRequest.getDuration(); 
           this.daysLeft = daysLeft + leaveLeft;   
           thisRequest.setStatus(LeaveStatusType.DECLINED); 
       }
       else
       {
          thisRequest.setStatus(LeaveStatusType.DECLINED); 
       }
   }
   
    /**
     * Removes all leave requests made so far and resets the number of available
     * annual leave days to the annual entitlement defined by the class
     * constant ALLOWANCE
     */
    public void clearAll(){
        for(Request currRequest : this.requests){
            currRequest.removeObserver(this);
        }
        this.requests.clear();
        this.daysLeft = LeaveRecord.ALLOWANCE;
        this.notifyObservers();
    }
    
    /**
     * Accessor to retrieve the total number of leave requests that have been made
     * @return - An int being the total number of leave requests recorded on the 
     * Leave Record
     */
    public int size(){
        return requests.size();
    }
    
    
    /**
     * Accessor to retrieve the total number of un-used annual leave days
     * @return - int being the number of remaining days that the employee is
     * entitled to as annual leave.
     */
    public int getDaysLeft(){
        return daysLeft;
    }

   /*
    * Returns a string, that includes all the leave record details
    */
    @Override
    public String toString() {
        return "LeaveRecord{" + "requests=" + requests + ", daysLeft=" + daysLeft + '}';
    }
}
