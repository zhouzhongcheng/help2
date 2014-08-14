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
@Table(name = "collect_goods")
public class CollectGoods implements Serializable {

    private static final long serialVersionUID = -4605301094710253050L;

    /**
     * 收藏Id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 收藏用户，非空
     * */
    @ManyToOne
    @JoinColumn(name = "collect_user", nullable = false)
    private User collectUser;

    /**
     * 收藏商品，非空
     * */
    @ManyToOne
    @JoinColumn(name = "collected_goods", nullable = false)
    private Goods collectedGoods;

    /**
     * 收藏日期，非空
     * */
    @Column(name = "collect_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectDate;

    /**
     * getter & setter
     * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCollectUser() {
        return collectUser;
    }

    public void setCollectUser(User collectUser) {
        this.collectUser = collectUser;
    }

    public Goods getCollectedGoods() {
        return collectedGoods;
    }

    public void setCollectedGoods(Goods collectedGoods) {
        this.collectedGoods = collectedGoods;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

}
