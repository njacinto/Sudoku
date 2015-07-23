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
public class SolutionErrorsTest {
    
    public SolutionErrorsTest() {
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
     * Test of hasErrors method, of class SolutionErrors.
     */
    @Test
    public void testHasErrors() {
        SolutionErrors instance = new SolutionErrors();
        boolean expResult = false;
        boolean result = instance.hasErrors();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasErrors_True() {
        SolutionErrors instance = new SolutionErrors(new int[]{1}, new int[0], new int[0]);
        boolean expResult = true;
        boolean result = instance.hasErrors();
        assertEquals(expResult, result);
    }

    /**
     * Test of countErrors method, of class SolutionErrors.
     */
    @Test
    public void testCountErrors() {
        SolutionErrors instance = new SolutionErrors(new int[]{1}, new int[0], new int[0]);
        int expResult = 1;
        int result = instance.countErrors();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCountErrors_Zero() {
        SolutionErrors instance = new SolutionErrors();
        int expResult = 0;
        int result = instance.countErrors();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumnsWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testGetColumnsWithErrors() {
        int[] empty = new int[0];
        int[] cols = new int[]{1};
        SolutionErrors instance = new SolutionErrors(empty, cols, empty);
        int[] expResult = cols;
        int[] result = instance.getColumnsWithErrors();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInnerTablesWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testGetInnerTablesWithErrors() {
        int[] empty = new int[0];
        int[] innerTable = new int[]{1};
        SolutionErrors instance = new SolutionErrors(empty, empty, innerTable);
        int[] expResult = innerTable;
        int[] result = instance.getInnerTablesWithErrors();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getRowsWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testGetRowsWithErrors() {
        int[] empty = new int[0];
        int[] rows = new int[]{1};
        SolutionErrors instance = new SolutionErrors(rows, empty, empty);
        int[] expResult = rows;
        int[] result = instance.getRowsWithErrors();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setColumnsWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testSetColumnsWithErrors() {
        int[] cols = new int[]{1};
        SolutionErrors instance = new SolutionErrors();
        instance.setColumnsWithErrors(cols);
        assertArrayEquals(cols, instance.getColumnsWithErrors());
    }

    /**
     * Test of setInnerTablesWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testSetInnerTablesWithErrors() {
        int[] innerTables = new int[]{1};
        SolutionErrors instance = new SolutionErrors();
        instance.setInnerTablesWithErrors(innerTables);
        assertArrayEquals(innerTables, instance.getInnerTablesWithErrors());
    }

    /**
     * Test of setRowsWithErrors method, of class SolutionErrors.
     */
    @Test
    public void testSetRowsWithErrors() {
        int[] rows = new int[]{1};
        SolutionErrors instance = new SolutionErrors();
        instance.setRowsWithErrors(rows);
        assertArrayEquals(rows, instance.getRowsWithErrors());
    }

    /**
     * Test of equals method, of class SolutionErrors.
     */
    @Test
    public void testEquals() {
        int[] rows = new int[]{1};
        int[] cols = new int[]{2,3};
        int[] innerTables = new int[]{4,5,6};
        Object obj = new SolutionErrors(rows, cols, innerTables);
        SolutionErrors instance = new SolutionErrors();
        instance.setColumnsWithErrors(cols);
        instance.setInnerTablesWithErrors(innerTables);
        instance.setRowsWithErrors(rows);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals_Not() {
        int[] rows = new int[]{1};
        int[] cols = new int[]{2,3};
        int[] innerTables = new int[]{4,5,6};
        Object obj = new SolutionErrors(cols, rows, innerTables);
        SolutionErrors instance = new SolutionErrors();
        instance.setColumnsWithErrors(cols);
        instance.setInnerTablesWithErrors(innerTables);
        instance.setRowsWithErrors(rows);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class SolutionErrors.
     */
    @Test
    public void testHashCode() {
        SolutionErrors instance = new SolutionErrors();
        int result = instance.hashCode();
    }

    /**
     * Test of toString method, of class SolutionErrors.
     */
    @Test
    public void testToString() {
        SolutionErrors instance = new SolutionErrors(new int[]{1}, new int[]{2}, new int[]{3});
        String result = instance.toString();
        assertTrue(result!=null && !result.isEmpty());
    }
    
}
