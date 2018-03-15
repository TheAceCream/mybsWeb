package com.mybs.service.impl;

import com.mybs.dao.ItemDao;
import com.mybs.dto.ItemDto;
import com.mybs.po.Item;
import com.mybs.service.ItemService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Resource
    private ItemDao itemDao;

    @Override
    public Item getItemById(Long id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<Item> findList(ItemDto itemDto) {
        return itemDao.findList(itemDto);
    }

    @Override
    public int countList(ItemDto itemDto) {
        return itemDao.countList(itemDto);
    }

    @Override
    public Long addItem(Item item) {
        item.setId(UniqueIDUtils.getUniqueID());
        itemDao.addItem(item);
        return item.getId();
    }

    @Override
    public int updateItemById(Item item) {
        return itemDao.updateItemById(item);
    }

    @Override
    public int updateItemStoreAndSale(Item item) {

        return 0;
    }


}
