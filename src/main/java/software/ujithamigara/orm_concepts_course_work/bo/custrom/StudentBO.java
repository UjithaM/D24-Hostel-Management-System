package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.bo.SuperBo;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface StudentBO extends SuperBo {
    boolean saveStudent(StudentDTO studentDTO) throws SQLException, IOException;
    boolean deleteStudent(String studentId) throws SQLException, IOException;
    StudentDTO searchStudent(String studentId) throws SQLException, IOException;
    boolean updateStudent(StudentDTO studentDTO) throws SQLException, IOException;
}
