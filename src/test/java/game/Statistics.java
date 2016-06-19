package game;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Statistics {

    private List<GameResult> results = new ArrayList<GameResult>();
    private static Statistics instance;

    private Statistics() throws IOException, SQLException {
        Properties properties = loadProperties();
        Connection connection = DriverManager.
                getConnection(properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));

    }

    public static Statistics getInstance() throws IOException, SQLException {
        if (instance == null)
            instance = new Statistics();
        return instance;
    }

    public Statistics getStatisticsFromDB(Connection connection) throws SQLException, IOException {
        Statistics statistics = new Statistics();
//        GameResult result = new GameResult();
        String sql = "SELECT * FROM statistics";
        Statement statement = connection.createStatement();
        statement.execute(sql);

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            String str = "";
            str += resultSet.getString("id") + ", ";
            str += resultSet.getString("lastname") + ", ";
            str += resultSet.getString("firstname") + ", ";
            str += resultSet.getString("age");
            System.out.println(str);
        }

        return statistics;
    }

    public void addResult(GameResult result) {
        System.out.println(result);
        this.results.add(result);
    }

    public Statistics getAllWins() throws IOException, SQLException {
        Statistics allWins = new Statistics();
        for (GameResult result : results) {
            if (result.getResult().equals(GameResult.WIN)) {
                allWins.addResult(result);
            }
        }
        return allWins;
    }

    public Statistics getAllLosses() throws IOException, SQLException {
        Statistics allLosses = new Statistics();
        for (GameResult result : results) {
            if (result.getResult().equals(GameResult.LOSS)) {
                allLosses.addResult(result);
            }
        }
        return allLosses;
    }

    public Statistics getForYear() throws IOException, SQLException {
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

    public Statistics getForMonth() throws IOException, SQLException {
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

    public Statistics getForDay() throws IOException, SQLException {
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

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream stream = getClass().getResourceAsStream("db.properties");
        properties.load(stream);
        return properties;
    }

    public String toString() {
        String out = "";
        for (GameResult gameResult : results) {
            out += gameResult.toString() + '\n';
        }
        return out;
    }
}