package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "goods_type")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 103701491439503449L;

    /**
     * 商品分类Id，自动生成
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 分类名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父级商品分类
     * */
    @ManyToOne
    @JoinColumn(name = "parrent_goods_type_id")
    private GoodsType parrentGoodsType;

    /**
     * 子级商品分类
     * */
    @OneToMany(mappedBy = "parrentGoodsType")
    private List<GoodsType> childrenGoodsType;

    /**
     * 商品列表
     * */
    @OneToMany(mappedBy = "goodsType")
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

    public GoodsType getParrentGoodsType() {
        return parrentGoodsType;
    }

    public void setParrentGoodsType(GoodsType parrentGoodsType) {
        this.parrentGoodsType = parrentGoodsType;
    }

    public List<GoodsType> getChildrenGoodsType() {
        return childrenGoodsType;
    }

    public void setChildrenGoodsType(List<GoodsType> childrenGoodsType) {
        this.childrenGoodsType = childrenGoodsType;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
