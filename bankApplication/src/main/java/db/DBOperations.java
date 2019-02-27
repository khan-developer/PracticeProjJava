package db;

import model.CreateAccount;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperations {
    private CreateAccount createAccount;
    static PreparedStatement preparedStatement =null;
    Connection connection;

    public DBOperations(DBConnection dbConnection) {
        connection = dbConnection.makeJDBCConnection();
    }

    public void createAccountHolder(String accountHolderCode, String sqlDateTime){
        String query = "Insert into account_holder Values (?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,accountHolderCode);
            preparedStatement.setDate(2, Date.valueOf(sqlDateTime));
            preparedStatement.setString(3,createAccount.getFirstName());
            preparedStatement.setString(4,createAccount.getLastName());
            preparedStatement.setString(5,createAccount.getAddressLine1());
            preparedStatement.setString(6,createAccount.getAddressLine2());
            preparedStatement.setString(7,createAccount.getCountry());
            preparedStatement.setString(8,createAccount.getZipCode());

            preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
