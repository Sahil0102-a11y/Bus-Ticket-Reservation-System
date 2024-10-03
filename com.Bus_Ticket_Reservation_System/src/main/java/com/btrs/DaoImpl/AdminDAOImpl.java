package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.btrs.HibernateUtil;
import com.btrs.Dao.AdminDAO;
import com.btrs.entity.Admin;

public class AdminDAOImpl implements AdminDAO {
    
    @Override
    public void save(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(admin);
        tx.commit();
        session.close();
    }

    @Override
    public Admin findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Admin admin = session.get(Admin.class, id);
        session.close();
        return admin;
    }

    @Override
    public Admin findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Admin> query = session.createQuery("FROM Admin WHERE username = :username", Admin.class);
        query.setParameter("username", username);
        Admin admin = query.uniqueResult();
        session.close();
        return admin;
    }

    @Override
    public void update(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(admin);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(admin);
        tx.commit();
        session.close();
    }
}
