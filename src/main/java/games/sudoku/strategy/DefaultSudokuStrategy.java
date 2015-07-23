/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.strategy;

import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import games.sudoku.model.DefaultBoard;
import games.sudoku.model.SolutionErrors;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author nuno
 */
public class DefaultSudokuStrategy implements SudokuStrategy {

    private static final DefaultSudokuStrategy INSTANCE = new DefaultSudokuStrategy();
    //
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    //
    /**
     * Default number of tries that the creator of a board will do before 
     * giving up.
     */
    public static final int DEFAULT_NUMBER_OF_TRIES = 20;
    /**
     * Default number of random numbers that the creator will used to generate
     * the base board.
     */
    public static final int DEFAULT_NUMBER_OF_STARTING_VALUES = 24;
    //
    /**
     * Random numbers generator used when creating the board.
     */
    private final Random random = new Random(System.nanoTime());
    /**
     * Number of tries that the creator of a board will do before giving up.
     */
    private int numberOfTriesOnCreation;
    /**
     * Number of random numbers that the creator will used to generate
     * the base board.
     */
    private int numberOfStartingValues;

    /**
     * Creates a DefaultSudokuStrategy using the default values.
     */
    public DefaultSudokuStrategy() {
        this(DEFAULT_NUMBER_OF_TRIES, DEFAULT_NUMBER_OF_STARTING_VALUES);
    }
    
    /**
     * Creates a DefaultSudokuStrategy defining the number of tries and number
     * of starting values used when creating a board.
     * 
     * @param numberOfTriesOnCreation the number of tries that the creator will 
     * do before giving up.
     * @param numberOfStartingValues the number of random numbers that will be
     * used to create the initial board.
     */
    public DefaultSudokuStrategy(int numberOfTriesOnCreation, int numberOfStartingValues) {
        this.numberOfTriesOnCreation = numberOfTriesOnCreation; 
        this.numberOfStartingValues = numberOfStartingValues;
    }

    /**
     * 
     * @return 
     */
    public static DefaultSudokuStrategy getInstance() {
        return INSTANCE;
    }

    /**
     * 
     * @return the new board created or null if unable to create the board. 
     */
    @Override
    public Board createGame() {
        Board board = new DefaultBoard();
        final int length = board.getLength();
        outer: for(int i=0; i<numberOfTriesOnCreation; i++){
            for(int j=0; j<numberOfStartingValues;){
                int row = random.nextInt(length);
                int coll = random.nextInt(length);
                if(board.isEmpty(row, coll)){
                    int[] valid = board.getPossibleValues(row, coll);
                    if(valid.length!=0) {
                        board.setValue(row, coll, valid[random.nextInt(valid.length)]);
                    } else {
                        board.clear();
                        continue outer;
                    }
                    j++;
                }
            }
            if(completeBoardWithUniqueSolution(0, board)){
                if(!hasConflicts(board)){
                    return board;
                }
            }
            board.clear();
        }
        return null;
        
    }
    
    /**
     * 
     * @param board
     * @return the new board created or null if unable to create the board. 
     */
    @Override
    public Board createGame(final Board board) {
        Objects.requireNonNull(board);
        if(!hasConflicts(board)){
            Board boardClone = board.clone();
            if(completeBoardWithUniqueSolution(0, boardClone)){
                if(!hasConflicts(boardClone)){
                    return boardClone;
                }
            }
        }
        return null;
    }
    
    @Override
    public BoardValue getSuggestion(final Board board){
        return getSuggestion(0, board, null);
    }
    
    @Override
    public boolean solve(Board board) {
        if(!hasConflicts(board)){
            return solve(0, board);
        }
        return false;
    }

    @Override
    public boolean isSolved(final Board board) {
        final int length = board.getLength();
        final int innerBoxlength = board.getInnerBoxLength();
        final int rowColControlValue = (1<<(length+length))-1;
        final int innerTableControlValue = (1<<(length))-1;
        int flag;
        int controlVar;
        for(byte i=0; i<length; i++){
            controlVar = 0;
            for(byte j=0; j<length; j++){
                flag = (1<<(board.getValue(i, j)-1));
                if((controlVar&flag)!=0){
                    return false;
                } else {
                    controlVar |= flag;
                }
                flag = (1<<(board.getValue(j, i)-1+length));
                if((controlVar&flag)!=0){
                    return false;
                } else {
                    controlVar |= flag;
                }
            }
            if(controlVar!=rowColControlValue){
                return false;
            }
        }
        for(byte incr=0, incc=0; incr<length;){
            controlVar = 0;
            for(byte i=0; i<innerBoxlength; i++){
                for(byte j=0; j<innerBoxlength; j++){
                    flag = (1<<(board.getValue(j+incr,i+incc)-1));
                    if((controlVar&(flag))!=0){
                        return false;
                    } else {
                        controlVar |= (flag);
                    }
                }
            }
            if(controlVar!=innerTableControlValue){
                return false;
            }
            incc+=innerBoxlength;
            if(incc>=length){
                incr += innerBoxlength;
                incc = 0;
            }
        }
        return true;
    }
    
    @Override
    public SolutionErrors verifySolution(final Board board) {
        final int length = board.getLength();
        final int innerBoxlength = board.getInnerBoxLength();
        final int resultControlValue = (1<<(length))-1;
        int flag;
        int controlVar, colControlVar;
        int[] rowErrors=new int[length], colErrors=new int[length],innerBoxErrors=new int[length];
        int rowErrorsIndex=0, colErrorsIndex=0, innerTableErrorsIndex=0; 
        for(byte i=0; i<length; i++){
            controlVar = 0;
            colControlVar = 0;
            for(byte j=0; j<length; j++){
                flag = (1<<(board.getValue(i,j)-1));
                if((controlVar&flag)==0){
                    controlVar |= flag;
                } else if(rowErrorsIndex==0 || rowErrors[rowErrorsIndex-1] != i){
                    rowErrors[rowErrorsIndex++] = i;
                }
                flag = (1<<(board.getValue(j,i)-1));
                if((colControlVar&flag)==0){
                    colControlVar |= flag;
                } else if(colErrorsIndex==0 || colErrors[colErrorsIndex-1] != i){
                    colErrors[colErrorsIndex++] = i;
                }
            }
            if(controlVar!=resultControlValue){
                if(rowErrorsIndex==0 || rowErrors[rowErrorsIndex-1] != i){
                    rowErrors[rowErrorsIndex++] = i;
                }
            }
            if(colControlVar!=resultControlValue){
                if(colErrorsIndex==0 || colErrors[colErrorsIndex-1] != i){
                    colErrors[colErrorsIndex++] = i;
                }
            }
        }
        for(byte incr=0, incc=0, boxIndex=0; incr<length; boxIndex++){
            controlVar = 0;
            for(byte i=0; i<innerBoxlength; i++){
                for(byte j=0; j<innerBoxlength; j++){
                    flag = (1<<(board.getValue(j+incr,i+incc)-1));
                    if((controlVar&(flag))==0){
                        controlVar |= (flag);
                    } else if(innerTableErrorsIndex==0 || innerBoxErrors[innerTableErrorsIndex-1]!=boxIndex){
                        innerBoxErrors[innerTableErrorsIndex++] = boxIndex;
                    }
                }
            }
            if(controlVar!=resultControlValue){
                if(innerTableErrorsIndex==0 || innerBoxErrors[innerTableErrorsIndex-1]!=boxIndex){
                    innerBoxErrors[innerTableErrorsIndex++] = boxIndex;
                }
            }
            incc+=innerBoxlength;
            if(incc>=length){
                incr += innerBoxlength;
                incc = 0;
            }
        }
        return new SolutionErrors(
                rowErrorsIndex==0 ? EMPTY_INT_ARRAY : 
                        rowErrorsIndex==length ? rowErrors : Arrays.copyOf(rowErrors, rowErrorsIndex), 
                colErrorsIndex==0 ? EMPTY_INT_ARRAY : 
                        colErrorsIndex==length ? colErrors : Arrays.copyOf(colErrors, colErrorsIndex),
                innerTableErrorsIndex==0 ? EMPTY_INT_ARRAY : 
                        innerTableErrorsIndex==length ? innerBoxErrors : 
                                Arrays.copyOf(innerBoxErrors, innerTableErrorsIndex));
    }
    
    /**
     * 
     * @param board
     * @return 
     */
    public String toString(final Board board){
        int length = board.getLength();
        StringBuilder boardAsString = new StringBuilder();
        for (int i=0; i<length; i++) {
            boardAsString.append('|');
            for (int j=0; j<length; j++) {
                boardAsString.append((char)(board.getValue(i, j)+48)).append('|');
            }
            boardAsString.append("\n");
        }
        return boardAsString.toString();
    }

    // protected 
    

    /**
     * Fills the board until it becomes an unique solution board.
     * IMPORTANT: This method may generate invalid boards, so the result must
     * be checked with the hasConflicts method.
     * The advantage of leaving the current behavior is that provides a better
     * convergence to a board with an unique solution than trying to add random
     * numbers and better performance because it's not checking the conflicts on
     * every execution.
     * The number of errors found for 500 iterations was between 0 and 4.
     * 
     * @param index
     * @param board
     * @return true if the board has a solution and it's unique
     */
    protected boolean completeBoardWithUniqueSolution(final int index, final Board board) {
        if (index == board.getArea()) {
            return true;
        }
        final int row = index / board.getLength(), column = index % board.getLength();
        if (!board.isEmpty(row, column)) {
            return completeBoardWithUniqueSolution(index+1, board);
        }
        int count = 0;
        int[] optionsForCell = board.getPossibleValues(row, column);
        for (int option : optionsForCell) {
            board.setValue(row, column, option);
            if (completeBoardWithUniqueSolution(index + 1, board)) {
                count++;
                if(count>1){
                    break;
                }
            }
        }
        // clear only if has zero or one solution, so that we can use the values with 
        // one or more solutions to create a board with a single solution.
        // This conditions adds errors to board because different iterations
        // leave numbers on the board.
        if(count<2){ 
            board.clear(row, column);
        }
        return count==1;
    }
    
    protected boolean hasConflicts(final Board board) {
        final int length = board.getLength();
        final int innerBoxlength = board.getInnerBoxLength();
        int flag;
        int controlVar;
        for(byte i=0; i<length; i++){
            controlVar = 0;
            for(byte j=0; j<length; j++){
                if(board.getValue(i, j)!=0){
                    flag = (1<<(board.getValue(i, j)-1));
                    if((controlVar&flag)!=0){
                        return true;
                    } else {
                        controlVar |= flag;
                    }
                }
                if(board.getValue(j, i)!=0){
                    flag = (1<<(board.getValue(j, i)-1+length));
                    if((controlVar&flag)!=0){
                        return true;
                    } else {
                        controlVar |= flag;
                    }
                }
            }
        }
        
        for(byte incr=0, incc=0; incr<length;){
            controlVar = 0;
            for(byte i=0; i<innerBoxlength; i++){
                for(byte j=0; j<innerBoxlength; j++){
                    if(board.getValue(j+incr,i+incc)!=0){
                        flag = (1<<(board.getValue(j+incr,i+incc)-1));
                        if((controlVar&(flag))!=0){
                            return true;
                        } else {
                            controlVar |= (flag);
                        }
                    }
                }
            }
            incc+=innerBoxlength;
            if(incc>=length){
                incr += innerBoxlength;
                incc = 0;
            }
        }
        return false;
    }
    
    protected BoardValue getSuggestion(final int index, final Board board, BoardValue value) {
        if (index == board.getArea()) {
            return value;
        }
        final int row = index / board.getLength(), column = index % board.getLength();
        if (!board.isEmpty(row, column)) {
            return getSuggestion(index+1, board, value);
        }
        boolean setValue = value==null;
        if(value==null){
            value = new BoardValue(row, column, 0);
        }
        int[] optionsForCell = board.getPossibleValues(row, column);
        for (int option : optionsForCell) {
            board.setValue(row, column, option);
            if(setValue){
                value.setValue(option);
            }
            if (getSuggestion(index + 1, board, value)!=null) {
                board.clear(row, column);
                return value;
            }
        }
        board.clear(row, column);
        return null;
    }

    protected boolean solve(final int index, final Board board) {
        if (index == board.getArea()) {
            return true; 
        }
        final int row = index / board.getLength(), column = index % board.getLength();
        if (!board.isEmpty(row, column)) {
            return solve(index + 1, board);
        }

        int[] optionsForCell = board.getPossibleValues(row, column);
        for (int option : optionsForCell) {
            board.setValue(row, column, option);
            if (solve(index + 1, board)) {
                return true;
            }
        }
        board.clear(row, column);
        return false;
    }
}
