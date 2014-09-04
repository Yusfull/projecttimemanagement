/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author CNA
 * 
 */
@Entity
@Table(name = "time_spent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeSpent.findAll", query = "SELECT t FROM TimeSpent t"),
    @NamedQuery(name = "TimeSpent.findByTimeSpentId", query = "SELECT t FROM TimeSpent t WHERE t.timeSpentId = :timeSpentId"),
    @NamedQuery(name = "TimeSpent.findByDateTimeFrom", query = "SELECT t FROM TimeSpent t WHERE t.dateTimeFrom = :dateTimeFrom"),
    @NamedQuery(name = "TimeSpent.findByDateTimeTo", query = "SELECT t FROM TimeSpent t WHERE t.dateTimeTo = :dateTimeTo")})

/**
 * simple entity class with jpa annotations and named queries
 */
public class TimeSpent implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIME_SPENT_ID")
    private Integer timeSpentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TIME_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TIME_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeTo;
    @JoinColumn(name = "PERSON_TASK_ASSIGNMENT_ID", referencedColumnName = "PERSON_TASK_ASSIGNMENT_ID")
    @ManyToOne(optional = false)
    private PersonTaskAssignment personTaskAssignmentId;
    
//    @OneToOne
    /*@ManyToOne
    @JoinColumn(name = "PERSON_TASK_ASSIGNMENT_ID", referencedColumnName = "PERSON_TASK_ASSIGNMENT_ID")
    private Person person;
    
    /*
    public void setPerson(Person person) {
        this.person = person;
    }*/
    

    public TimeSpent() {
    }

    /*
    public Person getPerson() {
        return person;
    }*/

    public TimeSpent(Integer timeSpentId) {
        this.timeSpentId = timeSpentId;
    }

    public TimeSpent(Integer timeSpentId, Date dateTimeFrom, Date dateTimeTo) {
        this.timeSpentId = timeSpentId;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
    }

    public Integer getTimeSpentId() {
        return timeSpentId;
    }

    public void setTimeSpentId(Integer timeSpentId) {
        this.timeSpentId = timeSpentId;
    }

    public Date getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(Date dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }
    
    
    public Date getDateTimeTo() {
        return dateTimeTo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setDateTimeTo(Date dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public PersonTaskAssignment getPersonTaskAssignmentId() {
        return personTaskAssignmentId;
    }

    public void setPersonTaskAssignmentId(PersonTaskAssignment personTaskAssignmentId) {
        this.personTaskAssignmentId = personTaskAssignmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeSpentId != null ? timeSpentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeSpent)) {
            return false;
        }
        TimeSpent other = (TimeSpent) object;
        if ((this.timeSpentId == null && other.timeSpentId != null) || (this.timeSpentId != null && !this.timeSpentId.equals(other.timeSpentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.project.entities.TimeSpent[ timeSpentId=" + timeSpentId + " ]";
    }
    
}
