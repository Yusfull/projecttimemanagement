/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices;

import java.util.List;
import javax.ejb.Local;
import org.project.entities.PersonTaskAssignment;

/**
 *
 * @author CNA
 */
@Local
public interface PersonTaskAssignmentService {
    
    public void addPersonTaskAssignment(PersonTaskAssignment persTaskAssign);
    
    public void editPersonTaskAssignment(PersonTaskAssignment persTaskAssign);
    
    public void removePersonTaskAssignment(int persTaskAssignID);
    
    public PersonTaskAssignment getPersonTaskAssignment(Integer persTaskAssignID);
    
    public List<PersonTaskAssignment> getAll();
    
    
}
