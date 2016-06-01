package game;

import java.util.Arrays;

class Board {

    private char[][] board = new char[3][3];
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Player winner;
    private int countsMoves;
    private boolean start;

    Board(Player playerX, Player playerO) {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        this.playerX = playerX;
        this.playerO = playerO;
        currentPlayer = playerX;
        countsMoves = 0;
    }

    public boolean getStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        currentPlayer = playerX;
        winner = null;
        countsMoves = 0;
    }

    boolean gameFinished() {
        if (countsMoves < 5) return false;
        if (calculateWinner() != null) return true;
        if (countsMoves == 9) return true;
        return false;
    }

    boolean makeMove() {
        String move = getAnotherPlayer(currentPlayer).makeMove();

        if (move.length() != 2) {
            return false;
        }

        int x = Character.getNumericValue(move.charAt(0)) - 1;
        int y = Character.getNumericValue(move.charAt(1)) - 1;

        if (!isMoveValid(x, y)) {
            return false;
        }
        changeCurrentPlayer();
        board[x][y] = currentPlayer.getType();
        countsMoves++;
        return true;
    }

    boolean makeMove(String move) {
        changeCurrentPlayer();

        int x = Character.getNumericValue(move.charAt(0)) - 1;
        int y = Character.getNumericValue(move.charAt(1)) - 1;

        if (!isMoveValid(x, y))
            return false;

        board[x][y] = currentPlayer.getType();
        countsMoves++;

        return true;
    }

    private void changeCurrentPlayer() {
        currentPlayer = getAnotherPlayer(currentPlayer);
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    Player getNextPlayer() {
        return getAnotherPlayer(currentPlayer);
    }

    Player getAnotherPlayer(Player player) {
        if (player == playerX)
            player = playerO;
        else
            player = playerX;
        return player;
    }

    String getResultGame() {
        if (winner == null) {
            return "The winner is not defined";
        } else {
            return "The winner is " + winner;
        }
    }

    public Player calculateWinner() {
        char type = currentPlayer.getType();

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == type && board[i][1] == type && board[i][2] == type)
                winner = currentPlayer;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == type && board[1][i] == type && board[2][i] == type)
                winner = currentPlayer;
        }

        if (board[0][0] == type && board[1][1] == type && board[2][2] == type)
            winner = currentPlayer;

        if (board[2][0] == type && board[1][1] == type && board[0][2] == type)
            winner = currentPlayer;

        return winner;
    }

    public Player getLoser() {
        if (winner == null) {
            return null;
        }
        return (winner == playerX) ? playerO : playerX;
    }

    public Player getWinner() {
        return winner;
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