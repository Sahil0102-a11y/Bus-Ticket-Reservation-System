package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.CustomerDAO;
import com.btrs.entity.Customer;


public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        session.close();
    }

    @Override
    public Customer findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(customer);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(customer);
        tx.commit();
        session.close();
    }
}
