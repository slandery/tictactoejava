package com.tts;

public class TicTacToeClass {
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    //the default constructor, which just creates the two-dimensional array and fills each slot with ' ' (a blank space)
    // and initializes the other attributes
    public TicTacToeClass() {
        //	a two-dimensional array of chars 3X3
        board = new char[3][3];
        // an integer keeping track of the number of turns played this game
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods
    //returns true if the letter passed in currently has three in a row.
    // That is, isWinner('X') will return true if X has won, and isWinner('O') will return true if O has won

    public boolean isWinner(char p) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
                return true;
            }
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
                return true;
            }
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
            return true;
        }
        else return board[0][2] == p && board[1][1] == p && board[2][0] == p;
    }


    //returns true if nine turns have been played and false otherwise
    public boolean isFull() {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == ' ') {
                    return false;
                }
            }
        }return true;
    }


    //returns true if all nine spaces are filled AND neither X nor O has won
    public boolean isCat() {
        boolean winner_X = isWinner('X');
        boolean winner_O = isWinner('O');
        if (isFull()) {
            return !winner_X && !winner_O;
        }  return false;
    }


    //returns true if the given row and column corresponds to a valid space on the board
    public boolean isValid(int r, int c) {
        return 0 <= r && r <= 2 && 0 <= c && c <= 2;
    }


    //returns the numbers of turns played so far refer to this
    public int numTurns() {
        return this.turns;
    }


    //returns the character representing the piece at the given location. Should return either ' ', 'X', or 'O'.
    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }


    //	displays the current board on the screen
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    //allows the given player to place their move at the given row and column.
    // The row and column numbers are 0-based, so valid numbers are 0, 1, or 2 ie less than 3
    public void playMove(char p, int r, int c) {
//        for ( int r =0; r<3; r++ )
//            for ( int c=0; c<3; c++ )
                board[r][c] = p;
            this.turns++;
    }

}

