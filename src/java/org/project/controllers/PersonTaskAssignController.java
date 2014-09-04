/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;
import org.project.entities.Person;
import org.project.entities.PersonTaskAssignment;
import org.project.entities.Task;
import org.project.projectservices.PersonService;
import org.project.projectservices.PersonTaskAssignmentService;
import org.project.projectservices.TaskService;

/**
 *
 * @author CNA
 */
@ManagedBean
@ViewScoped
public class PersonTaskAssignController implements Serializable{

    @EJB
    private TaskService taskService;
    @EJB
    private PersonService persService;
    @EJB
    private PersonTaskAssignmentService service;
    
    private int personID;
    private int taskID;
    private Date dateFrom;
    private Date dateTo;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    } 
    

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    
    public void assignMember(ActionEvent event){
        
        PersonTaskAssignment assignment = new PersonTaskAssignment();
        assignment.setPersonId(getPerson());
        assignment.setTaskId(getTask());
        assignment.setDateFrom(dateFrom);
        assignment.setDateTo(dateTo);
        
        service.addPersonTaskAssignment(assignment);        
    }
    
    public void editAssignment(RowEditEvent event){
        
        PersonTaskAssignment assignment = (PersonTaskAssignment)event.getObject();
        
        assignment.setDateFrom(dateFrom);
        assignment.setDateTo(dateTo);
        
        service.editPersonTaskAssignment(assignment);
        
        FacesMessage msg = new FacesMessage(assignment.getPersonId().getPersonName(), " has been modified");
        FacesContext.getCurrentInstance().addMessage(null, msg);               
    }
    
    public String removeAssignment(int assignmentID){
        
        service.removePersonTaskAssignment(assignmentID);
        
        return null;
    }
    
    public Person getPerson(){
        
        return persService.getPerson(personID);
    }
    
    public Task getTask(){
        
        return taskService.getTask(taskID);
    }
    
    public List<PersonTaskAssignment> getAssignments(){
        
        return service.getAll();
    }
    
    public List<Person> getPeople(){
        
        return persService.getAll();
    }
    
    public List<Task> getTasks(){
        
        return taskService.getAll();
    }
    
}
