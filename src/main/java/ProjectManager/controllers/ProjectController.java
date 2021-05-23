package ProjectManager.controllers;

import ProjectManager.models.ProjectData;
import ProjectManager.models.SubTaskData;
import ProjectManager.models.TaskData;
import ProjectManager.repository.JDBC;
import ProjectManager.services.ProjectService;
import ProjectManager.services.SubService;
import ProjectManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ProjectManager.services.ProjectService;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller
public class ProjectController {
    private int projectID;
    private int taskID;
    private int subTaskID;
    private TaskData taskDataSession;
    //make it autowired
    //@Autowired
    ProjectService projectService = new ProjectService();
    TaskService taskService = new TaskService();
    SubService subTaskService = new SubService();


    //Projects

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        model.addAttribute("projectList",projectService.readAll());
        return "index.html";
    }

    @GetMapping("/create-project")
    public String createProject(Model model){
        model.addAttribute("projectData",new ProjectData());
        return "create-project.html";
    }

    @PostMapping("/create-project-process")
    public String createProjectProcess(HttpServletRequest request) throws SQLException {
        String projectName = request.getParameter("projectName");
        int projectBudget = Integer.parseInt(request.getParameter("projectBudget"));
        LocalDate projectDeadline = LocalDate.parse(request.getParameter("projectDeadline"));
        projectService.create2(new ProjectData(projectName, projectBudget, projectDeadline));
        return "redirect:/";
    }

    @GetMapping("/delete-project")
    public String deleteProject(@RequestParam("id") int id) throws SQLException{
        projectService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit-project")
    public String editProject(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("project",projectService.read(id));
        model.addAttribute("projectData",new ProjectData());
        projectID=id;
        return "edit-project";
    }
    @PostMapping("edit-project-process")
    public String editProjectProcess(HttpServletRequest request) throws SQLException{
        String projectName = request.getParameter("projectName");
        ProjectData projectData = new ProjectData(projectName);
        projectData.setProjectID(projectID);
        projectService.update(projectData);
        return "redirect:/";
    }


    //Tasks

    @GetMapping("/add-task")
    public String addTask(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("projectID",projectService.read(id));
        model.addAttribute("taskData",new TaskData());
        model.addAttribute("projectList",taskService.getList(id));
        model.addAttribute("taskCost",taskService.getCostOfTasks(id));
        projectID=id;
        return "add-task.html";
    }

    @PostMapping("/add-task-process")
    public String addTaskProcess(HttpServletRequest request) throws SQLException {
        String taskName = request.getParameter("taskName");
        taskService.create(taskName, projectID);
        return "redirect:/add-task?id="+projectID;
    }

    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam("id") int id) throws SQLException{
        taskService.delete(id);
        return "redirect:/add-task?id="+projectID;
    }

    @GetMapping("/edit-task")
    public String editTask(@RequestParam("id") int id,Model model) throws SQLException {
        model.addAttribute("task", taskService.read(id));
        model.addAttribute("taskData",new TaskData());
        taskID=id;
        return "edit-task.html";
    }

    @PostMapping("/edit-task-process")
    public String editTaskProcess(HttpServletRequest request) throws SQLException{
        String taskName = request.getParameter("taskName");
        TaskData taskData = new TaskData(taskName);
        taskData.setTaskID(taskID);
        taskService.update(taskData);
        return "redirect:/add-task?id="+projectID;
    }

    //Sub-Tasks

    @GetMapping("/add-sub-task")
    public String addSubTask(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("taskID",taskService.read(id));
        model.addAttribute("subTaskData",new SubTaskData());
        model.addAttribute("projectList", subTaskService.getList(id));
        taskID=id;
        return "add-sub-task.html";
    }

    @PostMapping("/add-sub-task-process")
    public String addSubTaskProcess(HttpServletRequest request) throws SQLException {
        String subTaskName = request.getParameter("subTaskName");
        int subTaskCost = Integer.parseInt(request.getParameter("subTaskCost"));
        subTaskService.create(subTaskName, taskID, subTaskCost);
        taskService.updateTaskCost(subTaskService.getCostOfSubTasks(taskID),taskID);
        return "redirect:/add-sub-task?id="+taskID;
    }

    @GetMapping("/delete-sub-task")
    public String deleteSubTask(@RequestParam("id") int id) throws SQLException{
        subTaskService.delete(id);
        return "redirect:/add-sub-task?id="+taskID;
    }

    @GetMapping("/edit-sub-task")
    public String editSubTask(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("subTask",subTaskService.read(id));
        model.addAttribute("subTaskData",new SubTaskData());
        subTaskID=id;
        return "edit-sub-task";
    }

    @PostMapping("/edit-sub-task-process")
    public String editSubTaskProcess(HttpServletRequest request) throws SQLException {
        String subTaskName = request.getParameter("subTaskName");
        SubTaskData subTaskData = new SubTaskData(subTaskName);
        subTaskData.setSubTaskID(subTaskID);
        subTaskService.update(subTaskData);
        return "redirect:/add-sub-task?id="+taskID;
    }
}
