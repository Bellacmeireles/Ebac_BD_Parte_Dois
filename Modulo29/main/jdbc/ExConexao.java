package Modulo29.main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExConexao {

    private static Connection connection;
    private ExConexao(Connection connection) {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
            return connection;
        } else if (connection.isClosed()) {
            connection = initConnection();
            return connection;
        } else {
           return connection; 
        } 
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste_java_vscode", "postgres", "5678");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
