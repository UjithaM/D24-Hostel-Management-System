package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import software.ujithamigara.orm_concepts_course_work.dao.custom.QueryDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Reservation;
import software.ujithamigara.orm_concepts_course_work.entity.Student;
import software.ujithamigara.orm_concepts_course_work.util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Reservation> findAllUnpaidReservations() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Reservation> reservations = null;

        try {
            String hql = "FROM Reservation r WHERE r.status = 'Not Paid'";
            Query<Reservation> query = session.createQuery(hql, Reservation.class);

            reservations = query.list();
            transaction.commit();
            return reservations;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
