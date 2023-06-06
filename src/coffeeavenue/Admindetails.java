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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ADMINDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admindetails.findAll", query = "SELECT a FROM Admindetails a")
    , @NamedQuery(name = "Admindetails.findByAdminid", query = "SELECT a FROM Admindetails a WHERE a.adminid = :adminid")
    , @NamedQuery(name = "Admindetails.findByAdminname", query = "SELECT a FROM Admindetails a WHERE a.adminname = :adminname")
    , @NamedQuery(name = "Admindetails.findByPassword", query = "SELECT a FROM Admindetails a WHERE a.password = :password")})
public class Admindetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADMINID")
    private String adminid;
    @Column(name = "ADMINNAME")
    private String adminname;
    @Column(name = "PASSWORD")
    private String password;

    public Admindetails() {
    }

    public Admindetails(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        String oldAdminid = this.adminid;
        this.adminid = adminid;
        changeSupport.firePropertyChange("adminid", oldAdminid, adminid);
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        String oldAdminname = this.adminname;
        this.adminname = adminname;
        changeSupport.firePropertyChange("adminname", oldAdminname, adminname);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminid != null ? adminid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admindetails)) {
            return false;
        }
        Admindetails other = (Admindetails) object;
        if ((this.adminid == null && other.adminid != null) || (this.adminid != null && !this.adminid.equals(other.adminid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Admindetails[ adminid=" + adminid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
