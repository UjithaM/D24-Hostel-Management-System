package software.ujithamigara.orm_concepts_course_work.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnpaidTM {
    private String studentId;
    private String studentName;
    private String roomId;
    private String roomType;
    private Double keyMoney;
}
