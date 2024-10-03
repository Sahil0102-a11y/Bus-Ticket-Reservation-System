package com.btrs.Dao;

import com.btrs.entity.Admin;

public interface AdminDAO {
    void save(Admin admin);           // Save a new admin to the database
    Admin findById(int id);          // Find an admin by their ID
    Admin findByUsername(String username); // Find an admin by their username
    void update(Admin admin);         // Update an existing admin's details
    void delete(Admin admin);         // Delete an admin from the database
}
