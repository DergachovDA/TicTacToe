package game;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DB {
    private Connection connection;

    public DB() {
        try {
            isConnect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadProperties() throws IOException{
        Properties properties = new Properties();
        InputStream stream = getClass().getResourceAsStream("db.properties");
        properties.load(stream);
        return properties;
    }

    public boolean isConnect() throws IOException, SQLException {
        Properties properties = loadProperties();

        this.connection = DriverManager.
                getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));

        return true;
    }

    public List<GameResult> getStatistics() throws SQLException {
        List<GameResult> results = new ArrayList<GameResult>();
        String sql = "SELECT * FROM statistics";
        Statement statement = this.connection.createStatement();
        statement.execute(sql);

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            Player player = new Human(resultSet.getString("firstname"),
                    resultSet.getString("middlename"),
                    resultSet.getString("lastname"),
                    resultSet.getInt("age"),
                    resultSet.getString("type").charAt(0));
            GameResult result = new GameResult(player, resultSet.getString("result"));
            result.setDate(resultSet.getLong("date"));

            results.add(result);
        }
        return results;
    }

    public void addStatistics (GameResult result) throws SQLException {
        String sql = "insert into statistics " +
                "(lastname, firstname, middlename, age, type, result, date) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, result.getPlayer().getLastname());
        preparedStatement.setString(2, result.getPlayer().getFirstname());
        preparedStatement.setString(3, result.getPlayer().getMiddlename());
        preparedStatement.setInt(4, result.getPlayer().getAge());
        preparedStatement.setString(5, String.valueOf(result.getPlayer().getType()));
        preparedStatement.setString(6, result.getResult());
        preparedStatement.setLong(7, result.getDate().getTime());

        preparedStatement.execute();
    }
}
