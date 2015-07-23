package games.sudoku.model;

import java.util.Arrays;

/**
 *
 * @author nuno
 */
public class DefaultBoard implements Board {
    //
    public static final int AREA = 81;
    //
    public static final int LENGTH = 9;
    //
    public static final int INNER_BOX_LENGTH = 3;
    //
    private int[][] board;
    //
    private int number;

    public DefaultBoard() {
        board = new int[LENGTH][LENGTH];
    }
    
    public DefaultBoard(int number) {
        this();
        this.number = number;
    }
    
    public DefaultBoard(int[][] board) {
        if(board.length!=LENGTH || board[0].length!=LENGTH){
            throw new IllegalArgumentException("The dimensions of the board are invalid");
        }
        this.board = board;
    }
    
    public DefaultBoard(int number, int[][] board) {
        this(board);
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public int getArea(){
        return AREA;
    }
    
    @Override
    public int getLength(){
        return LENGTH;
    }
    
    @Override
    public int getInnerBoxLength(){
        return INNER_BOX_LENGTH;
    }

    @Override
    public int countEmpty(){
        int count = 0;
        for(int[] row : board){
            for(int c : row){
                if(c==0){
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public boolean isEmpty(int row, int column) {
        return board[row][column] == 0;
    }

    @Override
    public int getValue(int row, int column) {
        return board[row][column];
    }

    @Override
    public void setValue(int row, int column, int value) {
        board[row][column] = value;
    }

    /**
     * Returns the table with the board values.
     * This method returns the original table. Changes to the table will
     * affect the object.
     * 
     * @return 
     */
    @Override
    public int[][] getTable() {
        return board;
    }

    @Override
    public void setTable(int[][] table) {
        if(table.length!=LENGTH || table[0].length!=LENGTH){
            throw new IllegalArgumentException("The dimensions of the board are invalid");
        }
        this.board = table;
    }

    @Override
    public void clear() {
        for(int[] row : board){
            Arrays.fill(row, 0);
        }
    }

    @Override
    public void clear(int row, int column) {
        board[row][column] = 0;
    }
    
    @Override
    public int[] getPossibleValues(int row, int column) {
        final int boxRow = row - row % 3, boxColumn = column - column % 3;
        int controlVar = 0;
        for(int j=0; j<LENGTH; j++){
            if(board[j][column]!=0){
                controlVar |= (1<<((board[j][column])-1));
            }
            // row check
            if(board[row][j]!=0){
                controlVar |= (1<<((board[row][j])-1));
            }
        }
        for (int rowOffset = 0; rowOffset < INNER_BOX_LENGTH; rowOffset++) {
            for (int columnOffset = 0; columnOffset < INNER_BOX_LENGTH; columnOffset++) {
                if(board[(boxRow + rowOffset)][boxColumn + columnOffset]!=0){
                    controlVar |= (1<<((board[(boxRow + rowOffset)][boxColumn + columnOffset])-1));
                }
            }
        }
        int[] options = new int[LENGTH-numberOfSetBits(controlVar)];
        for (int i=0, index=0; i < LENGTH; i++) {
            if((controlVar&(1<<i))==0){
                options[index++] = i+1;
            }
        }
        return options;
    }

    @Override
    public DefaultBoard clone() {
        int[][] tmpBoard = new int[LENGTH][LENGTH];
        for(int i=0; i<LENGTH; i++){
            System.arraycopy(this.board[i], 0, tmpBoard[i], 0, LENGTH);
        }
        return new DefaultBoard(number,tmpBoard);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() 
                && this.number==((DefaultBoard) obj).number 
                && Arrays.deepEquals(this.board, ((DefaultBoard) obj).board);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.number;
        hash = 41 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }

    @Override
    public int compareTo(Board o) {
        if(o==null){
            return 1;
        }
        if(number!=o.getNumber()){
            return number > o.getNumber() ? 1 : -1;
        }
        if(getLength()!=o.getLength()){
            return getLength() > o.getLength() ? 1 : -1;
        }
        for(int i=0; i<getLength(); i++){
            for(int j=0; j<getLength(); j++){
                if(getValue(i, j)!=o.getValue(i, j)){
                    return getValue(i, j) > o.getValue(i, j) ? 1 : -1;
                }
            }
        }
        return 0;
    }

    private static int numberOfSetBits(long i) {
        return (int)((i * 0x200040008001L & 0x111111111111111L) % 0xfL);
    }
}
