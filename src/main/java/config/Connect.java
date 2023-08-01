package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection connection;

    public Connection newConnection() throws SQLException {

        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
        }

        return connection;
    }

    public Connect() throws SQLException {
        newConnection();
    }
}
