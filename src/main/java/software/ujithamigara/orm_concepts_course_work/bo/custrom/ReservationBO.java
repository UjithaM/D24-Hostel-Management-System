package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.bo.SuperBo;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface ReservationBO extends SuperBo {
    boolean saveReservation(ReservationDTO reservationDTO) throws SQLException, IOException;
    boolean deleteReservation(String reservationId) throws SQLException, IOException;
    ReservationDTO searchReservation(String eservationId) throws SQLException, IOException;
    boolean updateReservation(ReservationDTO reservationDTO) throws SQLException, IOException;
}
