package com.mybs.controller;

import com.mybs.dao.ItemDao;
import com.mybs.dto.ItemDto;
import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Item;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;


    /**
     * 添加商品
     * @param item
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addItem", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap addItem(@RequestBody Item item, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Long itemId = itemService.addItem(item);
            resultMap.setData(itemId);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 获取商品详情
     * @param itemId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemDetail", method = RequestMethod.GET, produces = "application/json")
    public BaseResultMap getItemDetail(@RequestParam("itemId") Long itemId, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Item item = itemService.getItemById(itemId);
            resultMap.setData(item);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 获取商品列表
     * @param itemDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemList", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap getItemList(@RequestBody ItemDto itemDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            List<Item> itemList = itemService.findList(itemDto);
            resultMap.setData(itemList);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 修改商品信息
     * @param item
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateItem", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap updateItem(@RequestBody Item item, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            int i = itemService.updateItemById(item);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }




}