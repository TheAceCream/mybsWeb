package com.mybs.controller;

import com.mybs.dto.OrderDto;
import com.mybs.enums.OrderStateEnum;
import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Order;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 添加订单
     *
     * @param order
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addOrder", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap addOrder(@RequestBody Order order, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Long orderId = orderService.addOrder(order);
            resultMap.setData(orderId);
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
     *
     * @param orderId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemDetail", method = RequestMethod.GET, produces = "application/json")
    public BaseResultMap getItemDetail(@RequestParam("orderId") Long orderId, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            OrderDto orderDto = orderService.getOrderById(orderId);
            resultMap.setData(orderDto);
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
     * 获取订单列表
     *
     * @param orderDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getItemList", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap getItemList(@RequestBody OrderDto orderDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            List<OrderDto> orderDtoList = orderService.findList(orderDto);
            resultMap.setData(orderDtoList);
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
     * 更新订单信息
     * @param order
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateOrder", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap updateOrder(@RequestBody Order order, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            int i = orderService.updateOrderById(order);
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
     * 删除订单
     * @param orderId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delOrder", method = RequestMethod.GET, produces = "application/json")
    public BaseResultMap delOrder(@RequestParam("orderId") Long orderId, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            int i = orderService.delOrder(orderId);
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
     * 变更订单状态
     * @param orderId
     * @param state
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "changeOrderState", method = RequestMethod.GET, produces = "application/json")
    public BaseResultMap changeOrderState(@RequestParam("orderId") Long orderId,@RequestParam("state") Integer state, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            if (state.equals(OrderStateEnum.READY)){
                //待付款
                System.out.println("变更为待付款");
            }else if (state.equals(OrderStateEnum.PAYED)){
                //已付款
                System.out.println("变更为已付款");
            }else if (state.equals(OrderStateEnum.SALED)){
                //已发货
                System.out.println("变更为已发货");
            }else if (state.equals(OrderStateEnum.FINISH)){
                //确认收货
                System.out.println("变更为确认收货");
            }
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