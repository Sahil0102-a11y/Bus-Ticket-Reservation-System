package com.btrs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.btrs.entity.*;
public class HibernateUtil {
private static final SessionFactory sessionFactory = buildSessionFactory();
private static SessionFactory buildSessionFactory() {
try {
return new
Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Admin.class).addAnnotatedClass(BaseEntity.class).addAnnotatedClass(Bus.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Payment.class).addAnnotatedClass(Route.class).addAnnotatedClass(Schedule.class).addAnnotatedClass(Ticket.class)
.buildSessionFactory();
} catch (Throwable ex) {
throw new ExceptionInInitializerError(ex);
}
}
public static SessionFactory getSessionFactory() {
return sessionFactory;
}
}
