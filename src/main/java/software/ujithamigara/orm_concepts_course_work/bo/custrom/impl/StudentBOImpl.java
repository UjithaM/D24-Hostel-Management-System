package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dao.DAOFactory;
import software.ujithamigara.orm_concepts_course_work.dao.custom.StudentDAO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.io.IOException;
import java.sql.SQLException;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDao(DAOFactory.DaoTypes.StudentsDao);
    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws SQLException, IOException {
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setStudentName(studentDTO.getStudentName());
        student.setAddress(studentDTO.getAddress());
        student.setContactNumber(studentDTO.getContactNumber());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        return studentDAO.save(student);
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException, IOException {
        return studentDAO.delete(studentId);
    }

    @Override
    public StudentDTO searchStudent(String studentId) throws SQLException, IOException {
        Student student = studentDAO.search(studentId);
        return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAddress(), student.getContactNumber(), student.getDob(), student.getGender());
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws SQLException, IOException {
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setStudentName(studentDTO.getStudentName());
        student.setAddress(studentDTO.getAddress());
        student.setContactNumber(studentDTO.getContactNumber());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        return studentDAO.update(student);
    }
}
