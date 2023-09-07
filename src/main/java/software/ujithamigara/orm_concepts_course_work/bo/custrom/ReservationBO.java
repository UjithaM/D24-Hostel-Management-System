package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public interface ReservationBO {
    boolean saveReservation(ReservationDTO reservationDTO);
    boolean deleteReservation(ReservationDTO reservationDTO);
    StudentDTO searchReservation(String ReservationId);
    boolean updateReservation(ReservationDTO reservationDTO);
}
