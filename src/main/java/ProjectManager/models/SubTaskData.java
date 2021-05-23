package ProjectManager.models;

import java.util.List;

public class SubTaskData {
    private int subTaskID;
    private String subTaskName;
    private static int count;
    private int taskID;
    private int subTaskCost;
    private int taskCost;


    public SubTaskData(int subTaskID, String subTaskName, int subTaskCost, int taskID) {
        this.subTaskID = subTaskID;
        this.subTaskName = subTaskName;
        this.subTaskCost = subTaskCost;
        this.taskID = taskID;
    }


    public void setSubTaskCost(int subTaskCost) {
        this.subTaskCost = subTaskCost;
    }

    public int getSubTaskCost() {
        return subTaskCost;
    }

    public SubTaskData(String subTaskName, int taskID){
        count++;
        this.subTaskID=count;
        this.subTaskName=subTaskName;
        this.taskID=taskID;
    }

    public SubTaskData(int subTaskID, String subTaskName, int taskID) {
        this.subTaskID = subTaskID;
        this.subTaskName = subTaskName;
        this.taskID = taskID;
    }

    public void setSubTaskName(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public String getSubTaskName() {
        return subTaskName;
    }

    public int getSubTaskID() {
        return subTaskID;
    }

    public void setSubTaskID(int subTaskID) {
        this.subTaskID = subTaskID;
    }

    public SubTaskData(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public SubTaskData() {

    }

}
