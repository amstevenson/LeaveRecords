/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leaverecords.commands;

import command.interfaces.ICommandBehaviour;
import staffdatamodel.StaffList;
import staffdatamodel.StaffMember;

/**
 *
 * @author adam
 */
public class DeleteStaffMemberCommand implements ICommandBehaviour {
    
    private StaffMember objToDelete;
    private int objTargetIndex;
    private StaffList objTargetStaffList = null;
    
    
    public DeleteStaffMemberCommand(StaffList objNewTargetStaffList,
            StaffMember objToDelete, int objTargetIndex){
        
        this.objToDelete = objToDelete;
        this.objTargetIndex = objTargetIndex;
        this.objTargetStaffList = objNewTargetStaffList;
        
    }
    
    
    
    private Boolean isValid(){
        
        Boolean blnValid = false;
        if(null != this.objTargetStaffList){
            blnValid = true;
        }
        return blnValid;
        
    }
    
    @Override
    public Boolean doCommand(){
        
        Boolean blnCompleted = false;
        
        if(this.isValid()){
            if(this.objTargetIndex < this.objTargetStaffList.size() ){
            this.objTargetStaffList.removeStaffAt(this.objTargetIndex);
            blnCompleted = true;
            }
        }
        
        return blnCompleted;
    }
    
    @Override
    public Boolean undoCommand(){
        Boolean blnCompleted = false;
        if(this.isValid()){ 
           this.objTargetStaffList.addStaff(this.objToDelete);
           blnCompleted = true;
        }
        return blnCompleted;
    }
    
}
