/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.io.Serializable;

/**
 * Enumeration of available status types
 * 
 * @author AStevenson
 */
    public enum LeaveStatusType implements Serializable
    {
      /**
        * This status indicates that a leave request is held pending approval by a manager
        */
        PENDING,
       /**
         * This status indicates that a leave request has been approved by a manager
         */
        APPROVED,
      /**
        * This status indicates that a leave request has been declined by a manager
        */
        DECLINED;

        @Override
        public String toString()
        {
            String strResult = "";
            switch (this)
            {
                case PENDING:
                    strResult = "Pending";
                    break;
                case APPROVED:
                    strResult = "Approved";
                    break;
                case DECLINED:
                strResult = "Declined";
                break;
            }
            return strResult;
        }
    }
