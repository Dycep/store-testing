package utils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

    public static ResultSet executeSqlScript(DataSource dataSource, String query) {
        try (Statement statement = dataSource.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //TODO add logger, NOT ONLY HERE!!!
        }
    }
}
