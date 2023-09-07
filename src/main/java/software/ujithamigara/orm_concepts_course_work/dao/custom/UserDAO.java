package software.ujithamigara.orm_concepts_course_work.dao.custom;

import software.ujithamigara.orm_concepts_course_work.dao.SuperDAO;
import software.ujithamigara.orm_concepts_course_work.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDAO extends SuperDAO {
    boolean save(User user) throws IOException;
    boolean update(User user) throws IOException;
    public User search(String Name) throws IOException;
}
