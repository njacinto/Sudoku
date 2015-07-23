/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.task;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 *
 * @author nuno
 */
@Component
public class BoardCreator {

    private Runnable boardCreator;
    private TaskExecutor executer;

    public BoardCreator() {
    }

    @Autowired
    public BoardCreator(Runnable boardCreator, TaskExecutor executer) {
        this.boardCreator = boardCreator;
        this.executer = executer;
    }
    
    
    public Runnable getBoardCreator() {
        return boardCreator;
    }

    @Autowired
    @Qualifier("boardCreatorRunnable")
    public void setBoardCreator(Runnable boardCreator) {
        this.boardCreator = boardCreator;
    }

    @Autowired
    @Qualifier("taskExecutor")
    public void setExecuter(TaskExecutor executer) {
        this.executer = executer;
    }
    

    @PostConstruct
    public void start(){
        executer.execute(boardCreator);
    }
}
