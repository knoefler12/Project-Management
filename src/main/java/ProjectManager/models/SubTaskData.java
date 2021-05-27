package ProjectManager.models;

import java.util.List;

public class SubTaskData {
    //Attributes
    private int subTaskID;
    private String subTaskName;
    private int taskID;
    private int subTaskCost;


    //Setters
    public void setSubTaskCost(int subTaskCost) {
        this.subTaskCost = subTaskCost;
    }

    public void setSubTaskName(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public void setSubTaskID(int subTaskID) {
        this.subTaskID = subTaskID;
    }


    //Getters
    public int getSubTaskCost() {
        return subTaskCost;
    }

    public String getSubTaskName() {
        return subTaskName;
    }

    public int getSubTaskID() {
        return subTaskID;
    }

    public int getTaskID() {
        return taskID;
    }


   //Constructors
    public SubTaskData(int subTaskID, String subTaskName, int subTaskCost, int taskID) {
        this.subTaskID = subTaskID;
        this.subTaskName = subTaskName;
        this.subTaskCost = subTaskCost;
        this.taskID = taskID;
    }

    public SubTaskData() {

    }

    public SubTaskData(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public SubTaskData(String subTaskName, int taskID, int subTaskCost) {
        this.subTaskName=subTaskName;
        this.taskID=taskID;
        this.subTaskCost=subTaskCost;
    }
}
