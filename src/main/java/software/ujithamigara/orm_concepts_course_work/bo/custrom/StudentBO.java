package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public interface StudentBO {
    boolean saveStudent(StudentDTO studentDTO);
    boolean deleteStudent(String studentId);
    StudentDTO searchStudent(String studentId);
    boolean updateStudent(StudentDTO studentDTO);
}
