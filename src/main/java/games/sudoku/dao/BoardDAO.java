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
public interface BoardDAO {

    /**
     * 
     * @return the number of boards available
     */
    int count();

    /**
     * Returns the board identified by the number
     * 
     * @param number the number of the board
     * @return the board associated with the number or null if it doesn't exists
     */
    Board get(int number);

    /**
     * 
     * @return the first board on the list or null if DAO is empty
     */
    Board getFirst();

    /**
     * Returns the next board on the list.
     * 
     * @param number the number of the previous board
     * @return the next board or null if doesn't exists
     */
    Board getNext(int number);
    
}
