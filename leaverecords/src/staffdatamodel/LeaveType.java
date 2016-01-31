/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.io.Serializable;

/**
 * Enumeration of available leave types
 * 
 * @author AStevenson
 */
    public enum LeaveType implements Serializable
    {
        
        /**
         * This leave type represents leave taken from an employee's annual leave allowance
         */
        ANNUAL,
       /**
        * This leave type represents leave granted for special reasons (maternity or
        * death in the family would be examples). Leave of this type does not reduce 
        * the employee's total annual leave allowance.
        */
        SPECIAL,
       /**
        * This leave type represents leave taken on medical grounds. Leave of this 
        * type does not reduce the employee's total annual leave allowance.
        */
        SICK;

        @Override
        public String toString() {
            String result = "UNKNOWN";
            switch(this){
                case ANNUAL:
                    result = "ANNUAL";
                    break;
                case SPECIAL:
                    result = "SPECIAL";
                    break;
                case SICK:
                    result = "SICK";
                    break;
            }
            return result;
        }
    }
    
    

