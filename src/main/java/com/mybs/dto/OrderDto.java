package com.mybs.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mybs.utils.Pager;
import com.mybs.utils.StringToDateDeserializer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AceCream on 2018/3/15.
 */
public class OrderDto implements Serializable{

    private Long id;

    private Long userId;

    private Long itemId;

    private String itemStr;

    private String name;

    private Double price;

    private Integer counts;

    private Byte state;

    private String stateStr;

    private Date creatTime;

    private String other;

    private Pager pager;

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

    public String getItemStr() {
        return itemStr;
    }

    public void setItemStr(String itemStr) {
        this.itemStr = itemStr;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    @JsonDeserialize(using = StringToDateDeserializer.class)
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
