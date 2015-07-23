package games.sudoku.service;

import games.sudoku.dao.BoardDAO;
import games.sudoku.model.Board;
import games.sudoku.model.BoardValue;
import games.sudoku.model.SolutionErrors;
import games.sudoku.service.model.Message;
import games.sudoku.service.model.RequestBoard;
import games.sudoku.service.serializer.BoardRequestToBoardFactory;
import games.sudoku.strategy.SudokuStrategy;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * REST Web Service
 *
 * @author nuno
 */
@Path("")
public class SudokuRS {

    private SudokuStrategy strategy;
    private BoardDAO boardDao;
    private BoardRequestToBoardFactory factory;

    /**
     * Creates a new instance of SudokuRS
     */
    public SudokuRS() {

    }

    public BoardDAO getBoardDao() {
        return boardDao;
    }

    @Autowired
    @Qualifier("defaultBoardDao")
    public void setBoardDao(BoardDAO boardDao) {
        this.boardDao = boardDao;
    }

    public SudokuStrategy getStrategy() {
        return strategy;
    }

    @Autowired
    @Qualifier("deafultSudokuStrategy")
    public void setStrategy(SudokuStrategy strategy) {
        this.strategy = strategy;
    }

    public BoardRequestToBoardFactory getMapper() {
        return factory;
    }

    @Autowired
    @Qualifier("defaultBoardRequestMapper")
    public void setMapper(BoardRequestToBoardFactory mapper) {
        this.factory = mapper;
    }

    /**
     * Retrieves representation of an instance of games.sudoku.service.SudokuRS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("isOk")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean checkService() {
        return true;
    }

    /**
     *
     * @param previousGameId
     * @return
     */
    @GET
    @Path("newgame/{previousGameId:\\d+}")
    @Produces("application/json")
    public Message getNewGame(@PathParam("previousGameId") int previousGameId) {
        Board board = boardDao.getNext(previousGameId < 0 ? 0 : previousGameId);
        if (board == null) {
            throw new NotFoundException();
        }
        return new Message().setBoard(board);
    }

    /**
     *
     * @param gameId
     * @return
     */
    @GET
    @Path("game/{gameId:\\d+}")
    @Produces("application/json")
    public Message getGame(@PathParam("gameId") int gameId) {
        Board board = boardDao.get(gameId);
        if (board == null) {
            throw new NotFoundException();
        }
        return new Message().setBoard(board);
    }

    /**
     *
     * @param rboard
     * @return
     */
    @POST
    @Path("suggestion")
    @Consumes("application/json")
    @Produces("application/json")
    public Message getSuggestion(RequestBoard rboard) {
        Board board = factory.create(rboard);
        if (board != null) {
            BoardValue suggestion = strategy.getSuggestion(board);
            return new Message().setValid(suggestion != null).setValue(suggestion);
        } else {
            throw new BadRequestException();
        }
    }

    /**
     *
     * @param rboard
     * @return
     */
    @POST
    @Path("issolved")
    @Consumes("application/json")
    @Produces("application/json")
    public Message isSolved(RequestBoard rboard) {
        Board board = factory.create(rboard);
        if (board != null) {
            boolean isSolved = strategy.isSolved(board);
            return new Message().setValid(isSolved);
        } else {
            throw new BadRequestException();
        }
    }

    /**
     *
     * @param rboard
     * @return
     */
    @POST
    @Path("solve")
    @Consumes("application/json")
    @Produces("application/json")
    public Message solve(RequestBoard rboard) {
        Board board = factory.create(rboard);
        if (board != null) {
            boolean isSolved = strategy.solve(board);
            return new Message().setValid(isSolved).setBoard(board);
        } else {
            throw new BadRequestException();
        }
    }

    /**
     *
     * @param rboard
     * @p
     * @return
     */
    @POST
    @Path("verifysolution")
    @Consumes("application/json")
    @Produces("application/json")
    public Message verifySolution(RequestBoard rboard) {
        Board board = factory.create(rboard);
        if (board != null) {
            SolutionErrors errors = strategy.verifySolution(board);
            return new Message().setValid(!errors.hasErrors()).setErrors(errors);
        } else {
            throw new BadRequestException();
        }
    }
}
