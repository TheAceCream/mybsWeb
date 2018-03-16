package com.mybs.dto;

import com.mybs.utils.Pager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AceCream on 2018/3/16.
 */
public class CriticDto implements Serializable{

    /**
     * 评论id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品名
     */
    private String itemName;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 评级
     */
    private Byte star;
    /**
     * 评论内容
     */
    private String note;

    /**
     * 评价时间
     */
    private Date creatTime;

    private Pager pager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStar() {
        return star;
    }

    public void setStar(Byte star) {
        this.star = star;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    @Override
    public String toString() {
        return "CriticDto{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", star=" + star +
                ", note='" + note + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }
}
