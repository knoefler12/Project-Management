package ProjectManager.repository;

import java.sql.SQLException;
import java.util.List;

public interface iCrudRepository<T>{

    //methods used in all repositories
    void create(T t) throws SQLException;
    T read(int id) throws SQLException;
    void update (T t) throws SQLException;
    void delete (int id) throws SQLException;

   // void updateTaskCost(T t, D d) throws SQLException;
    //List<T> readAll() throws SQLException;
    //List<T> getList(int id) throws SQLException;
}
