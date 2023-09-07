package software.ujithamigara.orm_concepts_course_work.dao.custom;

import software.ujithamigara.orm_concepts_course_work.entity.User;

import java.io.IOException;

public interface UserDAO {
    boolean save(User user) throws IOException;
    boolean update(User user) throws IOException;
}
