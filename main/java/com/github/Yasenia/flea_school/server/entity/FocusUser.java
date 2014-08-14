package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "focus_user")
public class FocusUser implements Serializable {

    private static final long serialVersionUID = -5245145594979421162L;

    /**
     * 关注Id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 粉丝用户，非空
     * */
    @ManyToOne
    @JoinColumn(name = "fans_user", nullable = false)
    private User fansUser;

    /**
     * 关注用户，非空
     * */
    @ManyToOne
    @JoinColumn(name = "focus_user", nullable = false)
    private User focusUser;

    /**
     * 关注日期，非空
     * */
    @Column(name = "focus_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date focusDate;

    /**
     * getter & setter
     * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFansUser() {
        return fansUser;
    }

    public void setFansUser(User fansUser) {
        this.fansUser = fansUser;
    }

    public User getFocusUser() {
        return focusUser;
    }

    public void setFocusUser(User focusUser) {
        this.focusUser = focusUser;
    }

    public Date getFocusDate() {
        return focusDate;
    }

    public void setFocusDate(Date focusDate) {
        this.focusDate = focusDate;
    }

}
