/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices;

import java.util.List;
import javax.ejb.Local;
import org.project.entities.TimeSpent;

/**
 *
 * @author CNA
 * 
 */
@Local
public interface TimeSpentService {
    
    public void addTimeSpent(TimeSpent timeSpent);
    
    public void editTimeSpent(TimeSpent timeSpent);
    
    public void removeTimeSpent(int timeSpentID);
    
    public TimeSpent getTimeSpent(Integer timeSpentID);
    
    public Integer getTimeSpentByPersonTaskAssignmentID(int personTaskAssignmentID);
    
    public List<TimeSpent> getAll();
   
    public List<Double> getTimeDiff();
    
    public void loadData();
    
   
    
}
