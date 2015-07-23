/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.serializer;

import games.sudoku.model.Board;
import games.sudoku.service.model.RequestBoard;
import java.util.Map;

/**
 * Map of factories
 * 
 * @author nuno
 */
public class BoardRequestAreaToBoardFactory implements BoardRequestToBoardFactory {
    private Map<Integer,BoardRequestToBoardFactory> map;

    public BoardRequestAreaToBoardFactory() {
    }

    public BoardRequestAreaToBoardFactory(Map<Integer, BoardRequestToBoardFactory> map) {
        this.map = map;
    }
    
    @Override
    public Board create(RequestBoard rboard){
        BoardRequestToBoardFactory factory = map.get(rboard.getArea());
        return factory==null ? null : factory.create(rboard);
    }
    
}
