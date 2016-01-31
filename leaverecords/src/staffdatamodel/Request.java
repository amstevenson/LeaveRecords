/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import observertestharness.IObserverFunctions;

/**
 * A class to hold details for a leave request
 * Note: leaveType is read-only
 * 
 * @author AStevenson
 */
public class Request extends IObserverFunctions implements Serializable{
    
    private LeaveType leaveType;
    private Date startDate;
    private int duration;
    private LeaveStatusType status;
    private String specialReason;
    
    /**
     * Default (empty) constructor creates a PENDING leave request for ANNUAL
     * leave of one day starting today with no special reason for the leave.
     */
    public Request(){ 
        this.leaveType = LeaveType.ANNUAL;
        this.startDate = new Date();
        this.duration = 1;
        this.status = LeaveStatusType.PENDING;
        this.specialReason = "NONE"; 
    }
   
    /**
     * Constructor that creates a PENDING leave request with no special reason
     * for the leave request. The leave requests type, start date and duration
     * will be set from the provided parameters.
     *
     * @param leaveType - LeaveType enumerated value describing the type of
     * leave requested
     * @param startDate - A Date on which the leave request will start
     * @param duration - The duration in days that the employee will be absent
     */
    public Request(LeaveType leaveType,Date startDate,int duration){
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.duration = duration;
        this.status = LeaveStatusType.PENDING;
        this.specialReason = "NONE";
    }
    
    /**
     * Constructor that creates a PENDING leave request for SPECIAL leave for a
     * special reason. The leave requests start date, duration and special
     * reason will be set from the provided parameters
     *
     * @param startDate - A Date on which the leave request will start
     * @param duration - The duration in days that the employee will be absent
     * @param specialReason - String describing the special reason for the
     * leave.
     */
    public Request(Date startDate,int duration,String specialReason){
        this.startDate = startDate;
        this.duration = duration;
        this.specialReason = specialReason;
        this.leaveType = LeaveType.SPECIAL;
        this.status = LeaveStatusType.PENDING;
    }
    
    /**
     * This method marks this leave request as APPROVED by the employee's line
     * manager
     */
    public void approve(){
        this.status = LeaveStatusType.APPROVED;
        this.notifyObservers();
    }

    /**
     * This method marks this leave request as DECLINED by the employee's line
     * manager
     */
    public void decline(){
        this.status = LeaveStatusType.DECLINED;
        this.notifyObservers();
    }
    
    /**
    * sets the status to pending
    */
    public void reset(){
        this.status = LeaveStatusType.PENDING;
        this.notifyObservers();
    }
    
    /**
     * Accessor method that retrieves the date on which this leave request start
     * as a string suitable for display in the format dd/MM/yyyy
     *
     * @return A String representing the date on which the leave starts.
     */
    public String getDateAsString(){
        String result = "";
        if (null != this.startDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            result = formatter.format(this.startDate);
        }
        return result;
    }
    
    /**
     * Accessor to retrieve the enumerated value representing the type of leave
     * requested.
     *
     * @return the LeaveType enumerated value for this request
     */
    public LeaveType getLeaveType() {
        return leaveType;
    }

    /**
     * Accessor to set the enumerated value representing the type of leave
     * requested.
     *
     * @param leaveType the new LeaveType enumerated value to use for this
     * request
     */
    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
        this.notifyObservers();
    }
    
    /**
     * Accessor to retrieve the current approval status for this leave request.
     *
     * @return the requests current status enumeration
     */
    public LeaveStatusType getStatus() {
        return status;
    }

    public void setStatus(LeaveStatusType status) {
        if (status != null){
            this.status = status;
            notifyObservers();
        }
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * Accessor to set the date object encapsulating the date on which the leave
     * is requested to start
     *
     * @param startDate the Date object representing the new date on which this
     * leave request starts.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        this.notifyObservers();
    }

    /**
     * Accessor to retrieve the duration (in days) of the leave request
     *
     * @return - int being the number of days the employee will be absent for
     */
    public int getDuration() {
        return duration;
    }
   
    /**
     * Accessor to set the duration (in days) of the leave request
     *
     * @param duration - int being the number of days the employee will be
     * absent for
     */
    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
            this.notifyObservers();
        } else {
            throw new IllegalArgumentException(
                    "A leave requests duration must be greater than zero days. "
                    + "Tried to set a duration of " + duration + " days.");
        }
    }

    /**
     * Accessor to retrieve the string describing any special reasons for this
     * leave request.
     *
     * @return A String describing any special circumstances associated with
     * this request for leave.
     */
    public String getSpecialReason() {
        return specialReason;
    }

    /**
     * Accessor to set the string describing any special reasons for this leave
     * request.
     *
     * @param specialReason A String describing any special circumstances
     * associated with this request for leave.
     */
    public void setSpecialReason(String specialReason) {
        this.specialReason = specialReason;
        this.notifyObservers();
    }
    
   /*
    * Returns a string, that includes all the request details
    */
    @Override
    public String toString() {
        return "Request{" + "leaveType=" + leaveType + ", startDate=" + startDate
                + ", duration=" + duration + ", status=" + status
                + ", specialReason=" + specialReason + '}';
    }
}
