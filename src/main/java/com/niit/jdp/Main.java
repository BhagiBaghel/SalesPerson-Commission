package com.niit.jdp;

import com.niit.jdp.model.Salesperson;
import com.niit.jdp.repository.SalespersonRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SalespersonRepository salespersonRepository = new SalespersonRepository();
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("\nWelcome to Salesperson Management System");
                System.out.println("====================================================================");
                System.out.println("1. Add a new salesperson");
                System.out.println("2. Update the commission of a salesperson");
                System.out.println("3. Delete a salesperson");
                System.out.println("4. Display all salespersons");
                System.out.println("5. Display the details of a particular Salesperson");
                System.out.println("6. Exit");
                System.out.println("====================================================================");

                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Adding a new Sales person:");
                        System.out.print("Enter the name of the salesperson: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the city of the salesperson: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter the commission rate of the salesperson: ");
                        double commissionRate = scanner.nextDouble();
                        boolean addedSalesperson = salespersonRepository.addSalesperson(new Salesperson(name, city, commissionRate));
                        if (addedSalesperson) {
                            System.out.println("\u001B[32m Salesperson added successfully \u001B[0m");
                        } else {
                            System.err.println("Salesperson could not be added");
                        }
                        break;

                    case 2:
                        System.out.println("Updating the commission of a salesperson:");
                        System.out.print("Enter the salesperson id: ");
                        int salesId = scanner.nextInt();
                        System.out.print("Enter the new commission rate: ");
                        double newCommissionRate = scanner.nextDouble();
                        boolean updatedSalesperson = salespersonRepository.updateCommissionById(salesId, newCommissionRate);
                        if (updatedSalesperson) {
                            System.out.println("\u001B[32m Salesperson updated successfully \u001B[0m");
                        } else {
                            System.err.println("Salesperson could not be updated");
                        }
                        break;

                    case 3:
                        System.out.println("Deleting a salesperson:");
                        System.out.print("Enter the salesperson id: ");
                        int salesIdToDelete = scanner.nextInt();
                        boolean deletedSalesperson = salespersonRepository.deleteById(salesIdToDelete);
                        if (deletedSalesperson) {
                            System.out.println("\u001B[32m Salesperson deleted successfully \u001B[0m");
                        } else {
                            System.err.println("Salesperson could not be deleted");
                        }
                        break;

                    case 4:
                        System.out.println("Displaying all the Salesperson Records:");
                        List<Salesperson> allSalespersons = salespersonRepository.getAllSalespersons();
                        for (Salesperson salesperson : allSalespersons) {
                            System.out.println(salesperson);
                        }
                        break;

                    case 5:
                        System.out.println("Displaying the details of a particular Salesperson:");
                        System.out.print("Enter the salesperson id: ");
                        int salesIdToDisplay = scanner.nextInt();
                        Salesperson salesperson = salespersonRepository.getSalespersonById(salesIdToDisplay);
                        System.out.println(salesperson);
                        break;

                    case 6:
                        System.out.println("Exiting the application");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 6);
        } catch (SQLException | ClassNotFoundException exception) {
            System.err.println("Something went wrong.");
            exception.printStackTrace();
        }
    }
}