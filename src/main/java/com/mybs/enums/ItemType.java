package com.mybs.enums;

/**
 * Created by AceCream on 2018/3/15.
 */
public enum ItemType {

    PHONES(101,"手机"),
    GAME_LAB(102,"游戏本"),
    WORK_LAB(103,"商务本"),
    KEYBOARD(104,"键盘"),
    MOUSE(105,"鼠标"),
    HEADPHONE(106,"耳机"),
    COMPONENT(107,"台式组件"),
    DISPLAY(108,"显示器"),
    OTHERS(109,"其他");

    private Integer code;
    private String itemType;

    public Integer getCode() {
            return code;
        }
    public String getItemType() {
            return itemType;
        }

    ItemType(Integer code, String itemType) {
        this.code = code;
        this.itemType = itemType;
    }

    public static ItemType getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getCode().equals(code)) {
                return itemType;
            }
        }
        return null;
    }

}
