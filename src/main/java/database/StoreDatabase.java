package database;

import models.UserModel;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreDatabase {
    private static final String DATABASE_NAME = "postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static PGSimpleDataSource dataSource;

    public static PGSimpleDataSource getDataSource(){
        if (dataSource==null){
            dataSource = new PGSimpleDataSource();
            dataSource.setDatabaseName(DATABASE_NAME);
            dataSource.setUser(USER);
            dataSource.setPassword(PASSWORD);
        }
        return dataSource;
    }

    public static UserModel getUserByEmail(String email){
        try (Statement statement = getDataSource().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery( String.format(Files.readString(Path.of("src/test/resources/sqlqueries/selectuserbyemail.sql")), email))) {
            UserModel user = new UserModel();
            while (resultSet.next()){
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
            }
            return user;
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
