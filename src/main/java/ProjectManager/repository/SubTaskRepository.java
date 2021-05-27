package ProjectManager.repository;

import ProjectManager.models.ProjectData;
import ProjectManager.models.SubTaskData;
import ProjectManager.models.TaskData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubTaskRepository implements iCrudRepository<SubTaskData>{


    //creates subtask
    @Override
    public void create(SubTaskData subTaskData) throws SQLException {
       Connection connection = null;
       try {
           connection = JDBC.JDBCconnect();
           PreparedStatement preparedStatement;
           String sql = "INSERT INTO `project_manager`.`subtasks` (`subtask_name`,`task_id`, `subtask_cost`) VALUES (?,?,?)";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, subTaskData.getSubTaskName());
           preparedStatement.setInt(2, subTaskData.getTaskID());
           preparedStatement.setInt(3, subTaskData.getSubTaskCost());
           preparedStatement.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           if(connection!=null){
               connection.close();
           }
       }
    }

    //returns subtask from id
    @Override
    public SubTaskData read(int id) throws SQLException{
       Connection connection = null;
       SubTaskData subTaskData = new SubTaskData();
       try{
           connection = JDBC.JDBCconnect();
           String sql = "SELECT * FROM `project_manager`.`subtasks` WHERE subtask_id = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           subTaskData.setSubTaskName(resultSet.getString("subtask_name"));
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           if(connection!=null){
               connection.close();
           }
       }
       return subTaskData;
    }

    //returns subtasks from specific taskID
    public List<SubTaskData> getList(int id) throws SQLException {
       List<SubTaskData> list = new ArrayList<>();
       Connection connection = null;
       try{
           connection = JDBC.JDBCconnect();
           String sql = "SELECT * FROM `project_manager`.`subtasks` WHERE task_id = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();

           while(resultSet.next()){
               int subTaskID = resultSet.getInt("subtask_id");
               String subTaskName = resultSet.getString("subtask_name");
               int subTaskCost = resultSet.getInt("subtask_cost");
               list.add(new SubTaskData(subTaskID,subTaskName,subTaskCost, id));
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

    //edit task
    @Override
    public void update(SubTaskData subTaskData) throws SQLException {
       Connection connection = null;
       try{
           connection = JDBC.JDBCconnect();
           String sql = "UPDATE `project_manager`.`subtasks` SET subtask_name = ? WHERE subtask_id = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,subTaskData.getSubTaskName());
           preparedStatement.setInt(2,subTaskData.getSubTaskID());
           preparedStatement.executeUpdate();

       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           if(connection!=null){
               connection.close();
           }
       }
    }

    //gets cost of all subtasks with same taskID
    public int getCostOfSubTasks(int id) throws SQLException {
        Connection connection = null;
        int sum=0;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "SELECT SUM(subtask_cost) as subtask_cost FROM `project_manager`.`subtasks` WHERE task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            sum = resultSet.getInt("subtask_cost");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return sum;
    }

    //deletes subtask
    @Override
    public void delete(int id) throws SQLException{
        Connection connection=null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "DELETE FROM `project_manager`.`subtasks` WHERE subtask_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }
}
