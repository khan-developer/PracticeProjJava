package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    static Connection connection =null;
    //static PreparedStatement preparedStatement =null;

    public Connection makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankServiceDB", "root", "mypass");
            if (connection != null) {
                System.out.println("Database Connection Successful.!!!");
            } else {
                System.out.println("Database Connection Failed.!!!");
            }
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            return connection;
        }
        return connection;
    }
}
