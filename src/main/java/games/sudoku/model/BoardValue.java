package games.sudoku.model;

/**
 *
 * @author nuno
 */
public class BoardValue {
    private int row;
    private int column;
    private int value;

    public BoardValue() {
    }

    public BoardValue(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BoardValue other = (BoardValue) obj;
        return (this.row == other.row && this.column == other.column && 
                this.value == other.value);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.row;
        hash = 17 * hash + this.column;
        hash = 17 * hash + this.value;
        return hash;
    }
    
    

    @Override
    public String toString() {
        return new StringBuilder("BoardValue: row= ").append(row).append(" column= ")
                .append(column).append(" value= ").append(value).toString();
    }
}
