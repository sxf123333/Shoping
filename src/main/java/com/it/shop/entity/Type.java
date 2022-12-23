package com.it.shop.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2022-12-06 12:23:02
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 740930940045376476L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 类型
     */
    private String tname;



    //批量删除数组
    private Integer [] ids;

    public Integer[] getIds () {
        return ids;
    }

    public void setIds (Integer[] ids) {
        this.ids = ids;
    }


    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getTname () {
        return tname;
    }

    public void setTname (String tname) {
        this.tname = tname;
    }

}

