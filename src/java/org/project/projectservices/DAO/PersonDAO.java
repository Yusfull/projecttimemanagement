/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.project.entities.Person;
import org.project.projectservices.PersonService;

/**
 *
 * @author CNA
 */

@Stateless
public class PersonDAO implements PersonService{    
    
    @PersistenceContext(name = "projecttimemanagementPU")
    EntityManager em;   
    

    @Override
    public void addPerson(Person person) {        
        
        em.persist(person);
    }

    @Override
    public void editPerson(Person person) {
        
        em.merge(person);
    }

    @Override
    public void removePerson(int personID) {
        
        Person staff = getPerson(personID);
        em.remove(staff);
        
    }

    @Override
    public Person getPerson(Integer personID) {
        
        return em.find(Person.class, personID);
    }

    @Override
    public List<Person> getAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }
    
    
    
}
