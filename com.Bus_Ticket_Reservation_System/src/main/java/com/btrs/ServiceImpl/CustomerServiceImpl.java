package com.btrs.ServiceImpl;

import com.btrs.DaoImpl.CustomerDAOImpl;
import com.btrs.Service.CustomerService;
import com.btrs.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Override
    public void registerCustomer(String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        customerDAO.save(customer);
        System.out.println("Customer registered successfully: " + customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
        System.out.println("Customer updated successfully: " + customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerDAO.findById(id);
        if (customer != null) {
            customerDAO.delete(customer);
            System.out.println("Customer deleted successfully: " + customer);
        } else {
            System.out.println("Customer not found!");
        }
    }
}

