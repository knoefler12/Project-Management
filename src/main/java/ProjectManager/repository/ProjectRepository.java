package ProjectManager.repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ProjectManager.models.ProjectData;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository implements iCrudRepository<ProjectData>{

    List<ProjectData> projects = new ArrayList<>();


    //creates project
    public void create(ProjectData projectData) throws SQLException {
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            PreparedStatement preparedStatement;
            String sql = "INSERT INTO `project_manager`.`projects` (`project_name`,`project_budget`,`project_deadline`) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,projectData.getProjectName());
            preparedStatement.setInt(2,projectData.getProjectBudget());
            preparedStatement.setDate(3,java.sql.Date.valueOf(projectData.getProjectDeadline()));
            preparedStatement.executeUpdate();
        }catch (SQLException s){
            s.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }


    //gets project from id
    //@Override
    public ProjectData read(int id) throws SQLException {
            ProjectData projectData = new ProjectData();
            Connection connection = JDBC.JDBCconnect();
            try {
                String sql = "SELECT * FROM `project_manager`.`projects` WHERE project_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                projectData.setProjectName(resultSet.getString("project_name"));
                projectData.setProjectBudget(resultSet.getInt("project_budget"));
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                if(connection!=null){
                    connection.close();
                }
            }
            return projectData;
    }


    //returns an array of the projects
    @Override
    public List<ProjectData> readAll() throws SQLException {
        List<ProjectData> list = new ArrayList<>();
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "SELECT * FROM `project_manager`.`projects`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int projectID = rs.getInt("project_id");
                String projectName = rs.getString("project_name");
                int projectBudget = rs.getInt("project_budget");
                LocalDate projectDeadline = LocalDate.parse(rs.getString("project_deadline"));
                list.add(new ProjectData(projectID,projectName,projectBudget,projectDeadline));
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

    //deletes project
    public void delete(int id) throws SQLException{
        Connection connection=null;
        try{
            connection = JDBC.JDBCconnect();

            String sql = "DELETE FROM `project_manager`.`projects` WHERE project_id=?";
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

    public void update(ProjectData projectData) throws SQLException{
        Connection connection = null;
        try{
            connection = JDBC.JDBCconnect();
            String sql = "UPDATE `project_manager`.`projects` SET project_name = ? WHERE project_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,projectData.getProjectName());
            preparedStatement.setInt(2,projectData.getProjectID());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

}
