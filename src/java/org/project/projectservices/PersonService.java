/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices;

import java.util.List;
import javax.ejb.Local;
import org.project.entities.Person;

/**
 *
 * @author CNA
 */
@Local
public interface PersonService {
    
    public void addPerson(Person person);
    
    public void editPerson(Person person);
    
    public void removePerson(int personID);
    
    public Person getPerson(Integer personID);
    
    public List<Person> getAll();
    
}
