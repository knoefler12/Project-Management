package ProjectManager.repository;

import ProjectManager.models.ProjectData;
import ProjectManager.models.TaskData;
import org.springframework.scheduling.config.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements iCrudRepository<TaskData> {
    List<TaskData> tasks = new ArrayList<>();


    public void create(String taskName, int projectID) throws SQLException {
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            PreparedStatement preparedStatement;
            String sql = "INSERT INTO `project_manager`.`tasks` (`task_name`,`project_id`) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,taskName);
            preparedStatement.setInt(2,projectID);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

    //gets task from id
    public TaskData read(int id) throws SQLException{
        Connection connection = null;
        TaskData taskData = new TaskData();
        try{
            connection = JDBC.JDBCconnect();
            String sql = "SELECT * FROM `project_manager`.`tasks` WHERE task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            taskData.setTaskName(resultSet.getString("task_name"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return taskData;
    }

    //returns all task from specific projectID
    //@Override
    public List<TaskData> getList(int id) throws SQLException {
        List<TaskData> list = new ArrayList<>();
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "SELECT * FROM `project_manager`.`tasks` WHERE project_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int taskID = resultSet.getInt("task_id");
                String taskName = resultSet.getString("task_name");
                int taskCost = resultSet.getInt("task_cost");
                list.add(new TaskData(taskID, taskName, taskCost, id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return list;
    }

    public void updateTaskCost(int taskCost, int taskID) throws SQLException {
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "UPDATE `project_manager`.`tasks` SET task_cost = ? WHERE task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,taskCost);
            preparedStatement.setInt(2,taskID);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

    @Override
    public List<TaskData> readAll() {
        return tasks;
    }

   public void update(TaskData taskData) throws SQLException{
        Connection connection = null;
        try {
            connection = JDBC.JDBCconnect();
            String sql = "UPDATE `project_manager`.`tasks` SET task_name = ? WHERE task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,taskData.getTaskName());
            preparedStatement.setInt(2,taskData.getTaskID());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
   }

    public void delete(int id) throws SQLException{
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "DELETE FROM `project_manager`.`tasks` WHERE task_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

    public TaskData getCostOfTasks(int id) throws SQLException {
        Connection connection = null;
        TaskData taskData = new TaskData();
        int sum=0;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "SELECT SUM(task_cost) as task_cost FROM `project_manager`.`tasks` WHERE project_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            taskData.setTaskCost(resultSet.getInt("task_cost"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return taskData;
    }

}
