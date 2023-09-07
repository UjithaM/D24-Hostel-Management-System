package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.ReservationBO;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public class ReservationBOImpl implements ReservationBO {
    @Override
    public boolean saveReservation(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean deleteReservation(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public StudentDTO searchReservation(String ReservationId) {
        return null;
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {
        return false;
    }
}
