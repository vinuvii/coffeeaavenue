/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeavenue;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "EMPLOYEESALES", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Employeesales.findAll", query = "SELECT e FROM Employeesales e")
    , @NamedQuery(name = "Employeesales.findByEmployeeitem", query = "SELECT e FROM Employeesales e WHERE e.employeeitem = :employeeitem")
    , @NamedQuery(name = "Employeesales.findByQuantity", query = "SELECT e FROM Employeesales e WHERE e.quantity = :quantity")
    , @NamedQuery(name = "Employeesales.findByAmount", query = "SELECT e FROM Employeesales e WHERE e.amount = :amount")})
public class Employeesales implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEEITEM")
    private String employeeitem;
    @Column(name = "QUANTITY")
    private String quantity;
    @Column(name = "AMOUNT")
    private String amount;

    public Employeesales() {
    }

    public Employeesales(String employeeitem) {
        this.employeeitem = employeeitem;
    }

    public String getEmployeeitem() {
        return employeeitem;
    }

    public void setEmployeeitem(String employeeitem) {
        String oldEmployeeitem = this.employeeitem;
        this.employeeitem = employeeitem;
        changeSupport.firePropertyChange("employeeitem", oldEmployeeitem, employeeitem);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        String oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeitem != null ? employeeitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeesales)) {
            return false;
        }
        Employeesales other = (Employeesales) object;
        if ((this.employeeitem == null && other.employeeitem != null) || (this.employeeitem != null && !this.employeeitem.equals(other.employeeitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Employeesales[ employeeitem=" + employeeitem + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
