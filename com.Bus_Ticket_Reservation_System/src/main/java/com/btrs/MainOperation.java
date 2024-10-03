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

public class MainOperation {
    private static Scanner scanner = new Scanner(System.in);
    private static BusServiceImpl busService = new BusServiceImpl();
    private static RouteServiceImpl routeService = new RouteServiceImpl();
    private static ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static TicketServiceImpl ticketService = new TicketServiceImpl();
    private static PaymentServiceImpl paymentService = new PaymentServiceImpl();
    private static AdminServiceImpl adminService = new AdminServiceImpl();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Bus Ticket Reservation System -----");
            System.out.println("1. Manage Admins");
            System.out.println("2. Manage Buses");
            System.out.println("3. Manage Routes");
            System.out.println("4. Manage Schedules");
            System.out.println("5. Manage Customers");
            System.out.println("6. Manage Tickets");
            System.out.println("7. Manage Payments");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    manageAdmins();
                    break;
                case 2:
                    manageBuses();
                    break;
                case 3:
                    manageRoutes();
                    break;
                case 4:
                    manageSchedules();
                    break;
                case 5:
                    manageCustomers();
                    break;
                case 6:
                    manageTickets();
                    break;
                case 7:
                    managePayments();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageAdmins() {
        while (true) {
            System.out.println("\n----- Manage Admins -----");
            System.out.println("1. Add Admin");
            System.out.println("2. View Admin");
            System.out.println("3. Update Admin");
            System.out.println("4. Delete Admin");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    viewAdmin();
                    break;
                case 3:
                    updateAdmin();
                    break;
                case 4:
                    deleteAdmin();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageBuses() {
        while (true) {
            System.out.println("\n----- Manage Buses -----");
            System.out.println("1. Add Bus");
            System.out.println("2. Update Bus");
            System.out.println("3. Delete Bus");
            System.out.println("4. View Bus by ID");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    updateBus();
                    break;
                case 3:
                    deleteBus();
                    break;
                case 4:
                    viewBus();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageRoutes() {
        while (true) {
            System.out.println("\n----- Manage Routes -----");
            System.out.println("1. Add Route");
            System.out.println("2. Update Route");
            System.out.println("3. Delete Route");
            System.out.println("4. View Route by ID");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    createRoute();
                    break;
                case 2:
                    updateRoute();
                    break;
                case 3:
                    deleteRoute();
                    break;
                case 4:
                    viewRoute();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageSchedules() {
        while (true) {
            System.out.println("\n----- Manage Schedules -----");
            System.out.println("1. Add Schedule");
            System.out.println("2. Update Schedule");
            System.out.println("3. Delete Schedule");
            System.out.println("4. View Schedule by ID");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    createSchedule();
                    break;
                case 2:
                    updateSchedule();
                    break;
                case 3:
                    deleteSchedule();
                    break;
                case 4:
                    viewSchedule();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageCustomers() {
        while (true) {
            System.out.println("\n----- Manage Customers -----");
            System.out.println("1. Register Customer");
            System.out.println("2. View Customer");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    viewCustomer();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageTickets() {
        while (true) {
            System.out.println("\n----- Manage Tickets -----");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void managePayments() {
        while (true) {
            System.out.println("\n----- Manage Payments -----");
            System.out.println("1. Make Payment");
            System.out.println("2. View Payment");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    makePayment();
                    break;
                case 2:
                    viewPayment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void makePayment() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Payment Status (e.g., Completed, Pending): ");
        String paymentStatus = scanner.nextLine();

        // Assuming you have a method in your service to find the ticket by ID
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            Payment payment = new Payment(ticket, amount, paymentStatus);
            paymentService.processPayment(ticket, amount, paymentStatus); // Ensure this method is defined in your service
            System.out.println("Payment made successfully.");
        } else {
            System.out.println("Ticket not found. Please check the Ticket ID.");
        }
    }

    private static void viewPayment() {
        System.out.print("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Payment payment = paymentService.getPaymentById(paymentId); // Ensure this method is defined in your service
        if (payment != null) {
            System.out.println("Payment ID: " + payment.getId());
            System.out.println("Ticket ID: " + payment.getTicket().getId()); // Accessing Ticket ID from Payment
            System.out.println("Amount: ₹" + payment.getAmount());
            System.out.println("Payment Status: " + payment.getPaymentStatus());
        } else {
            System.out.println("Payment not found.");
        }
    }

    // Admin management methods
    private static void addAdmin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        Admin admin = new Admin(username, password);
        adminService.addAdmin(admin);
        System.out.println("Admin added successfully.");
    }

    private static void viewAdmin() {
        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Admin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            System.out.println("Admin ID: " + admin.getId());
            System.out.println("Username: " + admin.getUsername());
        } else {
            System.out.println("Admin not found.");
        }
    }

    private static void updateAdmin() {
        System.out.print("Enter Admin ID to update: ");
        int adminId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Admin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            System.out.print("Enter new Username (leave blank for no change): ");
            String username = scanner.nextLine();
            if (!username.isEmpty()) {
                admin.setUserName(username);
            }
            System.out.print("Enter new Password (leave blank for no change): ");
            String password = scanner.nextLine();
            if (!password.isEmpty()) {
                admin.setPassword(password);
            }
            adminService.updateAdmin(admin);
            System.out.println("Admin updated successfully.");
        } else {
            System.out.println("Admin not found.");
        }
    }

    private static void deleteAdmin() {
        System.out.print("Enter Admin ID to delete: ");
        int adminId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        adminService.deleteAdmin(adminId);
        System.out.println("Admin deleted successfully.");
    }

    // Bus management methods
    private static void addBus() {
        System.out.print("Enter Bus Number: ");
        int busNumber = scanner.nextInt();
        System.out.print("Enter Bus Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Bus bus = new Bus(busNumber, capacity);
        busService.createBus(busNumber, capacity);
        System.out.println("Bus added successfully.");
    }

    private static void updateBus() {
        System.out.print("Enter Bus ID to update: ");
        int busId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Bus bus = busService.getBusById(busId);
        if (bus != null) {
            System.out.print("Enter new Bus Number (leave blank for no change): ");
            int busNumber = scanner.nextInt();
            if (busNumber > 0) {
                bus.setBusNumber(busNumber);
            }
            System.out.print("Enter new Capacity (leave blank for no change): ");
            String capacityStr = scanner.nextLine();
            if (!capacityStr.isEmpty()) {
                int capacity = Integer.parseInt(capacityStr);
                bus.setSeats(capacity);
            }
            busService.updateBus(bus);
            System.out.println("Bus updated successfully.");
        } else {
            System.out.println("Bus not found.");
        }
    }

    private static void deleteBus() {
        System.out.print("Enter Bus ID to delete: ");
        int busId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        busService.deleteBus(busId);
        System.out.println("Bus deleted successfully.");
    }

    private static void viewBus() {
        System.out.print("Enter Bus ID: ");
        int busId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Bus bus = busService.getBusById(busId);
        if (bus != null) {
            System.out.println("Bus ID: " + bus.getId());
            System.out.println("Bus Number: " + bus.getBusNumber());
            System.out.println("Capacity: " + bus.getSeats());
        } else {
            System.out.println("Bus not found.");
        }
    }

    // Route management methods
    private static void createRoute() {
        //System.out.print("Enter Route Name: ");
        //String routeName = scanner.nextLine();
        System.out.print("Enter Starting Point: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        Route route = new Route(source , destination);
        routeService.createRoute(source , destination);
        System.out.println("Route created successfully.");
    }

    private static void updateRoute() {
        System.out.print("Enter Route ID to update: ");
        int routeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Route route = routeService.getRouteById(routeId);
        if (route != null) {
//            System.out.print("Enter new Route Name (leave blank for no change): ");
//            String routeName = scanner.nextLine();
//            if (!routeName.isEmpty()) {
//                route.setSource(routeName);
//            }
            System.out.print("Enter new Starting Point (leave blank for no change): ");
            String source = scanner.nextLine();
            if (!source.isEmpty()) {
                route.setSource(source);
            }
            System.out.print("Enter new Destination (leave blank for no change): ");
            String destination = scanner.nextLine();
            if (!destination.isEmpty()) {
                route.setDestination(destination);
            }
            routeService.updateRoute(route);
            System.out.println("Route updated successfully.");
        } else {
            System.out.println("Route not found.");
        }
    }

    private static void deleteRoute() {
        System.out.print("Enter Route ID to delete: ");
        int routeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        routeService.deleteRoute(routeId);
        System.out.println("Route deleted successfully.");
    }

    private static void viewRoute() {
        System.out.print("Enter Route ID: ");
        int routeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Route route = routeService.getRouteById(routeId);
        if (route != null) {
            System.out.println("Route ID: " + route.getId());
            //System.out.println("Route Name: " + route.getRouteName());
            System.out.println("Starting Point: " + route.getSource());
            System.out.println("Destination: " + route.getDestination());
        } else {
            System.out.println("Route not found.");
        }
    }

    // Schedule management methods
    private static void createSchedule() {
        System.out.print("Enter Schedule Date and Time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        System.out.print("Enter Bus ID: ");
        int busId = scanner.nextInt();
        Bus bus = busService.getBusById(busId);
        System.out.print("Enter Route ID: ");
        int routeId = scanner.nextInt();
        Route route = routeService.getRouteById(routeId);
        Schedule schedule = new Schedule(bus, route, dateTime);
        scheduleService.createSchedule(busId, routeId, dateTime);
        System.out.println("Schedule created successfully.");
    }

    private static void updateSchedule() {
        System.out.print("Enter Schedule ID to update: ");
        int scheduleId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        if (schedule != null) {
            System.out.print("Enter new Date and Time (leave blank for no change): ");
            String dateTimeStr = scanner.nextLine();
            if (!dateTimeStr.isEmpty()) {
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
                schedule.setDepartureTime(dateTime);
            }
            System.out.print("Enter new Bus ID (leave blank for no change): ");
            int busId = scanner.nextInt();
            Bus bus = busService.getBusById(busId);
            if (busId > 0) {   
                schedule.setBus(bus);
            }
            System.out.print("Enter new Route ID (leave blank for no change): ");
            int routeId = scanner.nextInt();
            Route route = routeService.getRouteById(routeId);
            if (routeId > 0) {
                schedule.setRoute(route);
            }
            scheduleService.updateSchedule(schedule);
            System.out.println("Schedule updated successfully.");
        } else {
            System.out.println("Schedule not found.");
        }
    }

    private static void deleteSchedule() {
        System.out.print("Enter Schedule ID to delete: ");
        int scheduleId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        scheduleService.deleteSchedule(scheduleId);
        System.out.println("Schedule deleted successfully.");
    }

    private static void viewSchedule() {
        System.out.print("Enter Schedule ID: ");
        int scheduleId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        if (schedule != null) {
            System.out.println("Schedule ID: " + schedule.getId());
            System.out.println("Date and Time: " + schedule.getDepartureTime().format(formatter));
            System.out.println("Bus ID: " + schedule.getBus());
            System.out.println("Route ID: " + schedule.getRoute());
        } else {
            System.out.println("Schedule not found.");
        }
    }

    // Customer management methods
    private static void registerCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Customer Phone No.: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, email, phone);
        customerService.registerCustomer(name, email, phone);
        System.out.println("Customer registered successfully.");
    }

    private static void viewCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            System.out.print("Enter new Name (leave blank for no change): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                customer.setName(name);
            }
            System.out.print("Enter new Email (leave blank for no change): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                customer.setEmail(email);
            }
            customerService.updateCustomer(customer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        customerService.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    }

    // Ticket management methods
    private static void bookTicket() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomerById(customerId);
        System.out.print("Enter Schedule ID: ");
        int scheduleId = scanner.nextInt();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        System.out.print("Enter Seat No.: ");
        int seatNumber = scanner.nextInt();
        Ticket ticket = new Ticket(customer, schedule, seatNumber);
        ticketService.bookTicket(customer, schedule, seatNumber);
        System.out.println("Ticket booked successfully.");
    }

    private static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int ticketId = scanner.nextInt();
        ticketService.cancelTicket(ticketId);
        System.out.println("Ticket cancelled successfully.");
    }

    private static void viewTicket() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Ticket ID: " + ticket.getId());
            System.out.println("Customer ID: " + ticket.getCustomer());
            System.out.println("Schedule ID: " + ticket.getSchedule());
        } else {
            System.out.println("Ticket not found.");
        }
    }
}
