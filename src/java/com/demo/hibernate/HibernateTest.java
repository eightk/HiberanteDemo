/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.hibernate;

import com.demo.dto.UserDetails;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author huico
 */
public class HibernateTest {
    
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUseId(5);
        user.setUserName("5th User");
        user.setBirthDate(new Date());
        
        //use Hibernate API to save the model object
        /*Configuration configuration = new Configuration();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
}
