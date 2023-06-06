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
@Table(name = "SALES", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findByDateitem", query = "SELECT s FROM Sales s WHERE s.dateitem = :dateitem")
    , @NamedQuery(name = "Sales.findByQuantity", query = "SELECT s FROM Sales s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "Sales.findByAmount", query = "SELECT s FROM Sales s WHERE s.amount = :amount")})
public class Sales implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATEITEM")
    private String dateitem;
    @Column(name = "QUANTITY")
    private String quantity;
    @Column(name = "AMOUNT")
    private String amount;

    public Sales() {
    }

    public Sales(String dateitem) {
        this.dateitem = dateitem;
    }

    public String getDateitem() {
        return dateitem;
    }

    public void setDateitem(String dateitem) {
        String oldDateitem = this.dateitem;
        this.dateitem = dateitem;
        changeSupport.firePropertyChange("dateitem", oldDateitem, dateitem);
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
        hash += (dateitem != null ? dateitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.dateitem == null && other.dateitem != null) || (this.dateitem != null && !this.dateitem.equals(other.dateitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Sales[ dateitem=" + dateitem + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
