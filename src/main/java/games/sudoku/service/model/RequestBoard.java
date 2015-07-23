/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.model;

/**
 *
 * @author nuno
 */
public class RequestBoard {
    private int number;
    private int area;
    private int[][] table;

    public RequestBoard() {
    }

    public RequestBoard(int number, int area, int[][] table) {
        this.number = number;
        this.area = area;
        this.table = table;
    }

    public int getArea() {
        return area>0 ? area : (area=table.length*table.length);
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }
}
