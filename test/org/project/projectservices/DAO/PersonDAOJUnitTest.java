/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.project.entities.Person;
import org.project.projectservices.PersonService;

/**
 *
 * @author CNA
 */
public class PersonDAOJUnitTest {
  
    
    private static EntityManagerFactory factory;
    
    //@EJB
    PersonService service;
    
    public PersonDAOJUnitTest() {
        
        
        factory = Persistence.createEntityManagerFactory("projecttimemanagementPU");
        //factory.
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addPerson(){
   
        Person person = new Person();
        person.setPersonName("Yanga Goniwe");
        service.addPerson(person);
      
    }
}
