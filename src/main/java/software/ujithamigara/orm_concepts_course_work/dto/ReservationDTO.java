package software.ujithamigara.orm_concepts_course_work.dto;


import java.util.Date;

public class ReservationDTO {
    private String reservationId;
    private Date date;
    private String status;

    public ReservationDTO(String reservationId, Date date, String status) {
        this.reservationId = reservationId;
        this.date = date;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
