# PvP Chess game

This is Java program that allows 2 users to play chess against each other. 

I used different classes for each of the different pieces and then, I used the game class to combine all the pieces in the game. The game board class provides the board on which all the pieces are put on and whenever a player makes a move, the game board changes.

This code was designed and developed as a fully functional chess game in Java, allowing players to engage in matches against each other on the terminal. I Implemented object-oriented programming principles by creating classes in Java to represent the chess pieces, board, and game logic.

I also Utilized data structures and algorithms to handle move validation, piece movements, and check/checkmate conditions, ensuring accurate and fair gameplay.

Also, I haven't included the en passant feature and the castling feature yet. I might do it sometime in the future.

Assumption: When entering the moves as input by the player, if the format is not accurately followed, the code will crash. We are assuming that the format put by the player is always correct, even if the move is illegal

The format to make a move is as follows:

The chess board on the terminal will will look like this once you compile and run the game class
   0  1  2  3  4  5  6  7 
0 |♜|♞|♝|♛|♚|♝|♞|♜|
1 |♟|♟|♟|♟|♟|♟|♟|♟|
2 |  |  |  |  | |  |  |  |
3 |  |  |  |  | |  |  |  |
4 |  |  |  |  | |  |  |  |
5 |  |  |  |  | |  |  |  |
6 |♙|♙|♙|♙|♙|♙|♙|♙|
7 |♖|♘|♗|♕|♔|♗|♘|♖|

Then, remember on the 0'th row and 1'st row, we have white pieces. It may or may not look different depending on if you are using light theme or dark theme. Anyways, if you want to make a move. Let say, you want to move the pawn at 1,0 position to move one step ahead at 2,0 position. You will write
"1 0 2 0" (without the quotes and don't forget the spaces)
This will move your pawn by one step. 

If you don't use correct spaces or use anything else other than numeric characters like "1 0 20" or  "a 0 b 1", the code will crash. 

However, if you just put random numbers with the correct format but not a legitimate move. It will be considered an illegal move and you will be prompted to move again. 
. So, it will look like this 

"
   0  1  2  3  4  5  6  7 
0 |♜|♞|♝|♛|♚|♝|♞|♜|
1 |♟|♟|♟|♟|♟|♟|♟|♟|
2 |  |  |  |  | |  |  |  |
3 |  |  |  |  | |  |  |  |
4 |  |  |  |  | |  |  |  |
5 |  |  |  |  | |  |  |  |
6 |♙|♙|♙|♙|♙|♙|♙|♙|
7 |♖|♘|♗|♕|♔|♗|♘|♖|

Enter next move: 
1 0 2 0

0  1  2  3  4  5  6  7 
0 |♜|♞|♝|♛|♚|♝|♞|♜|
1 |  |♟|♟|♟|♟|♟|♟|♟|
2 |♟|  |  |  | |  |  |  |
3 |  |  |  |  | |  |  |  |
4 |  |  |  |  | |  |  |  |
5 |  |  |  |  | |  |  |  |
6 |♙|♙|♙|♙|♙|♙|♙|♙|
7 |♖|♘|♗|♕|♔|♗|♘|♖|

Enter next move: 
2 0 5 0
illegal move, go again
Enter next move:

"

I hope you understand how to play this game. Hope you find it awesome. 
Enjoy!!
