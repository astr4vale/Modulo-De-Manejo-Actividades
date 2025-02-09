
package com.codideep.app.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseContext {

    private static final String CONNECTIONSTRING = "jdbc:mariadb://localhost:3306/ModuloActividades";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection CONNECTION = null;

    public static void generateConnection() {
        try {
            System.out.println("Intentando conectar a la base de datos...");
            CONNECTION = DriverManager.getConnection(CONNECTIONSTRING, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return CONNECTION;
    }

    public static void closeConnection() throws SQLException {
        CONNECTION.close();
    }
}
