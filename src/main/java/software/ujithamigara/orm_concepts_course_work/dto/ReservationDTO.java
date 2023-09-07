package software.ujithamigara.orm_concepts_course_work.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private String reservationId;
    private Date date;
    private String status;
    private Student student;
    private Room room;
}
