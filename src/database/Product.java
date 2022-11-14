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
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByFoodID", query = "SELECT p FROM Product p WHERE p.foodID = :foodID"),
    @NamedQuery(name = "Product.findByFoodName", query = "SELECT p FROM Product p WHERE p.foodName = :foodName"),
    @NamedQuery(name = "Product.findByFoodPrice", query = "SELECT p FROM Product p WHERE p.foodPrice = :foodPrice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FoodID")
    private Integer foodID;
    @Basic(optional = false)
    @Column(name = "FoodName")
    private String foodName;
    @Basic(optional = false)
    @Column(name = "FoodPrice")
    private int foodPrice;
    @OneToMany(mappedBy = "foodID")
    private Collection<Sale> saleCollection;

    public Product() {
    }

    public Product(Integer foodID) {
        this.foodID = foodID;
    }

    public Product(Integer foodID, String foodName, int foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    @XmlTransient
    public Collection<Sale> getSaleCollection() {
        return saleCollection;
    }

    public void setSaleCollection(Collection<Sale> saleCollection) {
        this.saleCollection = saleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodID != null ? foodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.foodID == null && other.foodID != null) || (this.foodID != null && !this.foodID.equals(other.foodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Product[ foodID=" + foodID + " ]";
    }
    
}
