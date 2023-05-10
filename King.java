// Written by Akshat Sharma, sharm849

public class King {

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Verify if the move is one square horizontally, vertically, or diagonally.
        if (Math.abs(this.row - endRow) <= 1 && Math.abs(this.col - endCol) <= 1) {
            if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack) == true) {
                return true;
            } else {
                return false;
            }
        } else {
            // The move is not one square horizontally, vertically, or diagonally, so it's illegal.
            return false;
        }
    }

    private int row;
    private int col;
    private boolean isBlack;
}
