/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author nuno
 */
public class DefaultBoardTest extends BoardTest {
    
    @Override
    protected Board getBoard(){  
        return new DefaultBoard();
    }

    /**
     * Test of getSize method, of class BoardImpl.
     */
    @Test
    @Override
    public void testGetLength() {
        Board instance = getBoard();
        int expResult = 9;
        int result = instance.getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleValues method, of class BoardImpl.
     */
    @Test
    @Override
    public void testGetPossibleValues() {
        int row = 4;
        int column = 4;
        Board instance = getBoard(new BoardValue(3, 3, 1),
                new BoardValue(3, 4, 2), new BoardValue(3, 5, 3),
                new BoardValue(4, 3, 4), new BoardValue(5, 5, 5));
        int[] expResult = new int[]{6,7,8,9};
        int[] result = instance.getPossibleValues(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetOptionsForCell_Row() {
        int row = 4;
        int column = 4;
        Board instance = getBoard(new BoardValue(row, 0, 1),
                new BoardValue(row, 1, 2), new BoardValue(row, 2, 3),
                new BoardValue(row, 3, 4), new BoardValue(row, 5, 5),
                new BoardValue(row, 6, 6), new BoardValue(row, 7, 7),
                new BoardValue(row, 8, 8));
        int[] expResult = new int[]{9};
        int[] result = instance.getPossibleValues(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetOptionsForCell_Row2() {
        int row = 4;
        int column = 6;
        Board instance = getBoard(new BoardValue(row, 0, 6),
                new BoardValue(row, 1, 8), 
                new BoardValue(row, 3, 9), new BoardValue(row, 4, 7));
        int[] expResult = new int[]{1,2,3,4,5};
        int[] result = instance.getPossibleValues(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetOptionsForCell_Column() {
        int row = 4;
        int column = 4;
        Board instance = getBoard(new BoardValue(0, column, 1),
                new BoardValue(1, column, 2), new BoardValue(2, column, 3),
                new BoardValue(3, column, 4), new BoardValue(5, column, 5),
                new BoardValue(6, column, 6), new BoardValue(7, column, 7),
                new BoardValue(8, column, 8));
        int[] expResult = new int[]{9};
        int[] result = instance.getPossibleValues(row, column);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getArea method, of class DefaultBoard.
     */
    @Test
    @Override
    public void testGetArea() {
        DefaultBoard instance = new DefaultBoard();
        int expResult = 81;
        int result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInnerBoxLength method, of class DefaultBoard.
     */
    @Test
    @Override
    public void testGetInnerBoxLength() {
        DefaultBoard instance = new DefaultBoard();
        int expResult = 3;
        int result = instance.getInnerBoxLength();
        assertEquals(expResult, result);
    }
}
