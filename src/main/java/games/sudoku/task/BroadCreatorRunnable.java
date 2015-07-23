/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.task;

import games.sudoku.dao.AppendableBoardDAO;
import games.sudoku.model.Board;
import games.sudoku.strategy.SudokuStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author nuno
 */
@Component
public class BroadCreatorRunnable implements Runnable {
    private static final int DEFAULT_NUMBER_OF_GAMES = 500;
    private static final int DEFAULT_SLEEP_TIME = 1000;
    //
    /**
     * Sleep time between boards creation
     */
    private int sleepTime;
    /**
     * Number of games to be created
     */
    private int numberOfGames;
    /**
     * 
     */
    private boolean run = true;
    /**
     * 
     */
    private AppendableBoardDAO boardDao;
    /**
     * 
     */
    private SudokuStrategy strategy; 

    public BroadCreatorRunnable() {
        this(DEFAULT_SLEEP_TIME, DEFAULT_NUMBER_OF_GAMES);
    }
    
    public BroadCreatorRunnable(int sleepTime, int numberOfGames) {
        this.sleepTime = sleepTime;
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public AppendableBoardDAO getBoardDao() {
        return boardDao;
    }

    @Autowired
    @Qualifier("defaultBoardDao")
    public void setBoardDao(AppendableBoardDAO boardDao) {
        this.boardDao = boardDao;
    }

    public SudokuStrategy getStrategy() {
        return strategy;
    }

    @Autowired
    @Qualifier("defaultSudokuStrategy")
    public void setStrategy(SudokuStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        int countGames = boardDao.count();
        try {
            run = true;
            Board board;
            while(run && countGames<numberOfGames && !Thread.interrupted()){
                board = strategy.createGame();
                if(board!=null){
                    boardDao.addBoard(board);
                    countGames++;
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BoardCreator.class.getName()).log(
                            Level.SEVERE, "Board creator interrupted after creating "+countGames+" boards", ex);
                    break;
                }
            }
        } catch(RuntimeException ex){
            Logger.getLogger(BoardCreator.class.getName()).log(
                    Level.SEVERE, "Board creator unexpected exception. Boards created: "+countGames, ex);
        } finally {
            Logger.getLogger(BoardCreator.class.getName()).log(
                            Level.INFO, "Board creator finished. Boards created: "+countGames);
        }
    }
    
    public void stop(){
        run = false;
    }
}
