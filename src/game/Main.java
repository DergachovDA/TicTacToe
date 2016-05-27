package game;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = "start";
        Scanner scanner = new Scanner(System.in);
        Statistics statistics = Statistics.getInstance();
        Player playerX;
        Player playerO;
        Board board;

        while (true) {
            switch (input) {

                case "stat":
                    printStatistics(statistics);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "start":

                    playerX = new Human('X');
                    playerO = new Human('O');
                    board = new Board(playerX, playerO);

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new MainForm(board);
                        }
                    });

                    System.out.println("Game started...");
                    game(board);

                    System.out.println(board.getWinnerPlayer());

                    addNewStatistics(board, statistics);
                    break;
            }

            printHelp();

            input = scanner.next();
        }
    }

    private static void printHelp() {
        System.out.println("Enter the \"start\" to start a new game");
        System.out.println("\t\t  \"stat\"  to show statistics");
        System.out.println("\t\t  \"exit\"  to exit the application.");
    }

    private static void addNewStatistics(Board board, Statistics statistics) {
        if (board.calculateWinner() == null) {
            statistics.addResult(new GameResult(board.getCurrentPlayer(), GameResult.DRAW));
            statistics.addResult(new GameResult(board.getNextPlayer(), GameResult.DRAW));
        } else {
            statistics.addResult(new GameResult(board.calculateWinner(), GameResult.WIN));
            statistics.addResult(new GameResult(board.calculateLoser(), GameResult.LOSS));
        }
    }

    private static void game(Board board) {
        while (!board.gameFinished()) {
            System.out.println("Player " + board.getCurrentPlayer() + " move...");
            System.out.println("Enter your move: ");
            if (!board.makeMove()) {
                System.out.println("Input incorrect! Repeat your move.");
            } else {
                System.out.println(board);
            }
        }
    }

    private static void printStatistics(Statistics statistics) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the \"a\" to show all results");
        System.out.println("\t\t  \"w\" - all winers");
        System.out.println("\t\t  \"l\" - all losses");
        System.out.println("\t\t  \"y\" - results for the year");
        System.out.println("\t\t  \"m\" - results for the month");
        System.out.println("\t\t  \"d\" - results for the day.");

        switch (scanner.next()) {
            case "a":
                System.out.println("All results:");
                System.out.println(statistics);
                break;
            case "w":
                System.out.println("All winers:");
                System.out.println(statistics.getAllWins());
                break;
            case "l":
                System.out.println("All losses:");
                System.out.println(statistics.getAllLosses());
                break;
            case "y":
                System.out.println("All results for the year:");
                System.out.println(statistics.getForYear());
                break;
            case "m":
                System.out.println("All results for the month:");
                System.out.println(statistics.getForMonth());
                break;
            case "d":
                System.out.println("All results for the day:");
                System.out.println(statistics.getForDay());
                break;
        }
    }

}