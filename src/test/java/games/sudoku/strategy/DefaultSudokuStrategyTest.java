/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.strategy;

import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author nuno
 */
public class DefaultSudokuStrategyTest extends NineByNineSudokuStrategyTest {

    @Override
    protected SudokuStrategy getStrategy() {
        return DefaultSudokuStrategy.getInstance();
    }
    
    public DefaultSudokuStrategyTest() {
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
     * Test of toString method, of class DefaultSudokuStrategy.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        Board board = null;
        DefaultSudokuStrategy instance = new DefaultSudokuStrategy();
        String expResult = "";
        String result = instance.toString(board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completeBoardWithUniqueSolution method, of class DefaultSudokuStrategy.
     */
    @Ignore
    @Test
    public void testCompleteBoardWithUniqueSolution() {
        System.out.println("completeBoardWithUniqueSolution");
        int index = 0;
        Board board = null;
        DefaultSudokuStrategy instance = new DefaultSudokuStrategy();
        boolean expResult = false;
        boolean result = instance.completeBoardWithUniqueSolution(index, board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasConflicts method, of class DefaultSudokuStrategy.
     */
    @Ignore
    @Test
    public void testHasConflicts() {
        System.out.println("hasConflicts");
        Board board = null;
        DefaultSudokuStrategy instance = new DefaultSudokuStrategy();
        boolean expResult = false;
        boolean result = instance.hasConflicts(board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuggestion method, of class DefaultSudokuStrategy.
     */
    @Ignore
    @Test
    public void testGetSuggestion_3args() {
        System.out.println("getSuggestion");
        int index = 0;
        Board board = null;
        DefaultSudokuStrategy instance = new DefaultSudokuStrategy();
        BoardValue value = null;
        BoardValue expResult = null;
        BoardValue result = instance.getSuggestion(index, board, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class DefaultSudokuStrategy.
     */
    @Ignore
    @Test
    public void testSolve_int_Board() {
        System.out.println("solve");
        int index = 0;
        Board board = null;
        DefaultSudokuStrategy instance = new DefaultSudokuStrategy();
        boolean expResult = false;
        boolean result = instance.solve(index, board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
