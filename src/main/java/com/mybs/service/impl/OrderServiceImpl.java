package com.mybs.service.impl;

import com.mybs.dao.OrderDao;
import com.mybs.dto.OrderDto;
import com.mybs.po.Order;
import com.mybs.service.OrderService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AceCream on 2018/3/15.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderDao orderDao;

    @Override
    public OrderDto getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<OrderDto> findList(OrderDto orderDto) {
        return orderDao.findList(orderDto);
    }

    @Override
    public int countList(OrderDto orderDto) {
        return orderDao.countList(orderDto);
    }

    @Override
    public Long addOrder(Order order) {
        order.setId(UniqueIDUtils.getUniqueID());
        orderDao.addOrder(order);
        return order.getId();
    }

    @Override
    public int updateOrderById(Order order) {
        return orderDao.updateOrderById(order);
    }

    @Override
    public int delOrder(Long id) {
        return orderDao.delOrder(id);
    }
}
