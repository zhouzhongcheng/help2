package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = -715696906958331964L;

    public static final int SELLING = 0;
    public static final int SOLD_OUT = 1;
    public static final int OUT_DATE = 2;
    public static final int CANCEL = 3;

    /**
     * 商品Id，自动生成
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 商品名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 商品价格，非空
     * */
    @Column(name = "price", nullable = false)
    private Double price;

    /**
     * 商品种类，非空
     * */
    @ManyToOne
    @JoinColumn(name = "goods_type_id", nullable = false)
    private GoodsType goodsType;

    /**
     * 信息发布学校，非空
     * */
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    /**
     * 商品描述
     * */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * 商品图片
     * */
    @Column(name = "picture")
    private String picture;

    /**
     * 商品状态，非空
     * */
    @Column(name = "state", nullable = false)
    private Integer state;

    /**
     * 发布日期
     * */
    @Column(name = "release_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    /**
     * 修改日期
     * */
    @Column(name = "alter_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date alterDate;

    /**
     * 有效日期
     * */
    @Column(name = "valid_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date validDate;

    /**
     * 卖家，非空
     * */
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    /**
     * 买家
     * */
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    /**
     * 卖家评价
     * */
    @Column(name = "seller_comment")
    private String sellerComment;

    /**
     * 买家评价
     * */
    @Column(name = "buyer_comment")
    private String buyerComment;

    /**
     * 卖家评级
     * */
    @Column(name = "seller_comment_grade")
    private Integer sellerCommentGrade;

    /**
     * 买家评级
     * */
    @Column(name = "buyer_comment_grade")
    private Integer buyerCommentGrade;

    /**
     * 收藏用户列表
     * */
    @OneToMany(mappedBy = "collectedGoods")
    private List<CollectGoods> collectListAsCollected;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getAlterDate() {
        return alterDate;
    }

    public void setAlterDate(Date alterDate) {
        this.alterDate = alterDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public Integer getSellerCommentGrade() {
        return sellerCommentGrade;
    }

    public void setSellerCommentGrade(Integer sellerCommentGrade) {
        this.sellerCommentGrade = sellerCommentGrade;
    }

    public Integer getBuyerCommentGrade() {
        return buyerCommentGrade;
    }

    public void setBuyerCommentGrade(Integer buyerCommentGrade) {
        this.buyerCommentGrade = buyerCommentGrade;
    }

    public List<CollectGoods> getCollectListAsCollected() {
        return collectListAsCollected;
    }

    public void setCollectListAsCollected(
            List<CollectGoods> collectListAsCollected) {
        this.collectListAsCollected = collectListAsCollected;
    }

}
