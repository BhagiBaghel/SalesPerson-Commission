/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

public class SalespersonRepository {
    Connection connection;
    DatabaseService databaseService;

    public SalespersonRepository() throws SQLException, ClassNotFoundException {
        databaseService = new DatabaseService();
        //1. establish connection to the database
        connection = databaseService.getConnectionToDatabase();
    }

    /**
     * This method is used to get all the records from the salesperson table in sales_commission database
     */
    List<Salesperson> getAllSalespersons() {

    }
}
