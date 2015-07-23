/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.strategy;

import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import games.sudoku.NineByNineBoardUtil;
import games.sudoku.model.SolutionErrors;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public abstract class NineByNineSudokuStrategyTest {
    /**
     * 
     * @return 
     */
    protected abstract SudokuStrategy getStrategy();
    
    public NineByNineSudokuStrategyTest() {
    }

    /**
     * Test of createGame method, of class SudokuStrategy.
     */
    @Test
    public void testCreateGame_0args() {
        SudokuStrategy instance = getStrategy();
        Board result;
        for(int i=0; i<100; i++){
            result = instance.createGame();
            if(result!=null){
                assertTrue(instance.solve(result));
                return;
            }
        }
        fail("Unable to create a table.");
    }

    /**
     * Test of createGame method, of class SudokuStrategy.
     */
    @Test
    public void testCreateGame_Board() {
        Board board = NineByNineBoardUtil.getIncompleteBoard();
        SudokuStrategy instance = getStrategy();
        Board expResult = NineByNineBoardUtil.getIncompleteBoard();
        Board result = instance.createGame(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuggestion method, of class SudokuStrategy.
     */
    @Test
    public void testGetSuggestion_Board() {
        Board board = NineByNineBoardUtil.getIncompleteBoard();
        SudokuStrategy instance = getStrategy();
        BoardValue result = instance.getSuggestion(board);
        if(instance.solve(board)){
            assertTrue(board.getValue(result.getRow(), result.getColumn())==result.getValue());
        } else {
            fail("Board doesn't has a solution.");
        }
    }
    
    @Test
    public void testGetSuggestion_BoardMissingOne() {
        Board board = NineByNineBoardUtil.getIncompleteBoardMissingOne();
        SudokuStrategy instance = getStrategy();
        BoardValue expResult = new BoardValue(0, 6, 9);
        BoardValue result = instance.getSuggestion(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetSuggestion_CompleteBoard() {
        Board board = NineByNineBoardUtil.getCompleteBoard();
        SudokuStrategy instance = getStrategy();
        BoardValue expResult = null;
        BoardValue result = instance.getSuggestion(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve method, of class SudokuStrategy.
     */
    @Test
    public void testSolve_Board() {
        Board board = NineByNineBoardUtil.getIncompleteBoard();
        SudokuStrategy instance = getStrategy();
        boolean expResult = true;
        boolean result = instance.solve(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSolve_InvalidBoard() {
        Board board = NineByNineBoardUtil.getIncompleteInvalidBoard();
        SudokuStrategy instance = getStrategy();
        boolean expResult = false;
        boolean result = instance.solve(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSolved method, of class SudokuStrategy.
     */
    @Test
    public void testIsSolved() {
        Board board = NineByNineBoardUtil.getCompleteBoard();
        SudokuStrategy instance = getStrategy();
        boolean expResult = true;
        boolean result = instance.isSolved(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsSolved_InvalidBoard() {
        Board board = NineByNineBoardUtil.getInvalidBoard();
        SudokuStrategy instance = getStrategy();
        boolean expResult = false;
        boolean result = instance.isSolved(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsSolved_IncompleteBoard() {
        Board board = NineByNineBoardUtil.getIncompleteBoard();
        SudokuStrategy instance = getStrategy();
        boolean expResult = false;
        boolean result = instance.isSolved(board);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifySolution method, of class SudokuStrategy.
     */
    @Test
    public void testVerifySolution() {
        Board board = NineByNineBoardUtil.getInvalidBoard();
        SudokuStrategy instance = getStrategy();
        SolutionErrors expResult = new SolutionErrors(new int[]{0,8}, new int[]{0,8}, new int[]{2,6});
        SolutionErrors result = instance.verifySolution(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifySolution_NoErrors() {
        Board board = NineByNineBoardUtil.getCompleteBoard();
        SudokuStrategy instance = getStrategy();
        SolutionErrors expResult = new SolutionErrors(new int[0], new int[0], new int[0]);
        SolutionErrors result = instance.verifySolution(board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifySolution_AllWrong() {
        Board board = NineByNineBoardUtil.getAllWrongBoard();
        SudokuStrategy instance = getStrategy();
        SolutionErrors expResult = new SolutionErrors(
                new int[]{0,1,2,3,4,5,6,7,8}, 
                new int[]{0,1,2,3,4,5,6,7,8}, 
                new int[]{0,1,2,3,4,5,6,7,8});
        SolutionErrors result = instance.verifySolution(board);
        assertEquals(expResult, result);
    }

}
