// Written by Akshat Sharma, sharm849

public class Bishop {
    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Verify if the move is diagonal.
        if (board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
            if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack) == true) {
                return true;
            }
        }
            // The move is not diagonal, so it's illegal.
            return false;
    }
    private int row;
    private int col;
    private boolean isBlack;
}
