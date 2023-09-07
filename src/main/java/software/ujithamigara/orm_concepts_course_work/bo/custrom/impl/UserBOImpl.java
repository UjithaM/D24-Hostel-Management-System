package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.UserBO;
import software.ujithamigara.orm_concepts_course_work.dao.DAOFactory;
import software.ujithamigara.orm_concepts_course_work.dao.custom.UserDAO;
import software.ujithamigara.orm_concepts_course_work.dto.UserDTO;
import software.ujithamigara.orm_concepts_course_work.entity.User;

import java.io.IOException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDao(DAOFactory.DaoTypes.UserDao);
    @Override
    public boolean saveUser(UserDTO userDTO) throws IOException {
        return userDAO.save(new User(userDTO.getUserId(), userDTO.getName(), userDTO.getPassword()));
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws IOException {
        return userDAO.update(new User(userDTO.getUserId(), userDTO.getName(), userDTO.getPassword()));
    }
}
