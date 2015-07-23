package games.sudoku.strategy;

import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import games.sudoku.model.SolutionErrors;

/**
 *
 * @author nuno
 */
public interface SudokuStrategy {

    /**
     * Creates a new board with one solution.
     *
     * @return the new board created or null if unable to create a board.
     */
    Board createGame();

    /**
     * Creates a new board with one solution using the board provided as a 
     * starting point. 
     * New entries will be added, if necessary to assure that only one solution
     * is possible.
     * 
     * @param board the board to be used 
     * @return the new board created or null if unable to create a board.
     */
    Board createGame(Board board);

    /**
     * Returns a value that is part of the solution.
     * 
     * @param board the board for which the suggestion is requested
     * @return the suggestion or null if the board cannot be resolved.
     */
    BoardValue getSuggestion(Board board);

    /**
     * Verifies if the board is complete and the values respect the rules of the
     * game.
     * 
     * @param board the board to verify.
     * @return true if the problem is solved, false otherwise
     */
    boolean isSolved(Board board);

    /**
     * Fills the board with values that solve the game.
     * 
     * @param board the board to be solved.
     * @return true if the board as a solution, false otherwise.
     */
    boolean solve(Board board);
    
    /**
     * Checks the solution and returns the rows, columns and inner tables with 
     * errors.
     * 
     * @param board the board to be verified.
     * @return a SolutionErrors object with the errors found.
     */
    SolutionErrors verifySolution(Board board);

}
