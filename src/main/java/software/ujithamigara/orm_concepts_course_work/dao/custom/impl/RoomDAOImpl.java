package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import software.ujithamigara.orm_concepts_course_work.dao.custom.RoomDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.util.FactoryConfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            Room room = new Room();
            room.setRoomId(id);
            session.delete(room);
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
    public Room search(String id) throws SQLException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {

            return session.get(Room.class, id);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Room room) throws SQLException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(room);
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
    public List<Room> getAllRooms() throws SQLException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Room> rooms = null;

        try {
            String hql = "FROM Room"; // Assuming "Room" is your entity class name
            Query<Room> query = session.createQuery(hql);
            rooms = query.list();
            transaction.commit();
            return rooms;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
