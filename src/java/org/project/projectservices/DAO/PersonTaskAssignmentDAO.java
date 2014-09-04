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
import org.project.entities.PersonTaskAssignment;
import org.project.projectservices.PersonTaskAssignmentService;



/**
 *
 * @author CNA
 */
@Stateless
public class PersonTaskAssignmentDAO implements PersonTaskAssignmentService{
    
    @PersistenceContext(unitName="projecttimemanagementPU")
    EntityManager em;

    @Override
    public void addPersonTaskAssignment(PersonTaskAssignment persTaskAssign) {
        em.persist(persTaskAssign);
    }

    @Override
    public void editPersonTaskAssignment(PersonTaskAssignment persTaskAssign) {
        em.merge(persTaskAssign);
    }

    @Override
    public void removePersonTaskAssignment(int persTaskAssignID) {
        em.remove(persTaskAssignID);
    }

    @Override
    public PersonTaskAssignment getPersonTaskAssignment(Integer persTaskAssignID) {
        return em.find(PersonTaskAssignment.class, persTaskAssignID);
    }

    @Override
    public List<PersonTaskAssignment> getAll() {
        return em.createNamedQuery("PersonTaskAssignment.findAll", PersonTaskAssignment.class).getResultList();
    }
   
   
}
