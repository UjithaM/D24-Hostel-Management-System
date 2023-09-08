package software.ujithamigara.orm_concepts_course_work.bo.custrom;

import software.ujithamigara.orm_concepts_course_work.bo.SuperBo;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RoomBO extends SuperBo {
    boolean saveRoom(RoomDTO roomDTO) throws SQLException, IOException;
    boolean deleteRoom(RoomDTO roomDTO) throws SQLException, IOException;
    RoomDTO searchRoom(String roomId) throws SQLException, IOException;
    boolean updateRoom(RoomDTO roomDTO) throws SQLException, IOException;
    List<RoomDTO> getAllRoom() throws SQLException, IOException;
}
