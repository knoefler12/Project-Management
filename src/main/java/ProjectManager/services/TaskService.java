package ProjectManager.services;

import ProjectManager.models.TaskData;
import ProjectManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {

    //make autowired
    //@Autowired
    TaskRepository taskRepository = new TaskRepository();

    public void create(String taskName, int projectID) throws SQLException {
        taskRepository.create(taskName,projectID);
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

    public List<TaskData> readAll(){
        return taskRepository.readAll();
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
