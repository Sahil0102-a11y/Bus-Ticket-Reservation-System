package com.btrs.ServiceImpl;

import com.btrs.DaoImpl.TicketDAOImpl;
import com.btrs.Service.TicketService;
import com.btrs.entity.Customer;
import com.btrs.entity.Schedule;
import com.btrs.entity.Ticket;

public class TicketServiceImpl implements TicketService {

    private TicketDAOImpl ticketDAO = new TicketDAOImpl();

    @Override
    public void bookTicket(Customer customer, Schedule schedule, int seatNumber) {
        Ticket ticket = new Ticket(customer, schedule, seatNumber);
        ticketDAO.save(ticket);
        System.out.println("Ticket booked successfully: " + ticket);
    }

    @Override
    public Ticket getTicketById(int id) {
        return ticketDAO.findById(id);
        
        
    }
    @Override
    public void cancelTicket(int ticketId) {
        ticketDAO.cancelTicket(ticketId);
}
}

