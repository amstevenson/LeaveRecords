/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import java.io.Serializable;
import observertestharness.IObserverFunctions;


/**
 * Person is an abstract class with protected attributes. 
 * 
 * @author AStevenson
 */
public abstract class Person extends IObserverFunctions implements Serializable{
   
    /**
     * Attribute holding the persons forename
     */ 
   protected String forename;
    /**
     * Attribute holding the persons surname
     */
   protected String surname;

    /**
     * Default (no argument) constructor, initialises Forename and Surname attributes as "UNKNOWN"
     */
   public Person(){
        this.forename = "UNKNOWN";
        this.surname = "UNKNOWN";
   }
    
    /**
     * Constructor accepting the forename and surname of the new Person
     * @param forename - String being the new Persons forename
     * @param surname - String being the new Persons surname
     */
   public Person(String forename, String surname){   
    this.forename = forename;
    this.surname = surname;
   }  
   
    /**
     * Retrieves the persons full name formatted as forename surname
     * @return A String being a comma separated concatenation of the surname
     * and forename attributes.
     */
   public String getFullName(){       
    String fullname = surname + ", " + forename;
    return fullname;
   }
   
    /**
     * Accessor to retrieve the persons forename
     * @return - String being the persons forename
     */
   public String getForename() {
        return forename;
    }

    /**
     * Accessor to retrieve the persons surname
     * @return - String being the persons surname
     */
   public String getSurname() {
       return surname;
   }

    /**
     * Accessor to set the persons forename
     * @param forename - String being the persons forename to store
     */
   public void setForename(String forename) {
       this.forename = forename;    
   }

    /**
     * Accessor to set the persons surname
     * @param surname - String being the persons surname to store
     */
   public void setSurname(String surname) {
       this.surname = surname;
   }
   
   /*
    * Returns a string, that includes all the person details
    */
    @Override
    public String toString() {
        return "Person{" + "forename=" + forename + ", surname=" + surname + '}';
    }
}
