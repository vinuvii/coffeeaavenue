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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ORDERLOG", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Orderlog.findAll", query = "SELECT o FROM Orderlog o")
    , @NamedQuery(name = "Orderlog.findByOrderid", query = "SELECT o FROM Orderlog o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orderlog.findByDate", query = "SELECT o FROM Orderlog o WHERE o.date = :date")
    , @NamedQuery(name = "Orderlog.findByTime", query = "SELECT o FROM Orderlog o WHERE o.time = :time")
    , @NamedQuery(name = "Orderlog.findByCustomer", query = "SELECT o FROM Orderlog o WHERE o.customer = :customer")
    , @NamedQuery(name = "Orderlog.findByEmployee", query = "SELECT o FROM Orderlog o WHERE o.employee = :employee")
    , @NamedQuery(name = "Orderlog.findByPointsdiscountsclaimed", query = "SELECT o FROM Orderlog o WHERE o.pointsdiscountsclaimed = :pointsdiscountsclaimed")
    , @NamedQuery(name = "Orderlog.findByBill", query = "SELECT o FROM Orderlog o WHERE o.bill = :bill")
    , @NamedQuery(name = "Orderlog.findByTotal", query = "SELECT o FROM Orderlog o WHERE o.total = :total")})
public class Orderlog implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    @Column(name = "DATE")
    private String date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "EMPLOYEE")
    private String employee;
    @Column(name = "POINTSDISCOUNTSCLAIMED")
    private String pointsdiscountsclaimed;
    @Column(name = "BILL")
    private String bill;
    @Column(name = "TOTAL")
    private String total;

    public Orderlog() {
    }

    public Orderlog(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        Integer oldOrderid = this.orderid;
        this.orderid = orderid;
        changeSupport.firePropertyChange("orderid", oldOrderid, orderid);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        String oldCustomer = this.customer;
        this.customer = customer;
        changeSupport.firePropertyChange("customer", oldCustomer, customer);
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        String oldEmployee = this.employee;
        this.employee = employee;
        changeSupport.firePropertyChange("employee", oldEmployee, employee);
    }

    public String getPointsdiscountsclaimed() {
        return pointsdiscountsclaimed;
    }

    public void setPointsdiscountsclaimed(String pointsdiscountsclaimed) {
        String oldPointsdiscountsclaimed = this.pointsdiscountsclaimed;
        this.pointsdiscountsclaimed = pointsdiscountsclaimed;
        changeSupport.firePropertyChange("pointsdiscountsclaimed", oldPointsdiscountsclaimed, pointsdiscountsclaimed);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderlog)) {
            return false;
        }
        Orderlog other = (Orderlog) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Orderlog[ orderid=" + orderid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
