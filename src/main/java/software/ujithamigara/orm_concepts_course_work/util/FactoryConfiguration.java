package software.ujithamigara.orm_concepts_course_work.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import software.ujithamigara.orm_concepts_course_work.entity.Reservation;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.entity.Student;
import software.ujithamigara.orm_concepts_course_work.entity.User;

import java.io.IOException;
import java.util.Properties;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;

    private FactoryConfiguration() throws IOException {
        //add configuration file
        Configuration configuration = new Configuration();

        //add properties
        Properties properties = new Properties();

        //add already created hibernate file to properties in current thread
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));

        //add properties to configure
        configuration.setProperties(properties);

        //add annotated class to configure
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Student.class);

        //build session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration==null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}