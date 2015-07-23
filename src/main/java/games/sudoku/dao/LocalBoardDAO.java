package games.sudoku.dao;

import games.sudoku.model.Board;
import games.sudoku.model.IgnoreNumberBoardComparator;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Boards DAO.
 * Stores the boards in memory and assures that there are no repeated boards.
 * 
 * @author nuno
 */
public class LocalBoardDAO implements AppendableBoardDAO {
    private static final LocalBoardDAO INSTANCE = new LocalBoardDAO();
    //
    /**
     * Set used to assure we have unique boards
     */
    private final Set<Board> set = new TreeSet<>(new IgnoreNumberBoardComparator());
    /**
     * List of boards
     */
    private final ArrayList<Board> list = new ArrayList<>();
    //
    
    public static LocalBoardDAO getInstance() {
        return INSTANCE;
    }
    
    @Override
    public Board getFirst(){
        return list.isEmpty() ? null : list.get(0).clone();
    }
    
    @Override
    public Board get(int number){
        return number<1 || number>list.size() ? null : list.get(number-1).clone();
    }
    
    @Override
    public Board getNext(int number){
        number = number<1 ? 0 : number;
        return number>list.size() ? null : list.get(number).clone();
    }
    
    @Override
    public int count(){
        return list.size();
    }
    
    /**
     * Adds a new board to the list.
     * The new board will be added if no other board with the same values 
     * already exists.
     * 
     * @param board the new board to be added
     * @return true if the board was added to the list
     */
    public synchronized boolean addBoard(Board board){
        board.setNumber(set.size());
        if(set.add(board)){
            list.add(board);
            return true;
        }
        return false;
    }
}
