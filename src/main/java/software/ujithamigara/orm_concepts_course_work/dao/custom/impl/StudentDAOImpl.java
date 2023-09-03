package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import software.ujithamigara.orm_concepts_course_work.dao.custom.StudentDAO;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Student search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Student dto) throws SQLException {
        return false;
    }
}
