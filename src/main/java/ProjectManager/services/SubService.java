package ProjectManager.services;

import ProjectManager.models.SubTaskData;
import ProjectManager.repository.SubTaskRepository;
import ProjectManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubService {

    //Service lag for subTaskRepository
    SubTaskRepository subTaskRepository = new SubTaskRepository();

    public void create(SubTaskData subTaskData) throws SQLException {
        subTaskRepository.create(subTaskData);
    }
    public int getCostOfSubTasks(int id) throws SQLException {
        return subTaskRepository.getCostOfSubTasks(id);
    }

    public List<SubTaskData> getList(int id) throws SQLException {
        return subTaskRepository.getList(id);
    }

    public SubTaskData read(int id) throws SQLException{
        return subTaskRepository.read(id);
    }


    public void update(SubTaskData subTaskData) throws SQLException {
        subTaskRepository.update(subTaskData);
    }

    public void delete(int id) throws SQLException{
        subTaskRepository.delete(id);
    }
}
