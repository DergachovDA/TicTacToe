package game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Statistics {

    private List<GameResult> results = new ArrayList<GameResult>();
    private static Statistics instance;

    private Statistics() {
    }

    public static Statistics getInstance() {
        if (instance == null)
            instance = new Statistics();
        return instance;
    }

    public void addResult(GameResult result) {
        this.results.add(result);
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


    public String toString() {
        String out = "";
        for (GameResult gameResult : results) {
            out += gameResult.toString() + '\n';
        }
        return out;
    }
}