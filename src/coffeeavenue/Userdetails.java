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
@Table(name = "USERDETAILS", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u")
    , @NamedQuery(name = "Userdetails.findByUserid", query = "SELECT u FROM Userdetails u WHERE u.userid = :userid")
    , @NamedQuery(name = "Userdetails.findByUsername", query = "SELECT u FROM Userdetails u WHERE u.username = :username")
    , @NamedQuery(name = "Userdetails.findByPassword", query = "SELECT u FROM Userdetails u WHERE u.password = :password")})
public class Userdetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private String userid;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    public Userdetails() {
    }

    public Userdetails(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        String oldUserid = this.userid;
        this.userid = userid;
        changeSupport.firePropertyChange("userid", oldUserid, userid);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
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
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Userdetails[ userid=" + userid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
