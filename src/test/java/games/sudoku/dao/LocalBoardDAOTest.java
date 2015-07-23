/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.dao;

import games.sudoku.NineByNineBoardUtil;
import games.sudoku.model.Board;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public class LocalBoardDAOTest {
    
    public LocalBoardDAOTest() {
    }

    /**
     * Test of getFirst method, of class LocalBoardDAO.
     */
    @Test
    public void testGetFirst() {
        LocalBoardDAO instance = new LocalBoardDAO();
        Board expResult = NineByNineBoardUtil.getCompleteBoard();
        instance.addBoard(expResult);
        instance.addBoard(NineByNineBoardUtil.getIncompleteBoard());
        Board result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class LocalBoardDAO.
     */
    @Test
    public void testGet() {
        int number = 1;
        LocalBoardDAO instance = new LocalBoardDAO();
        Board expResult1 = NineByNineBoardUtil.getCompleteBoard();
        Board expResult2 = NineByNineBoardUtil.getIncompleteBoard();
        instance.addBoard(expResult1);
        instance.addBoard(expResult2);
        Board result = instance.get(number);
        assertEquals(expResult1, result);
        result = instance.get(++number);
        assertEquals(expResult2, result);
    }

    /**
     * Test of getNext method, of class LocalBoardDAO.
     */
    @Test
    public void testGetNext() {
        int number = 0;
        LocalBoardDAO instance = new LocalBoardDAO();
        Board expResult1 = NineByNineBoardUtil.getCompleteBoard();
        Board expResult2 = NineByNineBoardUtil.getIncompleteBoard();
        instance.addBoard(expResult1);
        instance.addBoard(expResult2);
        Board result = instance.getNext(number);
        assertEquals(expResult1, result);
        result = instance.getNext(++number);
        assertEquals(expResult2, result);
    }

    /**
     * Test of count method, of class LocalBoardDAO.
     */
    @Test
    public void testCount() {
        LocalBoardDAO instance = new LocalBoardDAO();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        instance.addBoard(NineByNineBoardUtil.getCompleteBoard());
        result = instance.count();
        assertEquals(expResult+1, result);
    }

    /**
     * Test of addBoard method, of class LocalBoardDAO.
     */
    @Test
    public void testAddBoard() {
        LocalBoardDAO instance = new LocalBoardDAO();
        boolean expResult = true;
        boolean result = instance.addBoard(NineByNineBoardUtil.getCompleteBoard());
        assertEquals(expResult, result);
        result = instance.addBoard(NineByNineBoardUtil.getIncompleteBoard());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddBoard_Dup() {
        Board board = NineByNineBoardUtil.getCompleteBoard();
        LocalBoardDAO instance = new LocalBoardDAO();
        boolean expResult = true;
        boolean result = instance.addBoard(board);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.addBoard(board);
        assertEquals(expResult, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddBoard_Null() {
        Board board = null;
        LocalBoardDAO instance = new LocalBoardDAO();
        instance.addBoard(board);
        fail("Expected NullPointerException");
    }
    
}
