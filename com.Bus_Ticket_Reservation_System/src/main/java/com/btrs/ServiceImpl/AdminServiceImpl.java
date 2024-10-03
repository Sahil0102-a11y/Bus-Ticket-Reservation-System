package com.btrs.ServiceImpl;

import java.time.LocalDateTime;
import com.btrs.DaoImpl.*;
import com.btrs.Service.*;
import com.btrs.entity.*;

public class AdminServiceImpl implements AdminService {

    private BusDAOImpl busDAO = new BusDAOImpl();
    private RouteDAOImpl routeDAO = new RouteDAOImpl();
    private ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
    private AdminDAOImpl adminDAO = new AdminDAOImpl(); // New DAO for Admin

    @Override
    public void addBus(int busNumber, int seats) {
        Bus bus = new Bus(busNumber, seats);
        busDAO.save(bus);
        System.out.println("Bus added successfully: " + bus);
    }

    @Override
    public void addRoute(String source, String destination) {
        Route route = new Route(source, destination);
        routeDAO.save(route);
        System.out.println("Route added successfully: " + route);
    }

    @Override
    public void addSchedule(int busId, int routeId, LocalDateTime departureTime) {
        Bus bus = busDAO.findById(busId);
        Route route = routeDAO.findById(routeId);
        
        if (bus != null && route != null) {
            Schedule schedule = new Schedule(bus, route, departureTime);
            scheduleDAO.save(schedule);
            System.out.println("Schedule added successfully: " + schedule);
        } else {
            System.out.println("Bus or Route not found!");
        }
    }

    // Admin Management Methods
    @Override
    public void addAdmin(Admin admin) {
        adminDAO.save(admin);
        System.out.println("Admin added successfully: " + admin);
    }

    @Override
    public Admin getAdminById(int id) {
        Admin admin = adminDAO.findById(id);
        if (admin != null) {
            System.out.println("Admin found: " + admin);
        } else {
            System.out.println("Admin not found!");
        }
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDAO.update(admin);
        System.out.println("Admin updated successfully: " + admin);
    }

    @Override
    public void deleteAdmin(int id) {
        Admin admin = adminDAO.findById(id);
        if (admin != null) {
            adminDAO.delete(admin);
            System.out.println("Admin deleted successfully: " + admin);
        } else {
            System.out.println("Admin not found!");
        }
    }
}
