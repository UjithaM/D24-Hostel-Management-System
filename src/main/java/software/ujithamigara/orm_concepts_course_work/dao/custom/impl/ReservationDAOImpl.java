package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import software.ujithamigara.orm_concepts_course_work.dao.custom.ReservationDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation reservation) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, IOException {
        return false;
    }

    @Override
    public Reservation search(String id) throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException, IOException {
        return false;
    }

    @Override
    public List<Reservation> getAll() throws SQLException, IOException {
        return null;
    }
}
