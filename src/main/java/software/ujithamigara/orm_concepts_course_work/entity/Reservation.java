package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate date;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Room room;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
}
