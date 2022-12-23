package com.it.shop.entity;

import java.io.Serializable;

/**
 * (Car)实体类
 *
 * @author makejava
 * @since 2022-12-14 15:08:10
 */
public class Car implements Serializable {
    private static final long serialVersionUID = 231900851273212637L;
    /**
     * 主键ID
     */
    private Integer id;

    private String name;
    /**
     * 类型ID
     */
    private Integer tid;
    /**
     * 价格
     */
    private Double price;
    /**
     * 商品ID
     */
    private Integer gid;
    private double weight;
    
    private Integer uid;
    /**
     * 0  是未购买  1是未购买
     */
    private Integer state;
    //批量删除数组
    private Integer [] ids;

    public static long getSerialVersionUID () {
        return serialVersionUID;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Integer getTid () {
        return tid;
    }

    public void setTid (Integer tid) {
        this.tid = tid;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public Integer getGid () {
        return gid;
    }

    public void setGid (Integer gid) {
        this.gid = gid;
    }

    public double getWeight () {
        return weight;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }

    public Integer getUid () {
        return uid;
    }

    public void setUid (Integer uid) {
        this.uid = uid;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public Integer[] getIds () {
        return ids;
    }

    public void setIds (Integer[] ids) {
        this.ids = ids;
    }
}

