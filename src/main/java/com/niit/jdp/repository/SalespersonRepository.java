/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Salesperson;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
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

    /**
     * This method is used to get the record os a salesperson based on their id
     *
     * @param salesId
     * @return Salesperson object
     */
    public Salesperson getSalespersonById(int salesId) {
        //2. write a query to select a particular record from the salesperson table
        //? is a placeholder for the value of salesId
        String selectQuery = "select * from `sales_commission`.`salesperson` where (`sales_id` = ?);";
        Salesperson salesperson = null;

        //3. create a PreparedStatement object to execute a parameterized query
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            //4. set the value of the parameter
            preparedStatement.setInt(1, salesId);

            //5. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            //6. check if the result set has a record
            if (resultSet.next()) {
                //7. get the values from the result set and store them inside variables
                int id = resultSet.getInt("sales_id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                double commissionRate = resultSet.getDouble("commission_rate");

                //8. create a Salesperson object using the values from the result set
                salesperson = new Salesperson(id, name, city, commissionRate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //9. return the sales person object
        return salesperson;
    }

    /**
     * This method is used to insert a new record in the salesperson table
     *
     * @param salesperson
     * @return true if the record is inserted successfully, false otherwise
     */
    public boolean addSalesperson(Salesperson salesperson) {
        int numberOfRowsAffected = 0;
        //2. write an insert query
        String insertQuery = "insert into `sales_commission`.`salesperson` (`name, `city`, `commission_rate`)" +
                "values (?, ?, ?);";
        //3. create PreparedStatement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            //4. set the values for parameters in insert query
            preparedStatement.setString(1, salesperson.getName());
            preparedStatement.setString(2, salesperson.getCity());
            preparedStatement.setDouble(3, salesperson.getCommissionRate());

            //5. execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberOfRowsAffected > 0;
    }
}
