package com.it.shop.service;

import com.it.shop.dao.OrderDao;
import com.it.shop.dao.TypeDao;
import com.it.shop.entity.Goods;
import com.it.shop.entity.Order;
import com.it.shop.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    public List<Order> getOrder(Order order){
        return orderDao.quryByParam(order);
    }

    public Integer delete(Integer id){
        return orderDao.deleteById(id);
    }

    public Integer add(Order order){
        return orderDao.insert(order);
    }


    public Integer update(Order order){
        return orderDao.update(order);
    }
}
