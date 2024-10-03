package com.btrs.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	private String Status;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private int seatNumber;

    public Ticket() {}

    public Ticket(Customer customer, Schedule schedule, int seatNumber) {
        this.customer = customer;
        this.schedule = schedule;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Ticket [Customer=" + customer.getName() + ", Schedule=" + schedule + ", SeatNumber=" + seatNumber + "]";
    }
}
