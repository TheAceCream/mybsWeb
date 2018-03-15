package com.mybs.service.impl;

import com.mybs.dao.ManagerDao;
import com.mybs.po.Manager;
import com.mybs.service.ManagerService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by AceCream on 2018/3/14.
 */
@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerDao managerDao;

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    @Override
    public Manager getManager(Manager manager) {
        return managerDao.getManager(manager);
    }

    /**
     * 查是否存在
     * @param manager
     * @return
     */
    @Override
    public Manager getManagerByUsername(Manager manager) {
        return managerDao.getManagerByUsername(manager);
    }

    /**
     * 添加管理员
     * @param manager
     * @return
     */
    @Override
    public Long addManager(Manager manager) {
        manager.setId(UniqueIDUtils.getUniqueID());
        managerDao.addManager(manager);
        return manager.getId();
    }


}
