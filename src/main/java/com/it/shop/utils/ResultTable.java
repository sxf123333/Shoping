package com.it.shop.utils;


/*
* code  100失败  200失败
* msg  成功 失败
* date 数据存储到data当中
* */
public class ResultTable {
    private String code;//100失败  200失败
    private String msg;//成功 失败
    private Object date;//存储数据

    public ResultTable() {
    }

    public ResultTable(String code, String msg, Object date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public String toString () {
        return "ResultTable{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getMsg () {
        return msg;
    }

    public void setMsg (String msg) {
        this.msg = msg;
    }

    public Object getDate () {
        return date;
    }

    public void setDate (Object date) {
        this.date = date;
    }
}
