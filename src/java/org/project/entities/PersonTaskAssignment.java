/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CNA
 */
@Entity
@Table(name = "person_task_assignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonTaskAssignment.findAll", query = "SELECT p FROM PersonTaskAssignment p"),
    @NamedQuery(name = "PersonTaskAssignment.findAssignments", query = "SELECT p.personTaskAssignmentId, p.taskId.taskName, p.dateFrom, p.dateTo FROM PersonTaskAssignment p"),
    @NamedQuery(name = "PersonTaskAssignment.findByPersonTaskAssignmentId", query = "SELECT p FROM PersonTaskAssignment p WHERE p.personTaskAssignmentId = :personTaskAssignmentId"),
    @NamedQuery(name = "PersonTaskAssignment.findByDateFrom", query = "SELECT p FROM PersonTaskAssignment p WHERE p.dateFrom = :dateFrom"),
    @NamedQuery(name = "PersonTaskAssignment.findByDateTo", query = "SELECT p FROM PersonTaskAssignment p WHERE p.dateTo = :dateTo")})
public class PersonTaskAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSON_TASK_ASSIGNMENT_ID")
    private Integer personTaskAssignmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DATE_TO")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personTaskAssignmentId")
    private List<TimeSpent> timeSpentList;
    @JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID")
    @ManyToOne(optional = false)
    private Task taskId;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")
    @ManyToOne(optional = false)
    private Person personId;

    public void setTimeSpentList(List<TimeSpent> timeSpentList) {
        this.timeSpentList = timeSpentList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PersonTaskAssignment() {
    }

    public PersonTaskAssignment(Integer personTaskAssignmentId) {
        this.personTaskAssignmentId = personTaskAssignmentId;
    }

    public PersonTaskAssignment(Integer personTaskAssignmentId, Date dateFrom) {
        this.personTaskAssignmentId = personTaskAssignmentId;
        this.dateFrom = dateFrom;
    }

    public Integer getPersonTaskAssignmentId() {
        return personTaskAssignmentId;
    }

    public void setPersonTaskAssignmentId(Integer personTaskAssignmentId) {
        this.personTaskAssignmentId = personTaskAssignmentId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @XmlTransient
    public List<TimeSpent> getTimeSpentList() {
        return timeSpentList;
    }

    public void setTimeSpentCollection(List<TimeSpent> timeSpentList) {
        this.timeSpentList = timeSpentList;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personTaskAssignmentId != null ? personTaskAssignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonTaskAssignment)) {
            return false;
        }
        PersonTaskAssignment other = (PersonTaskAssignment) object;
        return (this.personTaskAssignmentId != null || other.personTaskAssignmentId == null) && (this.personTaskAssignmentId == null || this.personTaskAssignmentId.equals(other.personTaskAssignmentId));
    }

    @Override
    public String toString() {
        return "org.project.entities.PersonTaskAssignment[ personTaskAssignmentId=" + personTaskAssignmentId + " ]";
    }
    
}
