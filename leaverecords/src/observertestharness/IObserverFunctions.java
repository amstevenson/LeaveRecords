/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observertestharness;

import java.util.ArrayList;

/**
 * An interface that allows a class to implement the functions of the 
 * "ISubject" class.
 * 
 * @author AStevenson
 */
public class IObserverFunctions implements ISubject, IObserver {
    
    private ArrayList<IObserver> observers = null;

    /**
     * Retrieve all observers from the ArrayList arlResult
     * @return 
     * 
     */
    public ArrayList<IObserver> getObservers(){
    
        ArrayList<IObserver> arlResult = new ArrayList<>();
        for (IObserver currObserver : observers){
            arlResult.add(currObserver);
        }
        return arlResult;
    }
       
    
    /**
     * Method for registering an observer; if an ArrayList is not initialised, it is 
     * done so within the method. 
     * @return True or false, dependant on whether the observer was successfully registered
     * 
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;                   //Assume this method will fail
        //Validate that observer exists
        if (o != null) {
            //If observer list not initialised create it
            if (this.observers == null){
                this.observers = new ArrayList<>();
            }
            //Add the observer to the list of registered observers if not already registered
            if(!this.observers.contains(o)){
                blnAdded = this.observers.add(o);
            }
        }
        //Return the result
        return blnAdded;
        }

    /**
     * Method for removing an observer; if the observer ArrayList is null, returns false
     * done so within the method. 
     * @return True or false, dependant on whether the observer was successfully removed; de-registered
     * 
     */
    @Override
    public Boolean removeObserver(IObserver o)
    {
        Boolean blnRemoved = false;
        //Validate we have something to remove
        if (o != null)
        {
            if (this.observers != null && this.observers.size() > 0)
            {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    /**
     * Call an update on each observer
     * 
     */
    @Override
    public void notifyObservers()
    {
        //Ensure we have a valid list of observers
        if (this.observers != null && this.observers.size() > 0)
        {
            //Start foreach loop
            for (IObserver currentObserver : this.observers)
            {
                //Call update on this observer
                currentObserver.update();
            }
        }
    }

    /**
     * Method designed to call updates for each observer
     * 
     */
    @Override
    public void update()
    {
        this.notifyObservers();
    }  
}
