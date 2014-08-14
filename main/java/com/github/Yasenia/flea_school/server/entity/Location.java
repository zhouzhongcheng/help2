package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "location")
public class Location implements Serializable {

    private static final long serialVersionUID = -8539293849907405454L;

    /**
     * 地区Id
     * */
    @Id
    private Integer id;

    /**
     * 地区名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父级地区
     * */
    @ManyToOne
    @JoinColumn(name = "parrent_location_id")
    private Location parrentLocation;

    /**
     * 子级地区
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "parrentLocation")
    private List<Location> childrenLocation;

    /**
     * 子级学校
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "parrentLocation")
    private List<School> childrenSchool;

    /**
     * 用户列表
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<User> userList;

    /**
     * getter & setter
     * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getParrentLocation() {
        return parrentLocation;
    }

    public void setParrentLocation(Location parrentLocation) {
        this.parrentLocation = parrentLocation;
    }

    public List<Location> getChildrenLocation() {
        return childrenLocation;
    }

    public void setChildrenLocation(List<Location> childrenLocation) {
        this.childrenLocation = childrenLocation;
    }

    public List<School> getChildrenSchool() {
        return childrenSchool;
    }

    public void setChildrenSchool(List<School> childrenSchool) {
        this.childrenSchool = childrenSchool;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
