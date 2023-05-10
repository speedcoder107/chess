// Written by Akshat Sharma, sharm849

public class Queen {

    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Verify if the move is horizontal, vertical, or diagonal.
        if (board.verifyHorizontal(this.row, this.col, endRow, endCol) ||
                board.verifyVertical(this.row, this.col, endRow, endCol) ||
                board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
            if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack) == true) {
                return true;
            }
        }
            // The move is not horizontal, vertical, or diagonal, so it's illegal.
            return false;
    }


    private int row;
    private int col;
    private boolean isBlack;
}
