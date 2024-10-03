package com.btrs;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AllOperations operations = new AllOperations(scanner);

        while (true) {
            System.out.println("=== Bus Ticket Reservation System ===");
            System.out.println("1. Admin Operations");
            System.out.println("2. Customer Operations");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminOperations(scanner, operations);
                    break;
                case 2:
                    customerOperations(scanner, operations);
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminOperations(Scanner scanner, AllOperations operations) {
        while (true) {
            System.out.println("\n=== Admin Operations ===");
            System.out.println("1. Add Bus");
            System.out.println("2. Add Route");
            System.out.println("3. Add Schedule");
            System.out.println("4. View Buses");
            System.out.println("5. View Routes");
            System.out.println("6. View Schedules");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an operation: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    operations.addBus();
                    break;
                case 2:
                    operations.createRoute();
                    break;
                case 3:
                    operations.createSchedule();
                    break;
                case 4:
                    operations.viewBus();
                    break;
                case 5:
                    operations.viewRoute();
                    break;
                case 6:
                    operations.viewSchedule();
                    break;
                case 7:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void customerOperations(Scanner scanner, AllOperations operations) {
        while (true) {
            System.out.println("\n=== Customer Operations ===");
            System.out.println("1. Register Customer");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Ticket");
            System.out.println("5. Make Payment");
            System.out.println("6. View Payment");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an operation: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    operations.registerCustomer();
                    break;
                case 2:
                    operations.bookTicket();
                    break;
                case 3:
                    operations.cancelTicket();
                    break;
                case 4:
                    operations.viewTicket();
                    break;
                case 5:
                    operations.makePayment();
                    break;
                case 6:
                    operations.viewPayment();
                    break;
                case 7:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

