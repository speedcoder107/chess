// Written by Akshat Sharma, sharm849

import static java.lang.Math.abs;

public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", this);
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece piece = this.board[startRow][startCol];
        if (piece.isMoveLegal(this, endRow, endCol)) {
//          shifts the starting piece in the end row and end column
            this.board[endRow][endCol] = this.board[startRow][startCol];
            this.board[endRow][endCol].setPosition(endRow, endCol);
            this.board[startRow][startCol] = null;

            return true;
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
//        create a counter that counts the number of kings of the board
        int kingCounter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPiece(i,j) != null){
                    if (this.getPiece(i,j).getCharacter() == '\u2654' || this.getPiece(i,j).getCharacter() == '\u265a') {
                        kingCounter += 1;
                    }
                }
            }

        }
//        if there are 2 kings, then the game is still going
        if (kingCounter == 2)
            return false;
        else
            return true;
    }


    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // Sets every cell of the array to null. For debugging and grading purposes.
                board[i][j] = null;
            }
        }
    }
    public String toString() {
        // Construct a String that represents the Board object's 2D array. Return
        // the fully constructed String.
//        " " used these as short spaces characters for alignment purposes
        String result = " 0 1 2 3 4 5 6 7 \n";
        for (int i = 0; i < board.length; i++) {
            result += i + " |";
            for (int j = 0; j < board.length; j++) {
                if (this.getPiece(i,j) == null){
                    result += " " + "|";
                }
                else {
//                    place the piece
                    result += this.getPiece(i, j).getCharacter() + "|";
                }
            }
            result += "\n";
        }
        return result;
    }

    // Movement helper functions

    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
//       index doesn't go out of bounds
        if (startRow >= 0 && startRow <= 7 && startCol >= 0 && startCol <= 7 && endRow >= 0 &&
                endRow <= 7 && endCol >= 0 && endCol <= 7){
        Piece startPiece = this.board[startRow][startCol];
        Piece endPiece = this.board[endRow][endCol];
//            checks the first and last slot
        if (startPiece != null) {
                if (startPiece.getIsBlack() == isBlack) {
                    if (endPiece == null || endPiece.getIsBlack() != isBlack) {
                        return true;
                    }
                }
            }
            }
        return false;
    }

    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1) {
            return true;
        }
        return false;
    }

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {
//            if we are going to the right of the board
            if (startCol < endCol) {
                for (int i = startCol + 1; i < endCol; i++) {
//                    check every middle slot is empty
                    if (board[startRow][i] != null) {
                        return false;
                    }
                }
                return true;
            }
//            if we are going to the left of the board
            else if (startCol > endCol) {
                for (int i = startCol - 1; i > endCol; i--) {
//                    check every middle slot is empty
                    if (board[startRow][i] != null) {
                        return false;
                    }
                }

                return true;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol) {
//            if we are going up the board
            if (startRow < endRow) {
                for (int i = startRow + 1; i < endRow; i++) {
//                    check every middle slot is empty
                    if (board[i][startCol] != null) {
                        return false;
                    }
                }
                return true;
            }
//            if we are going down the board
            else if (startRow > endRow) {
                for (int i = startRow - 1; i > endRow; i--) {
//                    check every middle slot is empty
                    if (board[i][startCol] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {

        // Calculate the absolute difference between the start and end positions
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);
        int minRow = Math.min(startRow, endRow);
        int maxRow = Math.max(startRow, endRow);
        int minCol = Math.min(startCol, endCol);
        int maxCol = Math.max(startCol, endCol);

        // Check if the move is diagonal: change in row and col must be equal
        if (rowDiff != colDiff) {
            return false;
        }

//        checks for diagonal in upper-right side
        if (endRow > startRow && endCol > startCol){
            for (int i = 1; i < rowDiff; i++){
                if (this.board[minRow + i][minCol + i] != null){
                    return false;
                }
            }
        }
//        checks for diagonal in lower-right side
        else if (endRow < startRow && endCol > startCol){
            for (int i = 1; i < rowDiff; i++){
                if (this.board[maxRow - i][minCol + i] != null){
                    return false;
                }
            }
        }
//        check for diagonal in upper-left side
        else if (endRow > startRow && endCol < startCol){
            for (int i = 1; i < rowDiff; i++){
                if (this.board[minRow + i][maxCol - i] != null){
                    return false;
                }
            }
        }
//        check for diagonal in lower-left side
        else if (endRow < startRow && endCol < startCol){
            for (int i = 1; i < rowDiff; i++){
                if (this.board[maxRow - i][maxCol - i] != null){
                    return false;
                }
            }
        }
        return true;
    }
}
