package com.mybs.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AceCream on 2018/3/15.
 */
public class Order implements Serializable{

    private Long id;

    private Long userId;

    private Long itemId;

    private String name;

    private Double price;

    private Integer counts;

    private Integer state;

    private Date creatTime;

    private String other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                ", state=" + state +
                ", creatTime=" + creatTime +
                ", other='" + other + '\'' +
                '}';
    }
}
