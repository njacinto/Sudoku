/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public class BoardValueTest {
    
    public BoardValueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRow method, of class BoardValue.
     */
    @Test
    public void testGetRow() {
        BoardValue instance = new BoardValue();
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRow method, of class BoardValue.
     */
    @Test
    public void testSetRow() {
        int row = 1;
        BoardValue instance = new BoardValue();
        instance.setRow(row);
        assertEquals(row, instance.getRow());
    }

    /**
     * Test of getColumn method, of class BoardValue.
     */
    @Test
    public void testGetColumn() {
        BoardValue instance = new BoardValue();
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColumn method, of class BoardValue.
     */
    @Test
    public void testSetColumn() {
        int column = 1;
        BoardValue instance = new BoardValue();
        instance.setColumn(column);
        assertEquals(column, instance.getColumn());
    }

    /**
     * Test of getValue method, of class BoardValue.
     */
    @Test
    public void testGetValue() {
        BoardValue instance = new BoardValue();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class BoardValue.
     */
    @Test
    public void testSetValue() {
        int value = 1;
        BoardValue instance = new BoardValue();
        instance.setValue(value);
        assertEquals(value, instance.getValue());
    }

    /**
     * Test of equals method, of class BoardValue.
     */
    @Test
    public void testEquals() {
        BoardValue obj = new BoardValue(1,2,3);
        BoardValue instance = new BoardValue();
        instance.setRow(1);
        instance.setColumn(2);
        instance.setValue(3);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class BoardValue.
     */
    @Test
    public void testHashCode() {
        BoardValue instance = new BoardValue();
        int result = instance.hashCode();
    }

    /**
     * Test of toString method, of class BoardValue.
     */
    @Test
    public void testToString() {
        BoardValue instance = new BoardValue(1,2,3);
        String result = instance.toString();
        assertTrue(result!=null && !result.isEmpty());
    }
    
}
