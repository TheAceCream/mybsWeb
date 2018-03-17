package com.mybs.enums;

/**
 * Created by AceCream on 2018/3/15.
 */
public enum  OrderStateEnum {

    PAYED(101,"已支付"),
    SALED(102,"已发货"),
    FINISH(103,"确认收货");

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
