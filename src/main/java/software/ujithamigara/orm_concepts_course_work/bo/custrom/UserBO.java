package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.dto.UserDTO;

public interface UserBO {
    boolean saveUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
}
