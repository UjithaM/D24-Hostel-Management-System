package software.ujithamigara.orm_concepts_course_work.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface CrudDAO<entity> {
    boolean save(entity entity) throws SQLException, IOException;
    boolean delete(String id) throws SQLException, IOException;
    entity search(String id) throws SQLException, IOException ;
    boolean update(entity entity) throws SQLException, IOException ;
}
