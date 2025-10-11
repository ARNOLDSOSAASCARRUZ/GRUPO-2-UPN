package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/reciclaje_comunitario";
    private static final String USER = "root"; // usuario
    private static final String PASSWORD = "jowi123"; // contraseña real

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}