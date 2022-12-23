package com.it.shop.entity;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2022-12-06 12:10:43
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -17906021116204522L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 商品名称
     */
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
     * 图片
     */
 

    //类型名称
    private String tname;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //批量删除数组
    private Integer [] ids;

    public Integer[] getIds () {
        return ids;
    }

    public void setIds (Integer[] ids) {
        this.ids = ids;
    }


    public String getTname () {
        return tname;
    }

    public void setTname (String tname) {
        this.tname = tname;
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

    

}

