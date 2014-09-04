/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.projectservices.DAO;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.project.entities.TimeSpent;
import org.project.projectservices.TimeSpentService;

/**
 *
 * @author CNA
 */
@Stateless
public class TimeSpentDAO implements TimeSpentService{
    
    @PersistenceContext(name = "projecttimemanagementPU")
    private EntityManager em;
    

    @Override
    public void addTimeSpent(TimeSpent timeSpent) {
        em.persist(timeSpent);
    }

    @Override
    public void editTimeSpent(TimeSpent timeSpent) {
        em.merge(timeSpent);
    }

    @Override
    public void removeTimeSpent(int timeSpentID) {
        em.refresh(getTimeSpent(timeSpentID));
    }

    @Override
    public TimeSpent getTimeSpent(Integer timeSpentID) {
        return em.find(TimeSpent.class, timeSpentID);
    }

    @Override
    public List<TimeSpent> getAll() {
        return em.createNamedQuery("TimeSpent.findAll", TimeSpent.class).getResultList();
    }

    @Override
    public Integer getTimeSpentByPersonTaskAssignmentID(int personTaskAssignmentID) {
        StoredProcedureQuery storedProc = em.createStoredProcedureQuery("total_time_spent");
        
        //register parameters
        storedProc.registerStoredProcedureParameter("perstask_assignID", Integer.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter("time_spent", Long.class, ParameterMode.OUT);
        
        //set parameters
        storedProc.setParameter("perstask_assignID", personTaskAssignmentID);
        //execute stored procedure
        storedProc.execute();
        //get results
        return (Integer)storedProc.getOutputParameterValue("time_spent");
    }
    
    

    @Override
    public List<Double> getTimeDiff() {       
        
        
        Query query;
        query = em.createQuery("Select t.dateTimeTo,t.dateTimeFrom FROM TimeSpent t");
        List<Double> times = new ArrayList<>();
        
        for(Object obj: query.getResultList()){
            
            Double temp = (Double)obj;
            times.add(temp);
            System.out.println("Time diff is: "+ obj);
        }
        return times;
    }

    @Override
    public void loadData() {
        
//        String filePath = "C:/Users/CNA/Desktop/timeData.txt";
//        String sql = "select all from employee";
//        
//        
//        em.createQuery(sql);
//      
//        
        
        
        
    }

    
    
    
    
    
}
