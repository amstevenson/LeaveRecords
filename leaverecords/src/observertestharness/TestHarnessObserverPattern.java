/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observertestharness;

/**
 * Used to execute the TestHarness methods that ensure that the 
 * IObserver design pattern works correctly and efficiently.
 * 
 * @author AStevenson
 */
public class TestHarnessObserverPattern {
    
    /**
     * Methods ran from within TestHarness.java: 
     * executeRequestTests, executeStaffMemberTests, executePersonTests,
     * executeStaffListTests, and executeLeaveRecordTests.
     * 
     * @author AStevenson
     */
     public static void main(String[] args) {
        TestHarness objTester = new TestHarness();
        objTester.executeRequestTests();
        objTester.executeStaffMemberTests();
        objTester.executePersonTests();
        objTester.executeStaffListTests();
        objTester.executeLeaveRecordTests();
    }
    
}
