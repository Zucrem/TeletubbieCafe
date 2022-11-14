/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zucrem
 */
@Entity
@Table(name = "TIMESTAMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timestamp.findAll", query = "SELECT t FROM Timestamp t"),
    @NamedQuery(name = "Timestamp.findBySeq", query = "SELECT t FROM Timestamp t WHERE t.seq = :seq"),
    @NamedQuery(name = "Timestamp.findByDateTimeLogin", query = "SELECT t FROM Timestamp t WHERE t.dateTimeLogin = :dateTimeLogin"),
    @NamedQuery(name = "Timestamp.findByDateTimeLogOut", query = "SELECT t FROM Timestamp t WHERE t.dateTimeLogOut = :dateTimeLogOut")})
public class Timestamp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Seq")
    private Integer seq;
    @Column(name = "DateTimeLogin")
    @Temporal(TemporalType.DATE)
    private Date dateTimeLogin;
    @Column(name = "DateTimeLogOut")
    @Temporal(TemporalType.DATE)
    private Date dateTimeLogOut;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employee employeeID;

    public Timestamp() {
    }

    public Timestamp(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getDateTimeLogin() {
        return dateTimeLogin;
    }

    public void setDateTimeLogin(Date dateTimeLogin) {
        this.dateTimeLogin = dateTimeLogin;
    }

    public Date getDateTimeLogOut() {
        return dateTimeLogOut;
    }

    public void setDateTimeLogOut(Date dateTimeLogOut) {
        this.dateTimeLogOut = dateTimeLogOut;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seq != null ? seq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timestamp)) {
            return false;
        }
        Timestamp other = (Timestamp) object;
        if ((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Timestamp[ seq=" + seq + " ]";
    }
    
}
