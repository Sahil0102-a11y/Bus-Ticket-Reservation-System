package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.RouteDAO;
import com.btrs.entity.Route;


public class RouteDAOImpl implements RouteDAO {
    @Override
    public void save(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(route);
        tx.commit();
        session.close();
    }

    @Override
    public Route findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Route route = session.get(Route.class, id);
        session.close();
        return route;
    }

    @Override
    public void update(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(route);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(route);
        tx.commit();
        session.close();
    }
}

