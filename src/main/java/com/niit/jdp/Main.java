package com.niit.jdp;

import com.niit.jdp.service.DatabaseService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try {
            databaseService.getConnectionToDatabase();
            databaseService.printConnectionStatus();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}