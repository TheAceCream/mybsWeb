package com.mybs.controller;

import com.mybs.dto.ItemDto;
import com.mybs.enums.ItemTypeEnum;
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
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ItemEvent;
import java.io.File;
import java.text.DecimalFormat;
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
     * @param request
     * @return
     */
    @RequestMapping(value = "addItem", method = RequestMethod.POST, produces = "application/json")
    public String addItem(@RequestParam("pictureFile") MultipartFile pictureFile, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            //取得根目录路径
            /**
             * /Users/AceCream/IdeaProjects/mybsweb/target/web-ssm/
             */
            Item item = new Item();
            item.setItemName(request.getParameter("itemName"));
            item.setTitle(request.getParameter("title"));
            DecimalFormat df = new DecimalFormat("######0.00");
            String price = request.getParameter("price");
            String store = request.getParameter("store");
            String sale = (request.getParameter("sale"));
            if (price!=null && price!=""){
                item.setPrice(Double.valueOf(df.format(Double.valueOf(price))));
            }
            if (store!=null && store!=""){
                item.setStore(Integer.valueOf(store));
            }
            if (sale!=null && sale!=""){
                item.setSale(Integer.valueOf(sale));
            }
            item.setSort(Integer.valueOf(request.getParameter("sort")));
            item.setNote(request.getParameter("note"));
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
        return "itemlist";
    }

    /**
     * 修改商品信息
     * @param request
     * @return
     */
    @RequestMapping(value = "updateItem", method = RequestMethod.POST, produces = "application/json")
    public String updateItem(@RequestParam("pictureFile") MultipartFile pictureFile, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Item item = new Item();
            item.setId(Long.parseLong(request.getParameter("id")));
            item.setItemName(request.getParameter("itemName"));
            item.setTitle(request.getParameter("title"));
            DecimalFormat df = new DecimalFormat("######0.00");
            String price = request.getParameter("price");
            String store = request.getParameter("store");
            String sale = (request.getParameter("sale"));
            if (price!=null && price!=""){
                item.setPrice(Double.valueOf(df.format(Double.valueOf(price))));
            }
            if (store!=null && store!=""){
                item.setStore(Integer.valueOf(store));
            }
            if (sale!=null && sale!=""){
                item.setSale(Integer.valueOf(sale));
            }
            item.setSort(Integer.valueOf(request.getParameter("sort")));
            item.setNote(request.getParameter("note"));
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
                //添加图片地址
                item.setImg(fileName);
            }
            int i = itemService.updateItemById(item);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return "itemlist";
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
            if (itemDto.getSort()!=null){
                itemDto.setSortName(ItemTypeEnum.getByCode(itemDto.getSort()).getItemType());
            }
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

    //后端获取商品详情
    @RequestMapping(value = "getItemDetailByMa" , method = RequestMethod.GET)
    public String getItemDetailByMa(HttpServletRequest request, HttpServletResponse response){
        Long id= Long.parseLong(request.getParameter("itemId"));
        ItemDto itemDto = itemService.getItemById(id);
        request.setAttribute("olditem",itemDto);
        System.out.println(itemDto);
        return "updateitem";
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
     * 获取商品列表 通过销量排序 从高到低
     * @param itemDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemListBySale", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap getItemListBySale(@RequestBody ItemDto itemDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            List<ItemDto> itemDtoList = itemService.getItemListBySale(itemDto);
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
     * 获取商品列表 通过评价排序 从高到低
     * @param itemDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemListByStar", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap getItemListByStar(@RequestBody ItemDto itemDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            List<ItemDto> itemDtoList = itemService.getItemListByStar(itemDto);
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
     * 删除商品
     * @param request
     * @return
     */
    @RequestMapping(value = "delItem", method = RequestMethod.GET)
    public BaseResultMap delItem(HttpServletRequest request,HttpServletResponse response) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Long itemId = Long.parseLong(request.getParameter("itemId"));
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

    @ResponseBody
    @RequestMapping(value = "getItemCount",method = RequestMethod.GET)
    public String getCriticCount(HttpServletRequest request){
        ItemDto itemDto = new ItemDto();
        int count = itemService.countList(itemDto);
        return count+"";
    }



}