package software.ujithamigara.orm_concepts_course_work.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {

        private String studentId;

        private String studentName;

        private String address;

        private String contactNumber;

        private LocalDate dob;

        private String gender;


}
