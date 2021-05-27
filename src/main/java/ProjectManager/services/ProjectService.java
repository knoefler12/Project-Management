package ProjectManager.services;

import ProjectManager.models.ProjectData;
import ProjectManager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProjectService {

    //Service lag for projectRepository
    ProjectRepository projectRepository = new ProjectRepository();


    public ProjectData read(int id) throws SQLException {
        return projectRepository.read(id);
    }

    public List<ProjectData> readAll() throws SQLException {
        return projectRepository.readAll();
    }

    public void update(ProjectData projectData) throws SQLException {
        projectRepository.update(projectData);
    }

    public void delete(int id) throws SQLException{
        projectRepository.delete(id);
    }

    public void create(ProjectData ProjectData) throws SQLException {
        projectRepository.create(ProjectData);
    }
}
