package com.mybs.enums;

/**
 * Created by AceCream on 2018/3/15.
 */
public enum  OrderStateEnum {

    READY(101,"待付款"),
    PAYED(102,"已付款"),
    SALED(103,"已发货"),
    FINISH(104,"确认收货");

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    OrderStateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStateEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (OrderStateEnum orderStateEnum : OrderStateEnum.values()) {
            if (orderStateEnum.getCode().equals(code)) {
                return orderStateEnum;
            }
        }
        return null;
    }

}
