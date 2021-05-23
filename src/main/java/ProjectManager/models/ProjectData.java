package ProjectManager.models;

import ProjectManager.services.ProjectService;
import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectData {
    private String projectName;
    private static int count;
    private int projectBudget;
    private LocalDate projectDeadline;
    private int projectID;


    public ProjectData(int projectID, String projectName, int projectBudget, LocalDate projectDeadline) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDeadline = projectDeadline;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public void setProjectDeadline(LocalDate projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public ProjectData(int projectID, String projectName) {
        this.projectName = projectName;
        this.projectID = projectID;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private List<TaskData> tasks;

    public ProjectData(String projectName) {
        count++;
        this.projectID=count;
        this.projectName=projectName;
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        addTask(task);
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectID() {
        return projectID;
    }

    public int setProjectID(int projectID) {
        this.projectID = projectID;
        return projectID;
    }

    public ProjectData() {

    }

    public int getProjectBudget() {
        return projectBudget;
    }



    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }

    public ProjectData(String projectName, int projectBudget, LocalDate projectDeadline) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDeadline = projectDeadline;
    }
}
