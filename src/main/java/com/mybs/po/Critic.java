package com.mybs.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AceCream on 2018/3/16.
 */
public class Critic implements Serializable{

    /**
     * 评论id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 用户id
     */
    private Long userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
