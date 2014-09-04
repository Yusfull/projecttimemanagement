/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.project.entities.Project;
import org.project.entities.Task;
import org.project.projectservices.ProjectService;
import org.project.projectservices.TaskService;

/**
 *
 * @author CNA
 */
@ManagedBean
@ViewScoped
public class TaskController implements Serializable{
    
    @EJB
    private TaskService service;
    @EJB
    private ProjectService projService;
    
    private int taskID;
    private int projectID;
    private String taskName;
        
    private Task task;
    
    public TaskController(){
        
        
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    
    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    
    public String addTask(){
        
        Task tempTask = new Task();
        tempTask.setProjectId(getProject());
        tempTask.setTaskName(taskName);
        service.addTask(tempTask);
        return null;
    }
    
    public String changeTask(Task tempTask){
        task = tempTask;
        return null;
    }
    
    public String editTask(){
        service.editTask(task);
        task = null;
        return null;
    }
    
    public String removeTask(int taskID){
        service.removeTask(taskID);
        return null;
    }
    
    public List<Task> getAll(){
        return service.getAll();
    }
    
    public List<Project> getProjects(){
        return projService.getAll();
    }
    
    public Project getProject(){
        return projService.getProject(projectID);
        
    }
}
