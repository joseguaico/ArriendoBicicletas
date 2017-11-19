
package com.arriendo.utilidades;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author jose
 */
public class MyHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration configuration = new Configuration();
              configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
                        
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
