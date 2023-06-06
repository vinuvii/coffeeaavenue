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
@Table(name = "USERLOG", catalog = "", schema = "COFFEE")
@NamedQueries({
    @NamedQuery(name = "Userlog.findAll", query = "SELECT u FROM Userlog u")
    , @NamedQuery(name = "Userlog.findByUserlogid", query = "SELECT u FROM Userlog u WHERE u.userlogid = :userlogid")
    , @NamedQuery(name = "Userlog.findByDate", query = "SELECT u FROM Userlog u WHERE u.date = :date")
    , @NamedQuery(name = "Userlog.findByTime", query = "SELECT u FROM Userlog u WHERE u.time = :time")
    , @NamedQuery(name = "Userlog.findByUpdateduserid", query = "SELECT u FROM Userlog u WHERE u.updateduserid = :updateduserid")
    , @NamedQuery(name = "Userlog.findByUpdatedby", query = "SELECT u FROM Userlog u WHERE u.updatedby = :updatedby")
    , @NamedQuery(name = "Userlog.findByActivity", query = "SELECT u FROM Userlog u WHERE u.activity = :activity")})
public class Userlog implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERLOGID")
    private Integer userlogid;
    @Column(name = "DATE")
    private String date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "UPDATEDUSERID")
    private String updateduserid;
    @Column(name = "UPDATEDBY")
    private String updatedby;
    @Column(name = "ACTIVITY")
    private String activity;

    public Userlog() {
    }

    public Userlog(Integer userlogid) {
        this.userlogid = userlogid;
    }

    public Integer getUserlogid() {
        return userlogid;
    }

    public void setUserlogid(Integer userlogid) {
        Integer oldUserlogid = this.userlogid;
        this.userlogid = userlogid;
        changeSupport.firePropertyChange("userlogid", oldUserlogid, userlogid);
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

    public String getUpdateduserid() {
        return updateduserid;
    }

    public void setUpdateduserid(String updateduserid) {
        String oldUpdateduserid = this.updateduserid;
        this.updateduserid = updateduserid;
        changeSupport.firePropertyChange("updateduserid", oldUpdateduserid, updateduserid);
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        String oldUpdatedby = this.updatedby;
        this.updatedby = updatedby;
        changeSupport.firePropertyChange("updatedby", oldUpdatedby, updatedby);
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
        hash += (userlogid != null ? userlogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlog)) {
            return false;
        }
        Userlog other = (Userlog) object;
        if ((this.userlogid == null && other.userlogid != null) || (this.userlogid != null && !this.userlogid.equals(other.userlogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeavenue.Userlog[ userlogid=" + userlogid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
