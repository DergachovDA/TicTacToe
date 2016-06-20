package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Statistics {

    private List<GameResult> results = new ArrayList<GameResult>();
    private static Statistics instance;
    private DB db = new DB();

    private Statistics() {
    }

    public static Statistics getInstance() {
        if (instance == null)
            instance = new Statistics();
        return instance;
    }

    public void addResult(GameResult result) {
        this.results.add(result);
        try {
            this.db.isConnect();
            this.db.addStatistics(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Statistics getAllWins() {
        Statistics allWins = new Statistics();
        for (GameResult result : results) {
            if (result.getResult().equals(GameResult.WIN)) {
                allWins.addResult(result);
            }
        }
        return allWins;
    }

    public Statistics getAllLosses() {
        Statistics allLosses = new Statistics();
        for (GameResult result : results) {
            if (result.getResult().equals(GameResult.LOSS)) {
                allLosses.addResult(result);
            }
        }
        return allLosses;
    }

    public Statistics getForYear() {
        Statistics statisticsForYear = new Statistics();
        Date currentDate = new Date();
        long yearAgo = currentDate.getTime() - 31536000000L;
        for (GameResult result : results) {
            if (result.getDate().getTime() > yearAgo) {
                statisticsForYear.addResult(result);
            }
        }
        return statisticsForYear;
    }

    public Statistics getForMonth() {
        Statistics statisticsForYear = new Statistics();
        Date currentDate = new Date();
        long monthAgo = currentDate.getTime() - 2592000000L;
        for (GameResult result : results) {
            if (result.getDate().getTime() > monthAgo) {
                statisticsForYear.addResult(result);
            }
        }
        return statisticsForYear;
    }

    public Statistics getForDay() {
        Statistics statisticsForYear = new Statistics();
        Date currentDate = new Date();
        long dayAgo = currentDate.getTime() - 86400000L;
        for (GameResult result : results) {
            if (result.getDate().getTime() > dayAgo) {
                statisticsForYear.addResult(result);
            }
        }
        return statisticsForYear;
    }

    public void sortByFirstnamePlayer() {
        Collections.sort(results);
    }

    public void sortByWin() {
        Collections.sort(results, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult gr1, GameResult gr2) {

                if (gr1.equalsWin()) {
                    if (gr2.equalsWin())
                        return 0;
                    if (gr2.equalsDraw())
                        return -1;
                    if (gr2.equalsLoss())
                        return -1;
                }

                if (gr1.equalsDraw()) {
                    if (gr2.equalsWin())
                        return 1;
                    if (gr2.equalsDraw())
                        return 0;
                    if (gr2.equalsLoss())
                        return -1;
                }

                if (gr1.equalsLoss()) {
                    if (gr2.equalsWin())
                        return 1;
                    if (gr2.equalsDraw())
                        return 1;
                    if (gr2.equalsLoss())
                        return 0;
                }

                return 0;
            }
        });
    }

    public void sortByLoss() {
        Collections.sort(results, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult gr1, GameResult gr2) {

                if (gr1.equalsWin()) {
                    if (gr2.equalsWin())
                        return 0;
                    if (gr2.equalsDraw())
                        return 1;
                    if (gr2.equalsLoss())
                        return 1;
                }

                if (gr1.equalsDraw()) {
                    if (gr2.equalsWin())
                        return -1;
                    if (gr2.equalsDraw())
                        return 0;
                    if (gr2.equalsLoss())
                        return 1;
                }

                if (gr1.equalsLoss()) {
                    if (gr2.equalsWin())
                        return -1;
                    if (gr2.equalsDraw())
                        return -1;
                    if (gr2.equalsLoss())
                        return 0;
                }

                return 0;
            }
        });
    }

    public String toString() {
        String out = "";
        for (GameResult gameResult : results) {
            out += gameResult.toString() + '\n';
        }
        return out;
    }
}