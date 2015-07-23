package games.sudoku.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;


/**
 *
 * @author nuno
 */
public interface Board extends Comparable<Board> {

    int getNumber();
    
    void setNumber(int number);

    int getArea();
    
    int getLength();
    
    int getInnerBoxLength();

    boolean isEmpty(int row, int column);
    
    int getValue(int row, int column);

    void setValue(int row, int column, int value);

    void clear(int row, int column);
    
    int[] getPossibleValues(int row, int column);
    
    void clear();
    
    int countEmpty();
    
    void setTable(int[][] table);
    
    int[][] getTable();
    
    Board clone();
}
