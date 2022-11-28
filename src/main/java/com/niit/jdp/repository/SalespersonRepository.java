/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Salesperson;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
     *
     * @return List of Salesperson objects
     */
    public List<Salesperson> getAllSalespersons() {
        List<Salesperson> salespersons = new ArrayList<>();
        //2. write a query to select all records from the table
        String selectQuery = "SELECT * FROM `sales_commission`.`salesperson`;";
        //3. create a Statement object
        try (Statement statement = connection.createStatement()) {
            //4. execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(selectQuery);

            //5. iterate over the result set and get the values from the result set
            while (resultSet.next()) {
                //6. get all the values from the result set and store them inside variables
                int salesId = resultSet.getInt("sales_id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                double commissionRate = resultSet.getDouble("commission_rate");

                //7. create a Salesperson object using the values from the result set
                Salesperson salesperson = new Salesperson(salesId, name, city, commissionRate);

                //8. add the salesperson object to the salespersons list
                salespersons.add(salesperson);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return salespersons;
    }
}
