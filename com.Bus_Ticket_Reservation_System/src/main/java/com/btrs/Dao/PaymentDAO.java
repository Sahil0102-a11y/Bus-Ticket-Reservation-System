package com.btrs.Dao;

import com.btrs.entity.Payment;

public interface PaymentDAO {
    void save(Payment payment);
    Payment findById(int id);
}

