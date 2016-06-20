package game;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    private Connection connection;
    private Properties properties;

    public DB() {
    }

    private Properties loadProperties() throws IOException{
        Properties properties = new Properties();
        InputStream stream = getClass().getResourceAsStream("db.properties");
        properties.load(stream);
        return properties;
    }

    public boolean isConnect() throws IOException, SQLException {
        this.properties = loadProperties();
        this.connection = DriverManager.
                getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
        return true;
    }

    public void printStudents(Connection connection) throws SQLException {
    }

    public void addStatistics (GameResult result) throws SQLException {
        String sql = "insert into statistics (lastname , firtname , midname , age, type, result, date) values (?, ?, ?, ?, ?, ?, ?)";

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
