package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.BusDAO;
import com.btrs.entity.Bus;


public class BusDAOImpl implements BusDAO {
    @Override
    public void save(Bus bus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(bus);
        tx.commit();
        session.close();
    }

    @Override
    public Bus findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bus bus = session.get(Bus.class, id);
        session.close();
        return bus;
    }

    @Override
    public void update(Bus bus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(bus);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Bus bus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(bus);
        tx.commit();
        session.close();
    }
}

