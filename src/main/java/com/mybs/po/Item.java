package com.mybs.po;

import java.io.Serializable;

/**
 * Created by AceCream on 2018/3/15.
 */
public class Item implements Serializable{

    /**
     * 商品编号
     */
    private Long id;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 标题
     */
    private String title;

    /**
     * 价格
     */
    private Double price;

    /**
     * 库存
     */
    private Integer store;

    /**
     * 销售量
     */
    private Integer sale;

    /**
     * 种类
     */
    private Integer sort;

    /**
     * 简介
     */
    private String note;

    /**
     * 图片
     */
    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
