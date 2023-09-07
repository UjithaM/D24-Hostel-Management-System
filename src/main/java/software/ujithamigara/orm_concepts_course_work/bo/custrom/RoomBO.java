package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public interface RoomBO {
    boolean saveRoom(RoomDTO roomDTO);
    boolean deleteRoom(RoomDTO roomDTO);
    StudentDTO searchRoom(String roomId);
    boolean updateStudent(RoomDTO roomDTO);
}
