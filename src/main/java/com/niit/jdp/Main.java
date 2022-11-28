package com.niit.jdp;

import com.niit.jdp.repository.SalespersonRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            SalespersonRepository repository = new SalespersonRepository();
            boolean updatedCommission = repository.updateCommissionById(1005, 15);
            if (updatedCommission) {
                System.out.println("Commission Updated Successfully");
            } else {
                System.out.println("Commission Update Failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}