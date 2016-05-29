package game;
import java.util.Arrays;

class Board {

    private char[][] board = new char[3][3];
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Player nextPlayer;
    private int countsMoves;

    Board(Player playerX, Player playerO) {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        this.playerX = playerX;
        this.playerO = playerO;
        currentPlayer = playerX;
        nextPlayer = playerO;
        countsMoves = 0;
    }

    boolean gameFinished() {

        if (countsMoves < 5) return false;
        if (countsMoves == 9) return true;

        char ch = nextPlayer.getType();

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

    boolean makeMove() {
        String move = currentPlayer.makeMove();
        if (move.length() != 2) return false;
        int x = Character.getNumericValue(move.charAt(0)) - 1;
        int y = Character.getNumericValue(move.charAt(1)) - 1;

        if (!isMoveValid(x, y))
            return false;

        board[x][y] = currentPlayer.getType();
        countsMoves++;
        changeCurrentPlayer();
        return true;
    }

    private void changeCurrentPlayer() {
        nextPlayer = currentPlayer;
        if (currentPlayer == playerX)
            currentPlayer = playerO;
        else
            currentPlayer = playerX;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    Player getNextPlayer() {
        return nextPlayer;
    }

    String getWinnerPlayer() {
        if (countsMoves == 9) {
            return "The winner is not defined";
        } else {
            return "The winner is " + nextPlayer;
        }
    }

    public Player calculateWinner() {
        if (countsMoves == 9) {
            return null;
        }
        return nextPlayer;
    }

    public Player calculateLoser() {
        if (countsMoves == 9) {
            return null;
        }
        return currentPlayer;
    }


    private boolean isMoveValid(int x, int y) {
        return !(x > 2 || y > 2 || x < 0 || y < 0 || board[x][y] != ' ');
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += "[" + board[i][j] + "]";
            }
            result += "\n";
        }
        return result;
    }

}