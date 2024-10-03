package com.btrs.Service;

import com.btrs.entity.Customer;

public interface CustomerService {
    void registerCustomer(String name, String email, String phone);
    Customer getCustomerById(int id);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}

