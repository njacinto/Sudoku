/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku;

import games.sudoku.model.Board;
import games.sudoku.model.DefaultBoard;

/**
 *
 * @author nuno
 */
public class NineByNineBoardUtil {
    
    private NineByNineBoardUtil(){}
    
    /**
     * Errors on: row 0, col 8; row 8, col 0;
     *          
     * @return 
     */
    public static Board getAllWrongBoard(){
        return new DefaultBoard(new int[][]{
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1},
            {1,2,3,4,5,6,7,8,1}
        });
    }
    public static Board getInvalidBoard(){
        return new DefaultBoard(new int[][]{
            {5,3,4,6,7,8,9,1,9},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {9,4,5,2,8,6,1,7,9}
        });
    }
    public static Board getIncompleteBoard(){
        return new DefaultBoard(new int[][]{
            {0,3,4,6,7,8,9,1,0},
            {6,0,2,1,9,0,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,0,5,3,7,9,1},
            {7,1,3,9,2,0,8,5,6},
            {0,6,1,5,3,7,0,8,4},
            {2,8,7,0,1,9,6,3,5},
            {0,4,5,2,8,6,1,7,0}
        });
    }
    /**
     * value missing on the row 0, column 6, value 9
     * @return 
     */
    public static Board getIncompleteBoardMissingOne(){
        return new DefaultBoard(new int[][]{
            {5,3,4,6,7,8,0,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        });
    }
    public static Board getIncompleteInvalidBoard(){
        return new DefaultBoard(new int[][]{
            {0,3,4,6,7,8,1,9,0},
            {6,0,2,1,9,0,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,0,5,3,7,9,1},
            {7,1,3,9,2,0,8,5,6},
            {0,6,1,5,3,7,0,8,4},
            {2,8,7,0,1,9,6,3,5},
            {0,4,5,2,8,6,1,7,0}
        });
    }
    public static Board getCompleteBoard(){
        return new DefaultBoard(new int[][]{
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        });
    }
}
