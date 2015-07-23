/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.model;

import java.util.Arrays;

/**
 *
 * @author nuno
 */
public class SolutionErrors {
    private int[] rows;
    private int[] cols;
    private int[] innerTables;

    public SolutionErrors() {
    }

    public SolutionErrors(int[] rows, int[] cols, int[] innerTables) {
        this.rows = rows;
        this.cols = cols;
        this.innerTables = innerTables;
    }
    
    public boolean hasErrors(){
        return (rows!=null && rows.length>0) || (cols!=null && cols.length>0) 
                || (innerTables!=null && innerTables.length>0);
    }
    
    public int countErrors(){
        return (rows==null ? 0 : rows.length) + (cols==null ? 0 : cols.length) 
                + (innerTables==null ? 0 : innerTables.length);
    }

    public int[] getColumnsWithErrors() {
        return cols;
    }

    public int[] getInnerTablesWithErrors() {
        return innerTables;
    }

    public int[] getRowsWithErrors() {
        return rows;
    }

    public void setColumnsWithErrors(int[] cols) {
        this.cols = cols;
    }

    public void setInnerTablesWithErrors(int[] innerTables) {
        this.innerTables = innerTables;
    }

    public void setRowsWithErrors(int[] rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final SolutionErrors other = (SolutionErrors) obj;
        return Arrays.equals(this.rows, other.rows) && 
                Arrays.equals(this.cols, other.cols) && 
                Arrays.equals(this.innerTables, other.innerTables);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.hashCode(this.rows);
        hash = 29 * hash + Arrays.hashCode(this.cols);
        hash = 29 * hash + Arrays.hashCode(this.innerTables);
        return hash;
    }

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rows with errors: ").append(Arrays.toString(rows));
        sb.append("Columns with errors: ").append(Arrays.toString(cols));
        sb.append("Inner tables with errors: ").append(Arrays.toString(innerTables));
        return sb.toString(); 
    }
}
