package com.mybs.service.impl;

import com.mybs.dao.ItemDao;
import com.mybs.dto.ItemDto;
import com.mybs.enums.ItemTypeEnum;
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
    public ItemDto getItemById(Long id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<ItemDto> findList(ItemDto itemDto) {
        List<ItemDto> itemDtos = itemDao.findList(itemDto);
        for (ItemDto temp : itemDtos) {
            temp.setSortName(ItemTypeEnum.getByCode(temp.getSort()).getItemType());
        }
        return itemDtos;
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
    public int delItem(Long id) {
        return itemDao.delItem(id);
    }

    /**
     * 商品卖出后
     * 库存 -1
     * 销售量 +1
     * @param itemId
     * @return
     */
    @Override
    public int updateItemStoreAndSale(Long itemId) {
        ItemDto itemDto = itemDao.getItemById(itemId);
        itemDto.setSale(itemDto.getSale()+1);
        if (!itemDto.getStore().equals(0)){
            itemDto.setStore(itemDto.getStore()-1);
        }else {
            return 0;
        }
        return 1;
    }

    @Override
    public List<ItemDto> getItemListBySale(ItemDto itemDto) {
        List<ItemDto> itemDtos = itemDao.getItemListBySale(itemDto);
        for (ItemDto temp : itemDtos) {
            temp.setSortName(ItemTypeEnum.getByCode(temp.getSort()).getItemType());
        }
        return itemDtos;
    }

    @Override
    public List<ItemDto> getItemListByStar(ItemDto itemDto) {
        List<ItemDto> itemDtos = itemDao.getItemListByStar(itemDto);
        for (ItemDto temp : itemDtos) {
            temp.setSortName(ItemTypeEnum.getByCode(temp.getSort()).getItemType());
        }
        return itemDtos;
    }


}
