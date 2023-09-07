package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.dto.UserDTO;

import java.io.IOException;

public interface UserBO {
    boolean saveUser(UserDTO userDTO) throws IOException;
    boolean updateUser(UserDTO userDTO) throws IOException;
}
