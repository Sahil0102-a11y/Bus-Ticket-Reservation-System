package com.btrs.entity;

import javax.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "schedules")
public class Schedule extends BaseEntity {
	@ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    public Schedule() {}

    public Schedule(Bus bus, Route route, LocalDateTime departureTime) {
        this.bus = bus;
        this.route = route;
        this.departureTime = departureTime;
    }

    // Getters and Setters
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Schedule [Bus=" + bus.getBusNumber() + ", Route=" + route.getSource() + " to " + route.getDestination() + ", DepartureTime=" + departureTime + "]";
    }
}
