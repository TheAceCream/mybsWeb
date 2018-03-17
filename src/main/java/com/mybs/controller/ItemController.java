package com.mybs.controller;

import com.mybs.dto.ItemDto;
import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Item;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

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
    public BaseResultMap addItem(@RequestParam("pictureFile") MultipartFile pictureFile, @RequestBody Item item, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            //取得根目录路径
            /**
             * /Users/AceCream/IdeaProjects/mybsweb/target/web-ssm/
             */
            String rootPath = getClass().getResource("../../../../../").getFile().toString() + "img";
            String fileName = "";
            //图片上传！
            if (!pictureFile.isEmpty()) {
                //生成uuid作为文件名称
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //获得文件类型
                String contentType = pictureFile.getContentType();
                //获得文件后缀名称
                String imageName = contentType.substring(contentType.indexOf("/") + 1);
                fileName = uuid + "." + imageName;
                File file = new File(rootPath, fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                pictureFile.transferTo(file);
            }
            //添加图片地址
            item.setImg(fileName);
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
            ItemDto itemDto = itemService.getItemById(itemId);
            resultMap.setData(itemDto);
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
            List<ItemDto> itemDtoList = itemService.findList(itemDto);
            resultMap.setData(itemDtoList);
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

    /**
     * 删除商品
     * @param itemDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delItem", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap delItem(@RequestBody ItemDto itemDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Long itemId = itemDto.getId();
            if (itemId!=null){
                itemService.delItem(itemId);
                resultMap.setAPICode(APICode.OK);
            }else {
                throw new Exception();
            }
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }





}