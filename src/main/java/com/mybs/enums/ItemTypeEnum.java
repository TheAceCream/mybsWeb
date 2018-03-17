package com.mybs.enums;

/**
 * Created by AceCream on 2018/3/15.
 */
public enum ItemTypeEnum {

    PHONES(101,"手机"),
    GAME_LAB(102,"游戏本"),
    WORK_LAB(103,"商务本"),
    KEYBOARD(104,"键盘"),
    MOUSE(105,"鼠标"),
    HEADPHONE(106,"耳机"),
    OTHERS(107,"其他");

    private Integer code;
    private String itemType;

    public Integer getCode() {
            return code;
        }
    public String getItemType() {
            return itemType;
        }

    ItemTypeEnum(Integer code, String itemType) {
        this.code = code;
        this.itemType = itemType;
    }

    public static ItemTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ItemTypeEnum itemTypeEnum : ItemTypeEnum.values()) {
            if (itemTypeEnum.getCode().equals(code)) {
                return itemTypeEnum;
            }
        }
        return null;
    }

}
