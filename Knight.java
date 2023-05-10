// Written by Akshat Sharma, sharm849

public class Knight {
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Verify if the move is L-shaped.
        if (Math.abs(this.row - endRow) == 2 && Math.abs(this.col - endCol) == 1 ||
                Math.abs(this.row - endRow) == 1 && Math.abs(this.col - endCol) == 2) {
            // Determine if the destination square is empty or occupied by an opponent's piece.
            if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack) == true) {
                return true;
            } else {
                return false;
            }
        } else {
            // The move is not L-shaped, so it is illegal
            return false;
        }
    }
    private int row;
    private int col;
    private boolean isBlack;
}