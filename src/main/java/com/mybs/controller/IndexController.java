package com.mybs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AceCream on 2018/3/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(){ return "home"; }

    @RequestMapping("/managerHome")
    public String toManagerHome(){
        return "home";
    }

    @RequestMapping("/tempItemList")
    public String toItemList(){
        return "itemlist";
    }

}
