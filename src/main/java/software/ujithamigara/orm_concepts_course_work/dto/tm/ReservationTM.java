package software.ujithamigara.orm_concepts_course_work.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTM {
    private String reservationId;
    private String studentName;
    private String roomType;
    private String paidStatus;
    private LocalDate date;
}
