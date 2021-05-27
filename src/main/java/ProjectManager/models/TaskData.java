package ProjectManager.models;

import java.util.ArrayList;
import java.util.List;

public class TaskData {
    //Attributes
    private String taskName;
    private int taskID;
    private int projectID;
    private int taskCost;


    //Setters
    public void setTaskCost(int taskCost) {
        this.taskCost = taskCost;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }



    //Getters
    public int getProjectID() {
        return projectID;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getTaskCost() {
        return taskCost;
    }


    //Constructors
    public TaskData() {

    }

    public TaskData(int taskID, String taskName, int taskCost, int projectID) {
        this.taskID=taskID;
        this.taskName=taskName;
        this.taskCost=taskCost;
        this.projectID=projectID;
    }

    public TaskData(String taskName) {
        this.taskName = taskName;
    }

    public TaskData(String taskName, int projectID) {
        this.taskName = taskName;
        this.projectID = projectID;
    }


}
