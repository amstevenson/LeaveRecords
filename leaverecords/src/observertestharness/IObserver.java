/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observertestharness;

/**
 * An interface that allows a class to "observe a subject" and update as the 
 * subject changes state automatically
 * 
 * @author AStevenson
 */
public interface IObserver {

    void update();
}
