package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import software.ujithamigara.orm_concepts_course_work.dao.custom.RoomDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.util.FactoryConfiguration;

import java.io.IOException;
import java.sql.SQLException;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) throws SQLException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(room);
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
    public boolean delete(String id) throws SQLException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            int deletedRows = session.createNativeQuery("DELETE FROM Room WHERE roomId = ?")
                    .setParameter(1, id)
                    .executeUpdate();
            transaction.commit();

            return deletedRows > 0; // Return true if rows were deleted, false otherwise
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false; // Return false to indicate delete failure
        } finally {
            session.close();
        }
    }

    @Override
    public Room search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Room room) throws SQLException {
        return false;
    }
}
