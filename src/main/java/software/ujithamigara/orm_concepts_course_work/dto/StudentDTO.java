package software.ujithamigara.orm_concepts_course_work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String studentId;

    private String studentName;

    private String address;

    private String contactNumber;

    private Date dob;

    private String gender;
}
