/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.serializer;

import games.sudoku.model.Board;
import games.sudoku.service.model.RequestBoard;

/**
 * Factory used to convert from a RequestBoard into a board.
 * 
 * @author nuno
 */
public interface BoardRequestToBoardFactory {
    Board create(RequestBoard rboard);
}
