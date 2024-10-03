package com.btrs.Dao;

import com.btrs.entity.Ticket;

public interface TicketDAO {
    void save(Ticket ticket);
    Ticket findById(int id);
    void update(Ticket ticket);
    void delete(Ticket ticket);
    void cancelTicket(int ticketId);
}

