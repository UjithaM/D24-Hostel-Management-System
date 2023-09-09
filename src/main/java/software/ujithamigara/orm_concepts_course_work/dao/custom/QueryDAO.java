package software.ujithamigara.orm_concepts_course_work.dao.custom;


import software.ujithamigara.orm_concepts_course_work.dao.SuperDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Reservation;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.io.IOException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Reservation> findAllUnpaidReservations() throws IOException;
}
