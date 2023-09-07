package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public class StudentBOImpl implements StudentBO {
    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public boolean deleteStudent(String studentId) {
        return false;
    }

    @Override
    public StudentDTO searchStudent(String studentId) {
        return null;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        return false;
    }
}
