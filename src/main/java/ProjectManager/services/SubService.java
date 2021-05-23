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

    //make autowired
    //@Autowired

    SubTaskRepository subTaskRepository = new SubTaskRepository();

    public void create(String subTaskName, int taskID, int subTaskCost) throws SQLException {
        subTaskRepository.create(subTaskName,taskID, subTaskCost);
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

    public List<SubTaskData> readAll(){
        return subTaskRepository.readAll();
    }

    public void update(SubTaskData subTaskData) throws SQLException {
        subTaskRepository.update(subTaskData);
    }

    public void delete(int id) throws SQLException{
        subTaskRepository.delete(id);
    }
}
