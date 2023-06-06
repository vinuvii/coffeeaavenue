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
@Table(name = "LOGINLOG", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Loginlog.findAll", query = "SELECT l FROM Loginlog l")
    , @NamedQuery(name = "Loginlog.findByLoginid", query = "SELECT l FROM Loginlog l WHERE l.loginid = :loginid")
    , @NamedQuery(name = "Loginlog.findByDate", query = "SELECT l FROM Loginlog l WHERE l.date = :date")
    , @NamedQuery(name = "Loginlog.findByTime", query = "SELECT l FROM Loginlog l WHERE l.time = :time")
    , @NamedQuery(name = "Loginlog.findByUser", query = "SELECT l FROM Loginlog l WHERE l.user = :user")
    , @NamedQuery(name = "Loginlog.findByUserrole", query = "SELECT l FROM Loginlog l WHERE l.userrole = :userrole")
    , @NamedQuery(name = "Loginlog.findByActivity", query = "SELECT l FROM Loginlog l WHERE l.activity = :activity")})
public class Loginlog implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOGINID")
    private Integer loginid;
    @Column(name = "DATE")
    private String date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "USER_")
    private String user;
    @Column(name = "USERROLE")
    private String userrole;
    @Column(name = "ACTIVITY")
    private String activity;

    public Loginlog() {
    }

    public Loginlog(Integer loginid) {
        this.loginid = loginid;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        Integer oldLoginid = this.loginid;
        this.loginid = loginid;
        changeSupport.firePropertyChange("loginid", oldLoginid, loginid);
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        String oldUser = this.user;
        this.user = user;
        changeSupport.firePropertyChange("user", oldUser, user);
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        String oldUserrole = this.userrole;
        this.userrole = userrole;
        changeSupport.firePropertyChange("userrole", oldUserrole, userrole);
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        String oldActivity = this.activity;
        this.activity = activity;
        changeSupport.firePropertyChange("activity", oldActivity, activity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginid != null ? loginid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginlog)) {
            return false;
        }
        Loginlog other = (Loginlog) object;
        if ((this.loginid == null && other.loginid != null) || (this.loginid != null && !this.loginid.equals(other.loginid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Loginlog[ loginid=" + loginid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
