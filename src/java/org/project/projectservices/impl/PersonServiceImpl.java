/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices.impl;

import java.util.List;
import javax.ejb.EJB;
import org.omg.CORBA.PERSIST_STORE;
import org.project.entities.Person;
import org.project.projectservices.DAO.PersonDAO;
import org.project.projectservices.PersonService;

/**
 *
 * @author CNA
 */
public class PersonServiceImpl implements PersonService{

    @EJB
    private PersonDAO personDao;
    
    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public void editPerson(Person person) {
        personDao.editPerson(person);
    }

    @Override
    public void removePerson(int personID) {
        personDao.removePerson(personID);
    }

    @Override
    public Person getPerson(Integer personID) {
      return  personDao.getPerson(personID);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }
    
}
