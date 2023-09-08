package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.ReservationBO;
import software.ujithamigara.orm_concepts_course_work.dao.DAOFactory;
import software.ujithamigara.orm_concepts_course_work.dao.custom.ReservationDAO;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDao(DAOFactory.DaoTypes.ReservationDao);
    @Override
    public boolean saveReservation(ReservationDTO reservationDTO) throws SQLException, IOException {
        return reservationDAO.save(new Reservation(reservationDTO.getReservationId(), reservationDTO.getDate(), reservationDTO.getStatus(), reservationDTO.getRoom(), reservationDTO.getStudent()));
    }

    @Override
    public boolean deleteReservation(String reservationId) throws SQLException, IOException {
        return reservationDAO.delete(reservationId);
    }

    @Override
    public ReservationDTO searchReservation(String reservationId) throws SQLException, IOException {
        Reservation reservation=reservationDAO.search(reservationId);
        return new ReservationDTO(reservation.getReservationId(), reservation.getDate(), reservation.getStatus(), reservation.getStudent(), reservation.getRoom());
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) throws SQLException, IOException {
        return reservationDAO.update(new Reservation(reservationDTO.getReservationId(), reservationDTO.getDate(), reservationDTO.getStatus(), reservationDTO.getRoom(), reservationDTO.getStudent()));
    }

    @Override
    public List<ReservationDTO> getAllReservation() throws SQLException, IOException {
        List<Reservation> reservations = reservationDAO.getAll();
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (Reservation reservation:reservations) {
            reservationDTOS.add(new ReservationDTO(reservation.getReservationId(), reservation.getDate(), reservation.getStatus(),reservation.getStudent(), reservation.getRoom()));
        }
        return reservationDTOS;
    }
}
