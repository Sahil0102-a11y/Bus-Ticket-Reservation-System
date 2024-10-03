package com.btrs.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.btrs.HibernateUtil;
import com.btrs.Dao.ScheduleDAO;
import com.btrs.entity.Schedule;


public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public void save(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(schedule);
        tx.commit();
        session.close();
    }

    @Override
    public Schedule findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Schedule schedule = session.get(Schedule.class, id);
        session.close();
        return schedule;
    }

    @Override
    public void update(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(schedule);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(schedule);
        tx.commit();
        session.close();
    }
}
