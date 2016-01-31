/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;
import java.io.Serializable;
import java.util.ArrayList;
import observertestharness.IObserverFunctions;

/**
 * Holds a collection of staff members. It has an ArrayList of StaffMember objects.
 * The ArrayList has neither a set method nor a get method. 
 * 
 * @author AStevenson
 */
public class StaffList extends IObserverFunctions implements Serializable{
    
   private ArrayList<StaffMember> list;
   
    /**
     * Default (empty) constructor creates a new (empty) list of staff.
     */
   public StaffList(){ // initialise ArrayList
       this.list = new ArrayList<>();
   }
    
    /**
     * Accessor to add the provided StaffMember object to the list of staff members
     * @param newStaff - The StaffMember object to add to the list.
     */
   public void addStaff(StaffMember newStaff){
       if (newStaff!= null){ // check that the new member is not an empty value
           this.list.add(newStaff);
           newStaff.registerObserver(this);
           this.notifyObservers();
       }
   }
   
    /**
     * Accessor to remove a staff member from the staff list. The index parameter
     * identifies the staff member to be removed.
     * @param index - A zero based index value specifying the staff member to 
     * remove from the list
     * @return The StaffMember object removed from the list OR NULL if the index value
     * was invalid.
     */
   public StaffMember removeStaffAt(int index){
        StaffMember result = null;
        if(index >= 0 && index < this.list.size()){
            result = this.list.remove(index);
            result.removeObserver(this);
            this.notifyObservers();
        }
        return result;
   }

    /**
     * This method creates a string array containing all the names of the current
     * staff members in the format "forename surname"
     * @return A String array of staff member names.
     */
   public String[] getAllNames(){
       String[] allNames = new String[list.size()];

       try
       {
           for (int i = 0; i < list.size(); i++)
           {
               StaffMember tempName = this.list.get(i);
               allNames[i] = tempName.getFullName();
           }
           return allNames; // return string array containing full names
       }
       catch (Exception e) 
       {
           return null;
       }
   }
   
     /**
     * Accessor to retrieve the StaffMember item specified by the index parameter
     * @param index - A zero based index value specifying the item required from the list
     * @return - The staff member at the specified index or NULL if no staff
     * member can be found.
     */
   public StaffMember getStaffAt(int index){
        StaffMember result = null;
        if(index >= 0 && index < this.list.size()){
            result = this.list.get(index);
        }
        return result;         
   }
    
    /**
     * Retrieves the number of staff members in the list
     * @return the size of the list ArrayList (number of staff members)
     */
    public int size(){
        return this.list.size();
    }
    
   /*
    * Returns a string, that includes all the staff list details
    */
    @Override
    public String toString() {
        return "StaffList{" + "list=" + list + '}';
    }
    
}
