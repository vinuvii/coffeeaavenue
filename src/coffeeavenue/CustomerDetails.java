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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "CUSTOMER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDetails.findAll", query = "SELECT c FROM CustomerDetails c")
    , @NamedQuery(name = "CustomerDetails.findByCustomerid", query = "SELECT c FROM CustomerDetails c WHERE c.customerid = :customerid")
    , @NamedQuery(name = "CustomerDetails.findByCustomername", query = "SELECT c FROM CustomerDetails c WHERE c.customername = :customername")
    , @NamedQuery(name = "CustomerDetails.findByMobilenumber", query = "SELECT c FROM CustomerDetails c WHERE c.mobilenumber = :mobilenumber")})
public class CustomerDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private Integer customerid;
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Column(name = "MOBILENUMBER")
    private String mobilenumber;
    @Lob
    @Column(name = "BARCODE")
    private Serializable barcode;
    @Lob
    @Column(name = "POINTS")
    private String points;
    @Lob
    @Column(name = "TOTALPURCHASESMADE")
    private String totalpurchasesmade;
    @Lob
    @Column(name = "ALLPURCHASES")
    private String allpurchases;

    public CustomerDetails() {
    }

    public CustomerDetails(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        Integer oldCustomerid = this.customerid;
        this.customerid = customerid;
        changeSupport.firePropertyChange("customerid", oldCustomerid, customerid);
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        String oldCustomername = this.customername;
        this.customername = customername;
        changeSupport.firePropertyChange("customername", oldCustomername, customername);
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        String oldMobilenumber = this.mobilenumber;
        this.mobilenumber = mobilenumber;
        changeSupport.firePropertyChange("mobilenumber", oldMobilenumber, mobilenumber);
    }

    public Serializable getBarcode() {
        return barcode;
    }

    public void setBarcode(Serializable barcode) {
        Serializable oldBarcode = this.barcode;
        this.barcode = barcode;
        changeSupport.firePropertyChange("barcode", oldBarcode, barcode);
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        String oldPoints = this.points;
        this.points = points;
        changeSupport.firePropertyChange("points", oldPoints, points);
    }

    public String getTotalpurchasesmade() {
        return totalpurchasesmade;
    }

    public void setTotalpurchasesmade(String totalpurchasesmade) {
        String oldTotalpurchasesmade = this.totalpurchasesmade;
        this.totalpurchasesmade = totalpurchasesmade;
        changeSupport.firePropertyChange("totalpurchasesmade", oldTotalpurchasesmade, totalpurchasesmade);
    }

    public String getAllpurchases() {
        return allpurchases;
    }

    public void setAllpurchases(String allpurchases) {
        String oldAllpurchases = this.allpurchases;
        this.allpurchases = allpurchases;
        changeSupport.firePropertyChange("allpurchases", oldAllpurchases, allpurchases);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDetails)) {
            return false;
        }
        CustomerDetails other = (CustomerDetails) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.CustomerDetails[ customerid=" + customerid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
