package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import software.ujithamigara.orm_concepts_course_work.dao.custom.UserDAO;
import software.ujithamigara.orm_concepts_course_work.entity.User;
import software.ujithamigara.orm_concepts_course_work.util.FactoryConfiguration;

import java.io.IOException;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
