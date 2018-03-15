package com.mybs.dao;

import com.mybs.dto.OrderDto;
import com.mybs.po.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Repository
public interface OrderDao {

    /**
     * 通过id获取订单
     * @param id
     * @return
     */
    OrderDto getOrderById(Long id);

    /**
     * 获取订单列表
     * @param orderDto
     * @return
     */
    List<OrderDto> findList(OrderDto orderDto);

    /**
     * 获取订单数
     * @param orderDto
     * @return
     */
    int countList(OrderDto orderDto);

    /**
     * 添加订单
     * @param order
     * @return
     */
    Long addOrder(Order order);

    /**
     * 更改订单信息
     * @return
     */
    int updateOrderById(Order order);

    /**
     * 删除订单
     * @param id
     * @return
     */
    int delOrder(Long id);

}
