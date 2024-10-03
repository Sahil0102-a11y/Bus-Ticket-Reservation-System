package com.btrs.Service;

import java.time.LocalDateTime;
import com.btrs.entity.Admin;

public interface AdminService {
    
    // Methods for bus management
    void addBus(int busNumber, int seats);
    
    // Methods for route management
    void addRoute(String source, String destination);
    
    // Methods for schedule management
    void addSchedule(int busId, int routeId, LocalDateTime departureTime);
    
    // Methods for admin management
    void addAdmin(Admin admin); // Add an admin
    Admin getAdminById(int id); // Retrieve admin by ID
    void updateAdmin(Admin admin); // Update admin details
    void deleteAdmin(int id); // Delete admin by ID
}
