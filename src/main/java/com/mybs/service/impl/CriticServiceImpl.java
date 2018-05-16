package com.mybs.service.impl;

import com.mybs.dao.CriticDao;
import com.mybs.dao.ItemDao;
import com.mybs.dao.UserDao;
import com.mybs.dto.CriticDto;
import com.mybs.dto.ItemDto;
import com.mybs.po.Critic;
import com.mybs.po.Item;
import com.mybs.po.User;
import com.mybs.service.CriticService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AceCream on 2018/3/16.
 */
@Service
public class CriticServiceImpl implements CriticService{

    @Resource
    private CriticDao criticDao;
    @Resource
    private ItemDao itemDao;
    @Resource
    private UserDao userDao;


    @Override
    public CriticDto getCriticById(Long id) {
        return criticDao.getCriticById(id);
    }

    @Override
    public List<CriticDto> findList(CriticDto criticDto) {
        List<CriticDto> criticDtoList = criticDao.findList(criticDto);
        List<CriticDto> list = new ArrayList<>();
        for (CriticDto temp : criticDtoList) {
            ItemDto itemDto = itemDao.getItemById(temp.getItemId());
            User user = userDao.getUserById(temp.getUserId());
            temp.setItemName(itemDto.getItemName());
            temp.setUsername(user.getUsername());
            temp.setMobile(user.getMobile());
            list.add(temp);
        }
        return list;
    }

    @Override
    public int countList(CriticDto criticDto) {
        return criticDao.countList(criticDto);
    }

    /**
     * 添加评论
     * @param critic
     * @return
     */
    @Override
    public Long addCritic(Critic critic) {
        Long itemId = critic.getItemId();
        ItemDto itemDto = itemDao.getItemById(itemId);
        double star = 0;
        if (itemDto.getStar()!=null){
            star = itemDto.getStar();
        }
        double old = star * itemDto.getCriticCount();
        double result = (old+critic.getStar())/(itemDto.getCriticCount()+1);
        Item item = new Item();
        item.setId(itemId);
        item.setCriticCount(itemDto.getCriticCount()+1);
        item.setStar(result);
        critic.setId(UniqueIDUtils.getUniqueID());
        critic.setCreatTime(new Timestamp(System.currentTimeMillis()));
        //添加评论
        criticDao.addCritic(critic);
        //更改商品 表中 评论的分数和数量
        itemDao.updateItemById(item);
        return critic.getId();
    }

    @Override
    public int updateCriticById(Critic critic) {
        return criticDao.updateCriticById(critic);
    }
}
