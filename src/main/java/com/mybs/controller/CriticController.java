package com.mybs.controller;

import com.mybs.service.CriticService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by AceCream on 2018/3/16.
 */
@Controller
@RequestMapping("critic")
public class CriticController {

    @Resource
    private CriticService criticService;



}
