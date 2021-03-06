package com.mybs.dto;

import com.mybs.utils.Pager;

/**
 * Created by AceCream on 2018/3/15.
 */
public class ItemDto {

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
     * 种类名称
     */
    private String sortName;

    /**
     * 简介
     */
    private String note;

    /**
     * 图片
     */
    private String img;

    /**
     * 综合评分
     */
    private Double star;

    /**
     * 评论数量
     */
    private Integer criticCount;

    /**
     * 分页
     */
    private Pager pager;

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

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
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

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public Integer getCriticCount() {
        return criticCount;
    }

    public void setCriticCount(Integer criticCount) {
        this.criticCount = criticCount;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", store=" + store +
                ", sale=" + sale +
                ", sort=" + sort +
                ", sortName='" + sortName + '\'' +
                ", note='" + note + '\'' +
                ", img='" + img + '\'' +
                ", star=" + star +
                ", criticCount=" + criticCount +
                ", pager=" + pager +
                '}';
    }
}
