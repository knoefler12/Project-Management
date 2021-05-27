package ProjectManager.services;

import ProjectManager.models.TaskData;
import ProjectManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {

    //Service lag for taskRepository
    TaskRepository taskRepository = new TaskRepository();

    public void create(TaskData taskData) throws SQLException {
        taskRepository.create(taskData);
    }

    public List<TaskData> getList(int id) throws SQLException {
        return taskRepository.getList(id);
    }

    public TaskData read(int id) throws SQLException{
        return taskRepository.read(id);
    }

    public TaskData getCostOfTasks(int id) throws SQLException {
        return taskRepository.getCostOfTasks(id);
    }

    public void update(TaskData taskData) throws SQLException {
        taskRepository.update(taskData);
    }
    public void updateTaskCost(int taskCost, int taskID) throws SQLException {
        taskRepository.updateTaskCost(taskCost,taskID);
    }
    public void delete(int id) throws SQLException{
        taskRepository.delete(id);
    }
}
