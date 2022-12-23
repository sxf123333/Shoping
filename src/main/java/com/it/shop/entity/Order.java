package com.it.shop.entity;

import java.util.Date;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2022-12-12 20:17:20
 */

public class Order implements Serializable {
    private static final long serialVersionUID = -65921205904902646L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * 地址
     */
    private String address;
    /**
     * 日期
     */
    private Date date;
    /**
     * 手机号
     */
    private String iphone;
    /**
     * 商品id
     */
    private Integer gid;

    /**
     * 用户名
     */
    
    private Goods goods;

    private User user;

    private Type type;

    private Car car;


    public Car getCar () {
        return car;
    }

    public void setCar (Car car) {
        this.car = car;
    }

    public Type getType () {
        return type;
    }

    public void setType (Type type) {
        this.type = type;
    }

    public Goods getGoods () {
        return goods;
    }

    public void setGoods (Goods goods) {
        this.goods = goods;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUid () {
        return uid;
    }

    public void setUid (Integer uid) {
        this.uid = uid;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public String getIphone () {
        return iphone;
    }

    public void setIphone (String iphone) {
        this.iphone = iphone;
    }

    public Integer getGid () {
        return gid;
    }

    public void setGid (Integer gid) {
        this.gid = gid;
    }

}

