package com.btrs.Service;

import com.btrs.entity.Customer;
import com.btrs.entity.Schedule;
import com.btrs.entity.Ticket;

public interface TicketService {
    void bookTicket(Customer customer, Schedule schedule, int seatNumber);
    Ticket getTicketById(int id);
    void cancelTicket(int ticketId);
}

