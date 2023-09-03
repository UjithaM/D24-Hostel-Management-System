package software.ujithamigara.orm_concepts_course_work.dao;

import java.sql.SQLException;

public interface CrudDAO<entity> {
    boolean save(entity entity) throws SQLException;
    boolean delete(String id) throws SQLException;
    entity search(String id) throws SQLException ;
    boolean update(entity dto) throws SQLException ;
}
