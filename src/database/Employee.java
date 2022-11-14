/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zucrem
 */
@Entity
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByPassEmp", query = "SELECT e FROM Employee e WHERE e.passEmp = :passEmp"),
    @NamedQuery(name = "Employee.findByAge", query = "SELECT e FROM Employee e WHERE e.age = :age"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByWorkStatus", query = "SELECT e FROM Employee e WHERE e.workStatus = :workStatus"),
    @NamedQuery(name = "Employee.findByEmployeeLevel", query = "SELECT e FROM Employee e WHERE e.employeeLevel = :employeeLevel")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "passEmp")
    private String passEmp;
    @Basic(optional = false)
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "WorkStatus")
    private String workStatus;
    @Basic(optional = false)
    @Column(name = "EmployeeLevel")
    private int employeeLevel;
    @OneToMany(mappedBy = "employeeID")
    private Collection<Sale> saleCollection;
    @OneToMany(mappedBy = "employeeID")
    private Collection<Timestamp> timestampCollection;

    public Employee() {
    }

    public Employee(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(Integer employeeID, String firstName, String lastName, String passEmp, int age, String address, String workStatus, int employeeLevel) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passEmp = passEmp;
        this.age = age;
        this.address = address;
        this.workStatus = workStatus;
        this.employeeLevel = employeeLevel;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassEmp() {
        return passEmp;
    }

    public void setPassEmp(String passEmp) {
        this.passEmp = passEmp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public int getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(int employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    @XmlTransient
    public Collection<Sale> getSaleCollection() {
        return saleCollection;
    }

    public void setSaleCollection(Collection<Sale> saleCollection) {
        this.saleCollection = saleCollection;
    }

    @XmlTransient
    public Collection<Timestamp> getTimestampCollection() {
        return timestampCollection;
    }

    public void setTimestampCollection(Collection<Timestamp> timestampCollection) {
        this.timestampCollection = timestampCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Employee[ employeeID=" + employeeID + " ]";
    }
    
}
