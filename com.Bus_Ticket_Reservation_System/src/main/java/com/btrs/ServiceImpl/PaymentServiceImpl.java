package com.btrs.ServiceImpl;

import com.btrs.DaoImpl.PaymentDAOImpl;
import com.btrs.Service.PaymentService;
import com.btrs.entity.Payment;
import com.btrs.entity.Ticket;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

    @Override
    public void processPayment(Ticket ticket, double amount, String paymentStatus) {
        Payment payment = new Payment(ticket, amount, paymentStatus);
        paymentDAO.save(payment);
        System.out.println("Payment processed successfully: " + payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentDAO.findById(id);
    }
}
