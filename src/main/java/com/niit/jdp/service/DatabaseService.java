
package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/sales_commission";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Bhagi@777";
    Connection connection;

    public DatabaseService() {
        //connection value 'null' represents that the connection has not yet been established
        //and the database is not available for use in the Java program
        connection = null;
    }

    private void connect() throws ClassNotFoundException, SQLException {
        //1. Load the driver class using Class.forName() method
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. Establish a connection with the database using Connection interface
        //DriverManager class provides getConnection() method that returns a Connection object
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnectionToDatabase() throws SQLException, ClassNotFoundException {
        connect();
        return connection;
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Connected to Database \u001B[0m");
        } else {
            System.err.println("!! Database Connection Failed !!");
        }
    }
}
