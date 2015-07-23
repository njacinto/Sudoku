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
public abstract class BoardTest {
    
    protected abstract Board getBoard();
    
    protected Board getBoard(BoardValue ... values){       
        Board board = getBoard();
        for(BoardValue value : values){
            board.setValue(value.getRow(), value.getColumn(), value.getValue());
        }
        return board;
    }
    
    public BoardTest() {
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
     * Test of getSize method, of class BoardImpl.
     */
    @Test
    public abstract void testGetLength();

    /**
     * Test of getArea method, of class Board.
     */
    @Test
    public abstract void testGetArea();

    /**
     * Test of getInnerBoxLength method, of class Board.
     */
    @Test
    public abstract void testGetInnerBoxLength();
    
    /**
     * Test of getPossibleValues method, of class BoardImpl.
     */
    @Test
    public abstract void testGetPossibleValues();

    
    /**
     * Test of countEmpty method, of class BoardImpl.
     */
    @Test
    public void testCountEmpty() {
        Board instance = getBoard();
        int expResult = instance.getArea();
        int result = instance.countEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFilled method, of class BoardImpl.
     */
    @Test
    public void testIsEmpty() {
        int row = 0;
        int column = 0;
        Board instance = getBoard();
        boolean expResult = true;
        boolean result = instance.isEmpty(row, column);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty_NotEmpty() {
        int row = 0;
        int column = 0;
        Board instance = getBoard();
        int[] value = instance.getPossibleValues(row, column);
        instance.setValue(row, column, value[0]);
        boolean expResult = false;
        boolean result = instance.isEmpty(row, column);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class BoardImpl.
     */
    @Test
    public void testSetValue() {
        int row = 0;
        int column = 0;
        Board instance = getBoard();
        int[] values = instance.getPossibleValues(row, column);
        instance.setValue(row, column, values[0]);
        assertEquals(values[0], instance.getValue(row, column));
    }

    /**
     * Test of clear method, of class Board.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Board instance = getBoard();
        int[] values = instance.getPossibleValues(0, 0);
        instance.setValue(0, 0, values[0]);
        instance.clear();
        assertEquals(instance.getArea(), instance.countEmpty());
    }

    /**
     * Test of clearCell method, of class BoardImpl.
     */
    @Test
    public void testClear_Cell() {
        int row = 0;
        int column = 0;
        Board instance = getBoard();
        int[] values = instance.getPossibleValues(row, column);
        instance.setValue(row, column, values[0]);
        assertEquals(values[0], instance.getValue(row, column));
        instance.clear(row, column);
        assertTrue(instance.isEmpty(row, column));
    }

    /**
     * Test of getCellValue method, of class BoardImpl.
     */
    @Test
    public void testGetValue() {
        int row = 0;
        int column = 0;
        Board instance = getBoard();
        int[] values = instance.getPossibleValues(row, column);
        instance.setValue(row, column, values[0]);
        assertEquals(values[0], instance.getValue(row, column));
    }


    /**
     * Test of getNumber method, of class Board.
     */
    @Test
    public void testGetNumber() {
        Board instance = getBoard();
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class Board.
     */
    @Test
    public void testSetNumber() {
        int number = 1;
        Board instance = getBoard();
        instance.setNumber(number);
        assertEquals(number, instance.getNumber());
    }

    /**
     * Test of clone method, of class Board.
     */
    @Test
    public void testClone() {
        Board instance = getBoard();
        Board result = instance.clone();
        assertTrue(instance.equals(result));
    }

    /**
     * Test of equals method, of class Board.
     */
    @Test
    public void testEquals() {
        int row = 0;
        int column = 0;
        int number = 1;
        Board obj = getBoard();
        Board instance = getBoard();
        int[] values = instance.getPossibleValues(row, column);
        instance.setValue(row, column, values[0]);
        obj.setValue(row, column, values[0]);
        assertTrue(instance.equals(obj));
        obj.setValue(row, column, values[1]);
        assertFalse(instance.equals(obj));
        obj.setValue(row, column, values[0]);
        obj.setNumber(number);
        assertFalse(instance.equals(obj));
    }

    /**
     * Test of hashCode method, of class Board.
     */
    @Test
    public void testHashCode() {
        Board instance = getBoard();
        int result = instance.hashCode();
    }
    
}
