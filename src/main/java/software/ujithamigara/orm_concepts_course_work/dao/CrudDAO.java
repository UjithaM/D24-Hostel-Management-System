package software.ujithamigara.orm_concepts_course_work.dao;

import software.ujithamigara.orm_concepts_course_work.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<entity> extends SuperDAO{
    boolean save(entity entity) throws SQLException, IOException;
    boolean delete(String id) throws SQLException, IOException;
    entity search(String id) throws SQLException, IOException ;
    boolean update(entity entity) throws SQLException, IOException ;
    public List<entity> getAllRooms() throws SQLException, IOException;
}
