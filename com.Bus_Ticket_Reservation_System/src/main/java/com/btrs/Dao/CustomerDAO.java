package com.btrs.Dao;

import com.btrs.entity.Customer;

public interface CustomerDAO {
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void delete(Customer customer);
}

