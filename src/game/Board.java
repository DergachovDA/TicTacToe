package game;

import java.util.Arrays;

class Board {

    private char[][] board = new char[3][3];
    private char currentPlayer;
    private byte countsMoves;

    Board() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        currentPlayer = 'X';
        countsMoves = 0;
    }

    boolean gameFinished() {

        if (countsMoves == 9) return true;

        char ch = (currentPlayer == 'X') ? 'O' : 'X';

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == ch && board[1][i] == ch && board[2][i] == ch)
                return true;
        }

        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch)
            return true;

        if (board[2][0] == ch && board[1][1] == ch && board[0][2] == ch)
            return true;

        return false;
    }

    boolean makeMove(String move) {
        int x = Character.getNumericValue(move.charAt(0)) - 1;
        int y = Character.getNumericValue(move.charAt(1)) - 1;

        if (!isMoveValid(x, y))
            return false;

        board[x][y] = currentPlayer;
        countsMoves++;
        changeCurrentPlayer();
        return true;
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == 'X')
            currentPlayer = 'O';
        else
            currentPlayer = 'X';
    }

    char getCurrentPlayer() {
        return currentPlayer;
    }

    String getWinnerPlayer() {
        if (countsMoves == 9) {
            return "not defined";
        } else {
            return currentPlayer == 'X' ? "O" : "X";
        }
    }

    private boolean isMoveValid(int x, int y) {
        return !(x > 2 || y > 2 || x < 0 || y < 0 || board[x][y] != ' ');
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

}