package com.mybs.service;

import com.mybs.po.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by AceCream on 2018/3/14.
 */
public interface ManagerService {

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    Manager getManager(Manager manager);

    /**
     * 是否存在
     * @param manager
     * @return
     */
    Manager getManagerByUsername(Manager manager);

    /**
     * 添加管理员
     * @param manager
     * @return
     */
    Long addManager(Manager manager);

}
