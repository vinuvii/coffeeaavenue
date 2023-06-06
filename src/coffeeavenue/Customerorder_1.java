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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "CUSTOMERORDER", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Customerorder_1.findAll", query = "SELECT c FROM Customerorder_1 c")
    , @NamedQuery(name = "Customerorder_1.findByCustomerorderid", query = "SELECT c FROM Customerorder_1 c WHERE c.customerorderid = :customerorderid")
    , @NamedQuery(name = "Customerorder_1.findByBill", query = "SELECT c FROM Customerorder_1 c WHERE c.bill = :bill")
    , @NamedQuery(name = "Customerorder_1.findByTotal", query = "SELECT c FROM Customerorder_1 c WHERE c.total = :total")
    , @NamedQuery(name = "Customerorder_1.findByCustomername", query = "SELECT c FROM Customerorder_1 c WHERE c.customername = :customername")
    , @NamedQuery(name = "Customerorder_1.findByCustomerid", query = "SELECT c FROM Customerorder_1 c WHERE c.customerid = :customerid")})
public class Customerorder_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSTOMERORDERID")
    private Integer customerorderid;
    @Lob
    @Column(name = "BARCODE")
    private Serializable barcode;
    @Column(name = "BILL")
    private String bill;
    @Column(name = "TOTAL")
    private String total;
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Column(name = "CUSTOMERID")
    private Integer customerid;

    public Customerorder_1() {
    }

    public Customerorder_1(Integer customerorderid) {
        this.customerorderid = customerorderid;
    }

    public Integer getCustomerorderid() {
        return customerorderid;
    }

    public void setCustomerorderid(Integer customerorderid) {
        Integer oldCustomerorderid = this.customerorderid;
        this.customerorderid = customerorderid;
        changeSupport.firePropertyChange("customerorderid", oldCustomerorderid, customerorderid);
    }

    public Serializable getBarcode() {
        return barcode;
    }

    public void setBarcode(Serializable barcode) {
        Serializable oldBarcode = this.barcode;
        this.barcode = barcode;
        changeSupport.firePropertyChange("barcode", oldBarcode, barcode);
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        String oldBill = this.bill;
        this.bill = bill;
        changeSupport.firePropertyChange("bill", oldBill, bill);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        String oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        String oldCustomername = this.customername;
        this.customername = customername;
        changeSupport.firePropertyChange("customername", oldCustomername, customername);
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        Integer oldCustomerid = this.customerid;
        this.customerid = customerid;
        changeSupport.firePropertyChange("customerid", oldCustomerid, customerid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerorderid != null ? customerorderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customerorder_1)) {
            return false;
        }
        Customerorder_1 other = (Customerorder_1) object;
        if ((this.customerorderid == null && other.customerorderid != null) || (this.customerorderid != null && !this.customerorderid.equals(other.customerorderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Customerorder_1[ customerorderid=" + customerorderid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
