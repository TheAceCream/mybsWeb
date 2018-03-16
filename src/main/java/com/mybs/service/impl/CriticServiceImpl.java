package com.mybs.service.impl;

import com.mybs.dao.CriticDao;
import com.mybs.service.CriticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by AceCream on 2018/3/16.
 */
@Service
public class CriticServiceImpl implements CriticService{

    @Resource
    private CriticDao criticDao;



}
