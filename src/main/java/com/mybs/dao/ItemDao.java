package com.mybs.dao;

import com.mybs.dto.ItemDto;
import com.mybs.po.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Repository
public interface ItemDao {

    /**
     * 通过id获取物品
     * @param id
     * @return
     */
    ItemDto getItemById(Long id);

    /**
     * 获取列表
     * @param itemDto
     * @return
     */
    List<ItemDto> findList(ItemDto itemDto);

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
     * 删除商品
     * @param id
     * @return
     */
    int delItem(Long id);


    /**
     * 商品卖出后
     * 库存 -1
     * 销售量 +1
     * @param itemId
     * @return
     */
    int updateItemStoreAndSale(Long itemId);

    /**
     * 根据销量去排序商品
     * @param itemDto
     * @return
     */
    List<ItemDto> getItemListBySale(ItemDto itemDto);

    /**
     * 根据评价去排序商品
     * @param itemDto
     * @return
     */
    List<ItemDto> getItemListByStar(ItemDto itemDto);
}
