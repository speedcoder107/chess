// Written by Akshat Sharma, sharm849

import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Board myBoard = new Board();
        Scanner myScan = new Scanner(System.in);
        int counter = -1;
        while (myBoard.isGameOver() == false){
            System.out.println(myBoard);
            if (myBoard.isGameOver() == false) {
                counter += 1;
                boolean legal;
                System.out.println("Enter next move: ");
                String move = myScan.nextLine();
                int startRow = Integer.parseInt(move.substring(0,1));
                int startCol = Integer.parseInt(move.substring(2,3));
                int endRow = Integer.parseInt(move.substring(4,5));
                int endCol = Integer.parseInt(move.substring(6,7));
                if (counter%2 != 0) {
                    if (startRow < 0 && startCol < 0 && endCol > 7 && endCol > 7){
                        legal = false;
                    }
                    else if (myBoard.getPiece(startRow, startCol) == null || myBoard.getPiece(startRow, startCol).getIsBlack() == true){
                        legal = false;
                }
                    else {
                        legal = myBoard.movePiece(startRow, startCol, endRow, endCol);
                    }
                    while (legal == false) {
                        System.out.println("illegal move, go again");
                        System.out.println("Enter next move: ");
                        move = myScan.nextLine();
                        startRow = Integer.parseInt(move.substring(0, 1));
                        startCol = Integer.parseInt(move.substring(2, 3));
                        endRow = Integer.parseInt(move.substring(4, 5));
                        endCol = Integer.parseInt(move.substring(6, 7));
                        if (startRow < 0 && startCol < 0 && endCol > 7 && endCol > 7){
                            legal = false;
                        }
                        else if (myBoard.getPiece(startRow, startCol) == null || myBoard.getPiece(startRow, startCol).getIsBlack() == true){
                            legal = false;
                    }
                        else {
                            legal = myBoard.movePiece(startRow, startCol, endRow, endCol);
                        }
                    }
                }
                else {
                    if (startRow < 0 && startCol < 0 && endCol > 7 && endCol > 7){
                        legal = false;
                    }
                    else if (myBoard.getPiece(startRow, startCol) == null || myBoard.getPiece(startRow, startCol).getIsBlack() == false){
                        legal = false;
                }
                    else {
                        legal = myBoard.movePiece(startRow, startCol , endRow, endCol);
                    }
                    while (legal == false) {
                        System.out.println("illegal move, go again");
                        System.out.println("Enter next move: ");
                        move = myScan.nextLine();
                        startRow = Integer.parseInt(move.substring(0, 1));
                        startCol = Integer.parseInt(move.substring(2, 3));
                        endRow = Integer.parseInt(move.substring(4, 5));
                        endCol = Integer.parseInt(move.substring(6, 7));
                        if (startRow < 0 && startCol < 0 && endCol > 7 && endCol > 7){
                            legal = false;
                        }
                        else if (myBoard.getPiece(startRow, startCol) == null|| myBoard.getPiece(startRow, startCol).getIsBlack() == false) {
                            legal = false;
                        }
                        else {
                            legal = myBoard.movePiece(startRow, startCol, endRow, endCol);
                        }
                    }
                }
            }
            if (myBoard.isGameOver() == true){
                System.out.println("Checkmate!!");
            }
        }
    }
}

