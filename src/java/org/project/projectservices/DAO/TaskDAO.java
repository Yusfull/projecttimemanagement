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
import org.project.entities.Task;
import org.project.projectservices.TaskService;

/**
 *
 * @author CNA
 */
@Stateless
public class TaskDAO implements TaskService{
    
    @PersistenceContext(name = "projecttimemanagementPU")
    EntityManager em;

    @Override
    public void addTask(Task task) {
        em.persist(task);
    }

    @Override
    public void editTask(Task task) {
        em.merge(task);
    }

    @Override
    public void removeTask(int taskID) {
        em.remove(getTask(taskID));
    }

    @Override
    public Task getTask(Integer taskID) {
        return em.find(Task.class, taskID);
    }

    @Override
    public List<Task> getAll() {
        return em.createNamedQuery("Task.findAll").getResultList();
    }
    
}
