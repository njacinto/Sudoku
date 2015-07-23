/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import games.sudoku.model.SolutionErrors;
import games.sudoku.service.serializer.BoardSerializer;

/**
 *
 * @author nuno
 */
public class Message {
    private SolutionErrors errors;
    private String msg;
    private boolean valid;
    private Board board;
    private BoardValue value;

    public Message() {
        valid = true;
    }

    /**
     * @return the errors
     */
    public SolutionErrors getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     * @return 
     */
    public Message setErrors(SolutionErrors errors) {
        this.errors = errors;
        return this;
    }

    /**
     * @return the msg
     */
    public String getMessage() {
        return msg;
    }

    /**
     * @param msg the msg to set
     * @return 
     */
    public Message setMessage(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     * @return 
     */
    public Message setValid(boolean valid) {
        this.valid = valid;
        return this;
    }

    /**
     * @return the board
     */
    @JsonSerialize(using = BoardSerializer.class)
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     * @return 
     */
//    @JsonDeserialize(using = BoardDeserializer.class)
    public Message setBoard(Board board) {
        this.board = board;
        return this;
    }

    /**
     * @return the value
     */
    public BoardValue getValue() {
        return value;
    }

    /**
     * @param value the value to set
     * @return 
     */
    public Message setValue(BoardValue value) {
        this.value = value;
        return this;
    }
    
}
