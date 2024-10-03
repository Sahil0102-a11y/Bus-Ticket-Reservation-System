package com.btrs.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private double amount;
    private String paymentStatus;

    public Payment() {}

    public Payment(Ticket ticket, double amount, String paymentStatus) {
        this.ticket = ticket;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return super.toString() + " Payment [Ticket=" + ticket + ", Amount=" + amount + ", PaymentStatus=" + paymentStatus + "]";
    }
}
