package hospital.dao;

import java.sql.SQLException;

public interface IBaseDAO <T> {
    T getEntityById (long id) throws SQLException;
    void saveEntity (T entity);
    void updateEntity (T entity) throws SQLException;
    void removeEntity (long id);
}
