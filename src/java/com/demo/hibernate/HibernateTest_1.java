/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.hibernate;

import com.demo.dto.Factory;
import com.demo.dto.Product;
import com.demo.dto.ProductDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author huico
 */
public class HibernateTest_1 {
    
    public static void main(String[] args) {
        Product product = new Product();
        Product product2 = new Product();
        Factory factory = new Factory();
        ProductDetail productDetail = new ProductDetail();
        ProductDetail productDetail2 = new ProductDetail();
        
        product.setName("P1");
        product2.setName("P2");
        factory.setFactoryAddress("some place");
        
        productDetail.setProduct(product);
        productDetail.setFactory(factory);
        productDetail2.setProduct(product2);
        productDetail2.setFactory(factory);
        
        factory.getProductDetails().add(productDetail);
        factory.getProductDetails().add(productDetail2);
        
        
        //since we have mapping between the objects, we only need to save the child objects and the parent objects will be automatically saved.
        //use Hibernate API to save the model object
        /*Configuration configuration = new Configuration();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(factory);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
}
