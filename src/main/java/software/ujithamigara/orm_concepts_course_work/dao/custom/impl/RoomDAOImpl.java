package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import software.ujithamigara.orm_concepts_course_work.dao.custom.RoomDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Room;

import java.sql.SQLException;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Room search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Room dto) throws SQLException {
        return false;
    }
}
