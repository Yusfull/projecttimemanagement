/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;
import org.project.entities.Project;
import org.project.projectservices.ProjectService;

/**
 *
 * @author CNA
 */
@ManagedBean
@ViewScoped
public class ProjectController implements Serializable{

    @EJB
    ProjectService service;
    
    private int projectID;
    private String projectName;
    private Project project;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }    
    
    public void addProject(ActionEvent event){
        
        Project proj = new Project();
        proj.setProjectName(projectName);
        service.addProject(proj);
        
        FacesMessage msg = new FacesMessage(proj.getProjectName(), " has just been added");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    
    
    public void editProject(RowEditEvent event){
        
        
        Project proj = (Project)event.getObject();
        proj.setProjectName(projectName);
        service.editProject(proj);
        
        FacesMessage msg = new FacesMessage(proj.getProjectName(), " has just been edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String removeProject(int projectID){
        
        service.removeProject(projectID);
        return null;
    }
    
    public List<Project> getAll(){
        
        return service.getAll();
    }
}
