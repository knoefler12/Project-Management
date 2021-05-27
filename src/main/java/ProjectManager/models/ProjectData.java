package ProjectManager.models;

import ProjectManager.services.ProjectService;
import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectData {

    //Attributes
    private String projectName;
    private int projectBudget;
    private LocalDate projectDeadline;
    private int projectID;


    //Setters
    public void setProjectDeadline(LocalDate projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int setProjectID(int projectID) {
        this.projectID = projectID;
        return projectID;
    }

    //Getters
    public String getProjectName() {
        return projectName;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getProjectBudget() {
        return projectBudget;
    }

    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }



    //Constructors
    public ProjectData(String projectName, int projectBudget, LocalDate projectDeadline) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDeadline = projectDeadline;
    }

    public ProjectData(int projectID, String projectName, int projectBudget, LocalDate projectDeadline) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDeadline = projectDeadline;
    }

    public ProjectData() {

    }
    public ProjectData(String projectName) {
        this.projectName=projectName;
    }
}
