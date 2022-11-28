package com.niit.jdp;

import com.niit.jdp.model.Salesperson;
import com.niit.jdp.repository.SalespersonRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            SalespersonRepository salespersonRepository = new SalespersonRepository();
            Salesperson salesperson = new Salesperson("John", "New York", 0.15);
            boolean addedSalesperson = salespersonRepository.addSalesperson(salesperson);
            if (addedSalesperson) {
                System.out.println("Salesperson added successfully");
            } else {
                System.out.println("Salesperson could not be added");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}