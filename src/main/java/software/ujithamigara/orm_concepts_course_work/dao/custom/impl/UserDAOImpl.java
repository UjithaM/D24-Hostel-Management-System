package software.ujithamigara.orm_concepts_course_work.dao.custom.impl;

import software.ujithamigara.orm_concepts_course_work.dao.custom.UserDAO;
import software.ujithamigara.orm_concepts_course_work.entity.User;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
