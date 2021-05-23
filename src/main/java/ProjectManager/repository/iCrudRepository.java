package ProjectManager.repository;

import java.sql.SQLException;
import java.util.List;

public interface iCrudRepository<T>{

    //void create(T t) throws SQLException;
   // T read(int id) throws SQLException;
    List<T> readAll() throws SQLException;
    void update (T t) throws SQLException;
    void delete (int id) throws SQLException;
}
