/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.project.entities.PersonTaskAssignment;
import org.project.entities.TimeSpent;
import org.project.projectservices.PersonTaskAssignmentService;
import org.project.projectservices.TimeSpentService;

/**
 *
 * @author CNA
 */
@ManagedBean
@ViewScoped
public class TimeSpentController implements Serializable{
    
    
 /**
 *Injecting all the services i will need in this bean
 */
    
    @EJB
    TimeSpentService service;
    @EJB
    PersonTaskAssignmentService assignService;

    public String getFile() {
        return file;
    }

   //private variables
   private int persTaskAssign;
   private Date dateFrom;
   private Date dateTo;
   private List<Double> list;
   String fileName;
   String file;
   String sqlQuiry;
   Connection conn = null;
   PreparedStatement pr;
   

   //getters and setters to store my values
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
   
   public TimeSpentController(){
   
   }

    public int getPersTaskAssign() {
        return persTaskAssign;
    }

    public void setPersTaskAssign(int persTaskAssign) {
        this.persTaskAssign = persTaskAssign;
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
    
    //gets a specific assinment by ID
    public PersonTaskAssignment getAssignment(){
        return assignService.getPersonTaskAssignment(persTaskAssign);
    }
 //retuns a list of assignments
    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    //experimenting with time
    public void testStoredProcedure(ActionEvent ev){
        for(Double cur: service.getTimeDiff()){
   
            System.out.println("Time diff is: "+ cur);
        }
    }
    //Add a record
    public void addTimeSpent(){
   
        TimeSpent timeSpent = new TimeSpent();
        timeSpent.setPersonTaskAssignmentId(getAssignment());
        timeSpent.setDateTimeFrom(dateFrom);
        timeSpent.setDateTimeTo(dateTo); 
        service.addTimeSpent(timeSpent);
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public List<TimeSpent> getTimeSpent(){
        return service.getAll();   
    }
    
    @PostConstruct
    public void setMyList(){
        
        //setList(service.getTimeDiff());
    }
  
}
