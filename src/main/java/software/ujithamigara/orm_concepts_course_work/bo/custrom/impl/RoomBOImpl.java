package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

public class RoomBOImpl implements RoomBO {
    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public StudentDTO searchRoom(String roomId) {
        return null;
    }

    @Override
    public boolean updateStudent(RoomDTO roomDTO) {
        return false;
    }
}
