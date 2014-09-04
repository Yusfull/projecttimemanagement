/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices;

import java.util.List;
import javax.ejb.Local;
import org.project.entities.Task;

/**
 *
 * @author CNA
 */
@Local
public interface TaskService {
    
    public void addTask(Task task);
    
    public void editTask(Task task);
    
    public void removeTask(int taskID);
    
    public Task getTask(Integer taskID);
    
    public List<Task> getAll();
    
}
