package com.btrs.Service;

import com.btrs.entity.Payment;
import com.btrs.entity.Ticket;

public interface PaymentService {
    void processPayment(Ticket ticket, double amount, String paymentStatus);
    Payment getPaymentById(int id);
}

