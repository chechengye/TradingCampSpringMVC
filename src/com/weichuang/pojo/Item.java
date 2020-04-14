package com.weichuang.pojo;

import java.io.Serializable;

public class Item implements Serializable{
    private int id;
    private String price;
    private String name;
    private String detail;
    private String createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
