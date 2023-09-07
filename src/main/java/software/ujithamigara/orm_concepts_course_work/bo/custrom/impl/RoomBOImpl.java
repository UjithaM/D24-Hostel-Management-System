package software.ujithamigara.orm_concepts_course_work.bo.custrom.impl;

import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.dao.DAOFactory;
import software.ujithamigara.orm_concepts_course_work.dao.custom.RoomDAO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;
import software.ujithamigara.orm_concepts_course_work.entity.Room;

import java.io.IOException;
import java.sql.SQLException;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDao(DAOFactory.DaoTypes.RoomDao);
    @Override
    public boolean saveRoom(RoomDTO roomDTO) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomId(roomDTO.getRoomId());
        room.setRoomTypeId(roomDTO.getRoomTypeId());
        room.setKeyMoney(roomDTO.getKeyMoney());
        room.setQuantity(roomDTO.getQuantity());
        return roomDAO.save(room);
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) throws SQLException, IOException {
        return roomDAO.delete(roomDTO.getRoomId());
    }

    @Override
    public RoomDTO searchRoom(String roomId) throws SQLException, IOException {
        Room room = roomDAO.search(roomId);
        return new RoomDTO(room.getRoomId(), room.getRoomTypeId(), room.getKeyMoney(), room.getQuantity());
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomId(roomDTO.getRoomId());
        room.setRoomTypeId(roomDTO.getRoomTypeId());
        room.setKeyMoney(roomDTO.getKeyMoney());
        room.setQuantity(roomDTO.getQuantity());
        return roomDAO.update(room);
    }
}
