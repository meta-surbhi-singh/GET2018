package nQueen;
/**
 * The N Queen problem is the problem of placing N chess queens on an N×N chess-board so that no two queens attack each other
 * This class provides the solution for this problem
 * @author Surbhi Singh
 */
public class NQueenProblem {
	
    private final int N ;
    private int[][] board;
    
    public NQueenProblem(int N) {
    	this.N = N;
    	this.board = initialiseBoard();
    	nQueen(0);
    }
 
    private int[][] initialiseBoard() {
    	int [][] board = new int [N][N];
		return board;
	}

	public int[][] getBoard() {
        return board;
    }
	
	public void displayBoard() {
		for(int row = 0; row < N; row++) {
			for(int coloumn = 0; coloumn < N; coloumn++) {
				System.out.print(" " + board[row][coloumn] + " ");
			}
			System.out.println(" ");
		}
	}

    /** Checks if it is safe to place queen on board at @param row and @param coloumn.
     * 
     * @param board : the chess-board on which the queen is to be placed
     * @param row : row no. at which queen's position is to be checked to be safe or not.
     * @param coloumn : column no. at which queen's position is to be checked to be safe or not.
     * @return
     */
    private boolean isSafe( int row, int coloumn) {
        int rowIndex,coloumnIndex;
        //check for row and column
        for(rowIndex = 0; rowIndex < N; rowIndex++){
            if(board[row][rowIndex] == 1) {
                return false;
            }
            if(board[rowIndex][coloumn] == 1) {
                return false;
            }
        }
        //check for upper left diagonal
        for(rowIndex=row,coloumnIndex = coloumn; rowIndex >= 0 && coloumnIndex >= 0; rowIndex--, coloumnIndex--) {
            if(board[rowIndex][coloumnIndex] == 1) {
                return false;
            }
        }
        //check for upper right diagonal
        for(rowIndex = row,coloumnIndex = coloumn; rowIndex >= 0 && coloumnIndex < N; rowIndex--, coloumnIndex++) {
            if(board[rowIndex][coloumnIndex]==1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Recursively places the queen such that the queen is safe from attacks from other queen
     * @param board : the chess-board on which the queen is to be placed
     * @param row : the row on which the queen's position is decided.
     * @return
     */
    public boolean nQueen(int row) {
        if(row == N) {
            return true;
        }
        else{
            for(int column = 0; column < N; column++) {
                if(isSafe(row, column)) {
                    board[row][column] = 1;
                    if(nQueen(++row)) {
                        return true;
                    }
                    else {
                        board[--row][column] = 0;
                    }
                }
            }
            return false;
        }
    }
 
}