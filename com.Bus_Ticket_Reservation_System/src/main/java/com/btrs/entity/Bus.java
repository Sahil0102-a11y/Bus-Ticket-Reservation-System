package com.btrs.entity;

import javax.persistence.*;

@Entity
@Table(name = "buses")
public class Bus extends BaseEntity {
    private int busNumber;
    private int seats;

    public Bus() {}

    public Bus(int busNumber, int seats) {
        this.busNumber = busNumber;
        this.seats = seats;
    }

    // Getters and Setters
    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + " Bus [BusNumber=" + busNumber + ", Seats=" + seats + "]";
    }

}
