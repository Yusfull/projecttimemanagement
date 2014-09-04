/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices;

import java.util.List;
import javax.ejb.Local;
import org.project.entities.Project;

/**
 *
 * @author CNA
 */
@Local
public interface ProjectService {
    
    public void addProject(Project project);
    
    public void editProject(Project project);
    
    public void removeProject(int projectID);
    
    public Project getProject(Integer projectID);
    
    public List<Project> getAll();
    
}
