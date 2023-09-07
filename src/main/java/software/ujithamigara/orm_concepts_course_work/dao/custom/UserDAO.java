package software.ujithamigara.orm_concepts_course_work.dao.custom;

import software.ujithamigara.orm_concepts_course_work.entity.User;

public interface UserDAO {
    boolean save(User user);
    boolean update(User user);
}
