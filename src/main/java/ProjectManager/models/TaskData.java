package ProjectManager.models;

import java.util.ArrayList;
import java.util.List;

public class TaskData {
    private String taskName;
    private int taskID;
    private static int count;
    private List<SubTaskData> subTasks;
    private int projectID;
    private int taskCost;

    public TaskData(int taskID, String taskName, int taskCost, int projectID) {
        this.taskID=taskID;
        this.taskName=taskName;
        this.taskCost=taskCost;
        this.projectID=projectID;
    }

    public int getTaskCost() {
        return taskCost;
    }

    public void setTaskCost(int taskCost) {
        this.taskCost = taskCost;
    }

    public TaskData(int taskID, String taskName, int projectID){
        this.taskID=taskID;
        this.taskName=taskName;
        this.projectID=projectID;
    }

    public TaskData(int taskID, String taskName){
        this.taskID=taskID;
        this.taskName=taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getProjectID() {
        return projectID;
    }


    public TaskData(String taskName, int projectID) {
        count++;
        this.taskID=count;
        this.taskName = taskName;
        this.projectID = projectID;
        subTasks = new ArrayList<>();
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public TaskData(String taskName) {
        this.taskName = taskName;
    }
    public TaskData() {

    }


}
