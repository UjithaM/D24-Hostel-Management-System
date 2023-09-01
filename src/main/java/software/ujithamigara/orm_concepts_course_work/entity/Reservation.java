package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Table(name = "Reservation")
@Entity
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    private String reservationId;
    @Column(name = "date")
    private Date date;
    @Column(name = "status")
    private String status;

    public Reservation() {
    }

    public Reservation(String reservationId, Date date, String status) {
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
