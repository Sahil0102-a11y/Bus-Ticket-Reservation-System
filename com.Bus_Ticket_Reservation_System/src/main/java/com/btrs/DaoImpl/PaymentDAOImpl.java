package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.PaymentDAO;
import com.btrs.entity.Payment;


public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public void save(Payment payment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(payment);
        tx.commit();
        session.close();
    }

    @Override
    public Payment findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Payment payment = session.get(Payment.class, id);
        session.close();
        return payment;
    }
}

