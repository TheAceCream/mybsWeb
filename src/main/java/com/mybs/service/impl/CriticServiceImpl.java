package com.mybs.service.impl;

import com.mybs.dao.CriticDao;
import com.mybs.dao.ItemDao;
import com.mybs.dao.UserDao;
import com.mybs.dto.CriticDto;
import com.mybs.dto.ItemDto;
import com.mybs.po.Critic;
import com.mybs.po.User;
import com.mybs.service.CriticService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
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
        for (CriticDto temp : criticDtoList) {
            ItemDto itemDto = itemDao.getItemById(criticDto.getItemId());
            User user = userDao.getUserById(criticDto.getUserId());
            temp.setItemName(itemDto.getItemName());
            temp.setUsername(user.getUsername());
        }
        return criticDao.findList(criticDto);
    }

    @Override
    public int countList(CriticDto criticDto) {
        return criticDao.countList(criticDto);
    }

    @Override
    public Long addCritic(Critic critic) {
        critic.setId(UniqueIDUtils.getUniqueID());
        critic.setCreatTime(new Timestamp(System.currentTimeMillis()));
        return critic.getId();
    }

    @Override
    public int updateCriticById(Critic critic) {
        return criticDao.updateCriticById(critic);
    }
}
