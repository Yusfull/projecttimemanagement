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
import org.project.entities.Project;
import org.project.projectservices.ProjectService;

/**
 *
 * @author CNA
 */
@Stateless
public class ProjectDAO implements ProjectService{
    
    @PersistenceContext(name = "projecttimemanagementPU")
    EntityManager em;   
    

    @Override
    public void addProject(Project project) {        
        
        em.persist(project);
    }

    @Override
    public void editProject(Project project) {
        
        em.merge(project);
    }

    @Override
    public void removeProject(int projectID) {
        
        Project project = getProject(projectID);
        em.remove(project);
        
    }

    @Override
    public Project getProject(Integer projectID) {
        
        return em.find(Project.class, projectID);
    }

    @Override
    public List<Project> getAll() {
        return em.createNamedQuery("Project.findAll", Project.class).getResultList();
    }    
}
