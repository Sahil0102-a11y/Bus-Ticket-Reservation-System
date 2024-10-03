package com.btrs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.btrs.ServiceImpl.BusServiceImpl;
import com.btrs.ServiceImpl.RouteServiceImpl;
import com.btrs.ServiceImpl.ScheduleServiceImpl;
import com.btrs.ServiceImpl.CustomerServiceImpl;
import com.btrs.ServiceImpl.TicketServiceImpl;
import com.btrs.ServiceImpl.PaymentServiceImpl;
import com.btrs.ServiceImpl.AdminServiceImpl;
import com.btrs.entity.Admin;
import com.btrs.entity.Bus;
import com.btrs.entity.Customer;
import com.btrs.entity.Payment;
import com.btrs.entity.Route;
import com.btrs.entity.Schedule;
import com.btrs.entity.Ticket;

public class AllOperations {
    private static Scanner scanner;
    private static BusServiceImpl busService;
    private static RouteServiceImpl routeService;
    private static ScheduleServiceImpl scheduleService;
    private static CustomerServiceImpl customerService;
    private static TicketServiceImpl ticketService;
    private static PaymentServiceImpl paymentService;
    private static AdminServiceImpl adminService;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public AllOperations(Scanner scanner) {
        this.scanner = scanner;
        busService = new BusServiceImpl();
        routeService = new RouteServiceImpl();
        scheduleService = new ScheduleServiceImpl();
        customerService = new CustomerServiceImpl();
        ticketService = new TicketServiceImpl();
        paymentService = new PaymentServiceImpl();
        adminService = new AdminServiceImpl();
    }

    // Admin Operations
    public void addAdmin() {
        System.out.println("Enter Admin Username:");
        String username = scanner.next();
        System.out.println("Enter Admin Password:");
        String password = scanner.next();
        Admin admin = new Admin(username, password);
        adminService.addAdmin(admin);
        System.out.println("Admin added successfully.");
    }

    public void viewAdmin() {
        System.out.println("Enter Admin ID:");
        int adminId = scanner.nextInt();
        Admin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            System.out.println("Admin Details: " + admin);
        } else {
            System.out.println("Admin not found!");
        }
    }

    public void updateAdmin() {
        System.out.println("Enter Admin ID to update:");
        int adminId = scanner.nextInt();
        Admin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            System.out.println("Enter new Admin Username:");
            String username = scanner.next();
            System.out.println("Enter new Admin Password:");
            String password = scanner.next();
            admin.setUserName(username);
            admin.setPassword(password);
            adminService.updateAdmin(admin);
            System.out.println("Admin updated successfully.");
        } else {
            System.out.println("Admin not found!");
        }
    }

    public void deleteAdmin() {
        System.out.println("Enter Admin ID to delete:");
        int adminId = scanner.nextInt();
        adminService.deleteAdmin(adminId);
        System.out.println("Admin deleted successfully.");
    }

    // Bus Operations
    public void addBus() {
        System.out.println("Enter Bus Number:");
        int busNumber = scanner.nextInt();
        System.out.println("Enter Seat Capacity:");
        int seatCapacity = scanner.nextInt();
        busService.createBus(busNumber, seatCapacity);
        System.out.println("Bus added successfully.");
    }

    public void viewBus() {
        System.out.println("Enter Bus ID:");
        int busId = scanner.nextInt();
        Bus bus = busService.getBusById(busId);
        if (bus != null) {
            System.out.println("Bus Details: " + bus);
        } else {
            System.out.println("Bus not found!");
        }
    }

    // Route Operations
    public void createRoute() {
        System.out.println("Enter Start Location:");
        String startLocation = scanner.next();
        System.out.println("Enter End Location:");
        String endLocation = scanner.next();
        routeService.createRoute(startLocation, endLocation);
        System.out.println("Route added successfully.");
    }

    public void viewRoute() {
        System.out.println("Enter Route ID:");
        int routeId = scanner.nextInt();
        Route route = routeService.getRouteById(routeId);
        if (route != null) {
            System.out.println("Route Details: " + route);
        } else {
            System.out.println("Route not found!");
        }
    }

    // Schedule Operations
    public void createSchedule() {
        System.out.println("Enter Bus ID:");
        int busId = scanner.nextInt();
        System.out.println("Enter Route ID:");
        int routeId = scanner.nextInt();
        System.out.println("Enter Departure Time (yyyy-MM-dd HH:mm):");
        String departureTimeStr = scanner.next();
        try {
            LocalDateTime departureTime = LocalDateTime.parse(departureTimeStr, formatter);
            scheduleService.createSchedule(busId, routeId, departureTime);
            System.out.println("Schedule created successfully.");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
        }
    }

    public void viewSchedule() {
        System.out.println("Enter Schedule ID:");
        int scheduleId = scanner.nextInt();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        if (schedule != null) {
            System.out.println("Schedule Details: " + schedule);
        } else {
            System.out.println("Schedule not found!");
        }
    }

    // Customer Operations
    public void registerCustomer() {
        System.out.println("Enter Customer Name:");
        String name = scanner.next();
        System.out.println("Enter Customer Email:");
        String email = scanner.next();
        System.out.println("Enter Customer Phone No.:");
        String phone = scanner.next();
        customerService.registerCustomer(name, email, phone);
        System.out.println("Customer registered successfully.");
    }

    // Ticket Operations
    public void bookTicket() {
        System.out.println("Enter Schedule ID:");
        int scheduleId = scanner.nextInt();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        if (schedule == null) {
            System.out.println("Schedule not found!");
            return;
        }
        
        System.out.println("Enter Customer ID:");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.println("Enter Seat Number:");
        int seatNumber = scanner.nextInt();
        ticketService.bookTicket(customer, schedule, seatNumber);
        System.out.println("Ticket booked successfully.");
    }

    public void viewTicket() {
        System.out.println("Enter Ticket ID:");
        int ticketId = scanner.nextInt();
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Ticket Details: " + ticket);
        } else {
            System.out.println("Ticket not found!");
        }
    }

    public void cancelTicket() {
        System.out.println("Enter Ticket ID to cancel:");
        int ticketId = scanner.nextInt();
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found!");
            return;
        }

        ticketService.cancelTicket(ticketId);
        System.out.println("Ticket with ID " + ticketId + " has been successfully canceled.");
    }

    // Payment Operations
    public void makePayment() {
        System.out.println("Enter Ticket ID:");
        int ticketId = scanner.nextInt();
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found!");
            return;
        }

        System.out.println("Enter Payment Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character from the buffer
        System.out.println("Enter Payment Status:");
        String paymentStatus = scanner.nextLine();
        paymentService.processPayment(ticket, amount, paymentStatus);
        System.out.println("Payment successful.");
    }

    public void viewPayment() {
        System.out.println("Enter Payment ID:");
        int paymentId = scanner.nextInt();
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            System.out.println("Payment Details: " + payment);
        } else {
            System.out.println("Payment not found!");
        }
    }
}
