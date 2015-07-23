/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.serializer;

import games.sudoku.model.Board;
import games.sudoku.model.DefaultBoard;
import games.sudoku.service.model.RequestBoard;

/**
 *
 * @author nuno
 */
public class BoardArea81Factory implements BoardRequestToBoardFactory {

    @Override
    public Board create(RequestBoard rboard) {
        return new DefaultBoard(rboard.getNumber(), rboard.getTable());
    }
    
}
