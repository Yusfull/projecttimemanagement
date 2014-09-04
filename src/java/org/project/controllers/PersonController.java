/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.StreamedContent;
import org.project.entities.Person;
import org.project.projectservices.PersonService;

/**
 *
 * @author CNA
 */
@ManagedBean
@ViewScoped
public class PersonController implements Serializable{

    //injecting a servise
    @EJB
    private PersonService service;
    
    private int personID;
    private String name;
    private Person person;
    private StreamedContent file;
    private List filteredList;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    //add a person method
    public void addPerson(ActionEvent event){
        Person pers = new Person();
        pers.setPersonName(name);  
        service.addPerson(pers);
    }
    
    public String changePerson(Person pers){
        person = pers;
        return null;
    }
    
    @PostConstruct
    public void initList(){
        
        filteredList = service.getAll();
    }
    
    //edit or update person method
    public void editPerson(RowEditEvent event){   
        Person temp = (Person)event.getObject();
        temp.setPersonName(name);
        service.editPerson(temp);
        FacesMessage msg = new FacesMessage("Person edited is: ", temp.getPersonName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    //deleting 
    public String removePerson(int personID){
        System.out.println("removing "+ personID);
        service.removePerson(personID);
        return null;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public List getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List filteredList) {
        this.filteredList = filteredList;
    }
    
    
    
    
    public void exportPerson(ActionEvent e){
        
        InputStream stream = (InputStream) ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()); 
    }
    
    public List<Person> getAll(){
        return service.getAll();
    }
    
    
    
}
