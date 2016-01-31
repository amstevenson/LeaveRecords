/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observertestharness;

/**
 * An interface to make a class a "subject which can be observed"
 * 
 * @author AStevenson
 */
public interface ISubject {
    
    Boolean registerObserver(IObserver o);
    Boolean removeObserver(IObserver o);
    void notifyObservers();
}
