/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.dao;

import games.sudoku.model.Board;

/**
 *
 * @author nuno
 */
public interface AppendableBoardDAO extends BoardDAO {
    /**
     * Allows to add boards
     * 
     * @param board the new board to the added
     * @return true if the board was successful added.
     */
    boolean addBoard(Board board);
}
