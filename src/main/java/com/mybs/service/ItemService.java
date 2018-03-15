package com.mybs.service;

import com.mybs.dto.ItemDto;
import com.mybs.po.Item;

import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
public interface ItemService {
    /**
     * 通过id获取物品
     * @param id
     * @return
     */
    Item getItemById(Long id);

    /**
     * 获取列表
     * @param itemDto
     * @return
     */
    List<Item> findList(ItemDto itemDto);

    /**
     * 列表数
     * @param itemDto
     * @return
     */
    int countList(ItemDto itemDto);

    /**
     * 添加商品
     * @param item
     * @return
     */
    Long addItem(Item item);

    /**
     * 更新商品信息
     * @param item
     * @return
     */
    int updateItemById(Item item);

    /**
     * 商品卖出后
     * 库存 -1
     * 销售量 +1
     * @param item
     * @return
     */
    int updateItemStoreAndSale(Item item);

}
