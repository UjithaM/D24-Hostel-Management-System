package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private Room room;
    private Student student;
}
