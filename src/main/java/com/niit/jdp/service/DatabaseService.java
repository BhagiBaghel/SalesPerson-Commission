/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/sales_commission";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pinky@123";
    Connection connection;

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
            System.out.println("Connected to Database");
        } else {
            System.err.println("!! Database Connection Failed !!");
        }
    }
}
