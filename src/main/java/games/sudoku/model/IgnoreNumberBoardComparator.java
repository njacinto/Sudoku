/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.model;

import java.util.Comparator;

/**
 *
 * @author nuno
 */
public class IgnoreNumberBoardComparator implements Comparator<Board> {

    @Override
    public int compare(Board o1, Board o2) {
        if(o1==null || o2==null){
            return o1==null ? o2==null ? 0 : -1 : 1;
        }
        if(o1.getLength()!=o2.getLength()){
            return o1.getLength() > o2.getLength() ? 1 : -1;
        }
        for(int i=0; i<o1.getLength(); i++){
            for(int j=0; j<o1.getLength(); j++){
                if(o1.getValue(i, j)!=o2.getValue(i, j)){
                    return o1.getValue(i, j) > o2.getValue(i, j) ? 1 : -1;
                }
            }
        }
        return 0;
    }
    
}
