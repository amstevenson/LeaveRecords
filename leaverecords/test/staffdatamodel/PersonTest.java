/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdatamodel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rtucker
 */
public class PersonTest {
    private Person generalTest;
    
    private String firstNameValue;
    private String surnameValue;
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        firstNameValue = "Annie";
        surnameValue = "Oakley";

        generalTest = new PersonImpl(firstNameValue, surnameValue);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetForename() {
        System.out.println("Testing getFirstName");
        assertEquals(firstNameValue, generalTest.getForename());
    }

    @Test
    public void testSetForename() {
        System.out.println("Testing setFirstName");
        String newValue = "Zoe";
        generalTest.setForename(newValue);
        assertEquals(newValue, generalTest.getForename());
        generalTest.setForename(firstNameValue);
    }

    @Test
    public void testGetSurname() {
        System.out.println("Testing getSurname");
        assertEquals(surnameValue, generalTest.getSurname());
    }

    @Test
    public void testSetSurname() {
        System.out.println("Testing setSurame");
        String newValue = "Clark";
        generalTest.setSurname(newValue);
        assertEquals(newValue, generalTest.getSurname());
        generalTest.setSurname(surnameValue);
    }

    /**
     * Test of getFullName method, of class Person.
     */
    @Test
    public void testGetFullName() {
        System.out.println("Testing getFullName");
        assertEquals(surnameValue + ", " + firstNameValue,
                generalTest.getFullName());
    }
    
    @Test
    public void testToString() {
        System.out.println("toString() not tested");
    }

    public class PersonImpl extends Person {
        
        public PersonImpl(){
            super();
        }
        
        public PersonImpl(String forename, String surname) {
            super(forename, surname);
        }
    }
}