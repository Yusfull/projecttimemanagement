/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.crosscuttingconcerns;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.project.entities.Project;

/** 
 *
 * @author CNA
 */
@ManagedBean(name = "projectConverterBean")
@NoneScoped
@FacesConverter(value = "projectConverter")
public class ProjectConverter implements Converter{

    @PersistenceContext(unitName="projecttimemanagementPU")
    private transient EntityManager em;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Value: "+value);
        Project temp = em.find(Project.class, Integer.parseInt(value));
        System.out.println("Project name: "+ temp.getProjectName());
        System.out.println("Project ID: "+ temp.getProjectId());
        return temp;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Value as string: "+ value);
        return value.toString();
    }
    
}
