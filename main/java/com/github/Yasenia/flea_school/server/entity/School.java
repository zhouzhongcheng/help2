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
@Table(name = "school")
public class School implements Serializable {

    private static final long serialVersionUID = -4537152108004884398L;

    /**
     * 学校Id
     * */
    @Id
    private Integer id;

    /**
     * 学校名，非空
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
     * 用户列表
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<User> userList;

    /**
     * 通行证列表
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Permit> permitList;
    
    /**
     * 商品列表
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Goods> goodsList;

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
