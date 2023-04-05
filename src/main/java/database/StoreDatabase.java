package database;

import models.UserModel;
import org.postgresql.ds.PGSimpleDataSource;
import utils.SqlUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreDatabase {
    private static final String DATABASE_NAME = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
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
        try {
            ResultSet resultSet = SqlUtil.executeSqlScript(getDataSource(),
                    String.format(Files.readString(Path.of("src/test/resources/sqlqueries/selectuserbyemail.sql")), email));
            UserModel user = new UserModel();
            user.setEmail(resultSet.getString("email"));
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
