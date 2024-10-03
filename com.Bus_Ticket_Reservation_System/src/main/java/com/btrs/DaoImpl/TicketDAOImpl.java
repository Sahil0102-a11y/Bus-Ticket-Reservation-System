package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.TicketDAO;
import com.btrs.entity.Ticket;


public class TicketDAOImpl implements TicketDAO {
    @Override
    public void save(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(ticket);
        tx.commit();
        session.close();
    }

    @Override
    public Ticket findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    @Override
    public void update(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(ticket);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ticket);
        tx.commit();
        session.close();
    }
    @Override
    public void cancelTicket(int ticketId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null) {
                // If you have a 'status' field or similar to mark cancellation
                ticket.setStatus("Canceled"); // Assuming you have a status field
                session.update(ticket); // Update the ticket status
                System.out.println("Ticket marked as canceled: " + ticket);
            } else {
                System.out.println("Ticket not found!");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

